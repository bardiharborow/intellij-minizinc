package com.bardiharborow.minizinc.language.uml.model

import com.bardiharborow.minizinc.language.MiniZincSymbol
import com.bardiharborow.minizinc.language.psi.*
import com.bardiharborow.minizinc.language.psi.impl.MiniZincParameterImpl
import com.bardiharborow.minizinc.language.uml.MiniZincDiagramPresentationModel
import com.bardiharborow.minizinc.language.uml.MiniZincDiagramProvider
import com.intellij.diagram.DiagramDataModel
import com.intellij.diagram.DiagramEdge
import com.intellij.diagram.DiagramNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.impl.SimpleDataContext
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.ModificationTracker
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import com.intellij.psi.util.childrenOfType
import com.intellij.util.Alarm

class MiniZincDiagramDataModel(
    project: Project,
    element: PsiElement?,
    file: VirtualFile?,
    provider: MiniZincDiagramProvider,
) : DiagramDataModel<PsiElement>(project, provider) {
    private val myNodes = mutableSetOf<MiniZincDiagramNode>()
    private val myEdges = mutableSetOf<MiniZincDiagramEdge>()
    private val myElementsLock = Object()
    private val myAlarm: Alarm

    init {
        originalElement = element
        myAlarm = Alarm()
    }

    override fun isPsiListener(): Boolean = true

    override fun getModificationTracker(): ModificationTracker {
        return PsiManager.getInstance(project).modificationTracker
    }

    override fun getNodes(): Collection<MiniZincDiagramNode> = myNodes

    override fun getNodeName(node: DiagramNode<PsiElement>): String {
        return provider.elementManager.getElementTitle(node.identifyingElement) ?: ""
    }

    override fun addElement(element: PsiElement?): MiniZincDiagramNode? {
        if (element == null) return null

        val node = MiniZincDiagramNode(element, provider)
        synchronized(myElementsLock) { myNodes.add(node) }

        if (element is MiniZincParameter) {
            val declaration = element.parent
            val declarationNode = MiniZincDiagramNode(declaration, provider)

            createEdge(declarationNode, node)
        }

        // TODO: rebuild all the things
        if (!this.myAlarm.isDisposed) {
            this.myAlarm.cancelAllRequests()
            this.myAlarm.addRequest(
                Runnable {
                    (this.builder.presentationModel as MiniZincDiagramPresentationModel).refresh()
                },
                100,
            )
        }

        return node
    }

    override fun removeNode(node: DiagramNode<PsiElement>) {
        synchronized(myElementsLock) { myNodes.remove(node) }
    }

    override fun getEdges(): Collection<DiagramEdge<PsiElement>> = myEdges

    override fun createEdge(
        from: DiagramNode<PsiElement>,
        to: DiagramNode<PsiElement>,
    ): DiagramEdge<PsiElement> {
        val edge =
            MiniZincDiagramEdge(
                from,
                to,
                provider.relationshipManager.getDependencyInfo(
                    from.identifyingElement,
                    to.identifyingElement,
                    null,
                )!!,
            )

        synchronized(myElementsLock) { myEdges.add(edge) }

        return edge
    }

    override fun hasElement(element: PsiElement?): Boolean {
        synchronized(myElementsLock) {
            for (node in myNodes) {
                if (node.identifyingElement == element) return true
            }
        }

        return false
    }

    override fun collapseNode(node: DiagramNode<PsiElement?>) {
        super.collapseNode(node)
    }

    override fun expandNode(node: DiagramNode<PsiElement?>) {
        super.expandNode(node)
    }

    override fun refreshDataModel() {
        val nodes =
            ReadAction.compute<MutableSet<MiniZincDiagramNode>, Throwable> {
                return@compute provider.elementManager
                    .findElementsInDataContext(
                        SimpleDataContext.builder()
                            .add(CommonDataKeys.PSI_ELEMENT, originalElement)
                            .build()
                    )
                    .map { element -> MiniZincDiagramNode(element, provider) }
                    .toMutableSet()
            }

        // Rebuild edges
        val edges = mutableSetOf<MiniZincDiagramEdge>()

        for (node in nodes) {
            ReadAction.run<Throwable> {
                val element = node.identifyingElement

                when (element) {
                    is MiniZincParameter -> {
                        val declaration = element.parent
                        val declarationNode = MiniZincDiagramNode(declaration, provider)

                        edges.add(
                            MiniZincDiagramEdge(
                                declarationNode,
                                node,
                                provider.relationshipManager.getDependencyInfo(
                                    declaration,
                                    element,
                                    null,
                                )!!,
                            )
                        )

                        // Link type as well
                        val i = element.type.baseTypeList[0].baseTypeTail?.identifier?.text
                        if (i == null) return@run
                        val symbol = MiniZincSymbol(element.containingFile, i)

                        try {
                            val klassNode =
                                nodes.first {
                                        (it.identifyingElement as PsiSymbolDeclaration)
                                            .getSymbol() == symbol
                                }

                            edges.add(
                                MiniZincDiagramEdge(
                                    node,
                                    klassNode,
                                    provider.relationshipManager.getDependencyInfo(
                                        klassNode.identifyingElement,
                                        element,
                                        null,
                                    ) ?: return@run,
                                )
                            )
                        } catch (error: NoSuchElementException) {} catch (error: ClassCastException) {}
                    }

                    is MiniZincDeclaration -> {
                        val i = element.type?.baseTypeList[0]?.baseTypeTail?.identifier?.text
                        if (i == null) return@run
                        val symbol = MiniZincSymbol(element.containingFile, i)
                        try {
                            val klassNode =
                                nodes.first {
                                        (it.identifyingElement as PsiSymbolDeclaration)
                                            .getSymbol() == symbol
                                }
                            edges.add(
                                MiniZincDiagramEdge(
                                    node,
                                    klassNode,
                                    provider.relationshipManager.getDependencyInfo(
                                        klassNode.identifyingElement,
                                        element,
                                        null,
                                    ) ?: return@run,
                                )
                            )
                        } catch (error: NoSuchElementException) {} catch (error: ClassCastException) {}
                    }

                    is MiniZincClassDeclaration -> {
                        val i = element.classExtendsClause?.identifier?.text
                        if (i == null) return@run
                        val symbol = MiniZincSymbol(element.containingFile, i)
                        try {
                            val klassNode =
                                nodes.first {
                                        (it.identifyingElement as PsiSymbolDeclaration)
                                            .getSymbol() == symbol
                                }
                            edges.add(
                                MiniZincDiagramEdge(
                                    node,
                                    klassNode,
                                    provider.relationshipManager.getDependencyInfo(
                                        klassNode.identifyingElement,
                                        element,
                                        null,
                                    ) ?: return@run,
                                )
                            )
                        } catch (error: NoSuchElementException) {} catch (error: ClassCastException) {}
                    }
                }
            }
        }

        val rem = mutableSetOf<MiniZincDiagramNode>()

        //        for (nodeA in nodes) {
        //            for (nodeB in nodes) {
        //                if (hasAssosiation(nodeA, nodeB)) {
        //                    nodes.remove(nodeA)
        //                }
        //            }
        //        }

        // myNodes is a set, hence this will retain the original version of the object
        // This code is needed because GraphBuilderImpl will cache nodes based on .equals()
        // and for various reasons we don't want to lose track of what object actually lives
        // in the GraphBuilderImpl cache.
        synchronized(this.myElementsLock) {
            myNodes.retainAll(nodes)
            myNodes.addAll(nodes)
            myEdges.retainAll(edges)
            myEdges.addAll(edges)
        }

        //            val allCategories: Array<DiagramCategory?> =
        //                provider.nodeContentManager.contentCategories
        //            val enabledCategories: Array<DiagramCategory> =
        //                provider.nodeContentManager.enabledCategories
        //
        //            myNodes.removeAll { node ->
        //                enabledCategories.any { category ->
        // provider.nodeContentManager.isInCategory(node.identifyingElement, category) }
        //            }
    }

    fun hasAssosiation(nodeA: MiniZincDiagramNode, nodeB: MiniZincDiagramNode): Boolean {
        if (nodeA == nodeB) return false
        if (nodeA.identifyingElement !is MiniZincParameter) return false
        if (nodeB.identifyingElement !is MiniZincParameter) return false
        var jjj = false

        nodeA.identifyingElement.containingFile.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)
                    // Check if the element is a class, method, or field declaration
                    when (element) {
                        is MiniZincConstraint -> {
                            for (e in element.childrenOfType<MiniZincCallExpression>()) {
                                if (
                                    e.text.contains("association") &&
                                        e.text.contains(
                                            (nodeA.identifyingElement as MiniZincParameterImpl).name
                                        ) &&
                                        e.text.contains(
                                            (nodeB.identifyingElement as MiniZincParameterImpl).name
                                        )
                                ) {
                                    jjj = true
                                }
                            }
                        }
                    }
                }
            }
        )

        return jjj
    }

    override fun rebuild(element: PsiElement?) {
        synchronized(myElementsLock) {
            this.removeAll()
            myEdges.clear()
            originalElement = element
        }
    }

    override fun dispose() {}
}
