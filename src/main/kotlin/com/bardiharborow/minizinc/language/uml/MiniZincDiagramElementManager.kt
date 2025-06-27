package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.MiniZincSyntaxHighlighter
import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincConstraint
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincFile
import com.bardiharborow.minizinc.language.psi.MiniZincGoal
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.bardiharborow.minizinc.language.psi.impl.MiniZincClassDeclarationImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincDeclarationImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincFieldElementImpl
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramNode
import com.intellij.diagram.AbstractDiagramElementManager
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramNode
import com.intellij.diagram.DiagramProvider
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.editor.colors.EditorColorsUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import com.intellij.ui.SimpleColoredText
import com.intellij.ui.SimpleTextAttributes

class MiniZincDiagramElementManager(provider: DiagramProvider<PsiElement>) :
    AbstractDiagramElementManager<PsiElement>() {
    init {
        setUmlProvider(provider)
    }

    override fun findInDataContext(context: DataContext): PsiElement? {
        val initialElement = CommonDataKeys.PSI_ELEMENT.getData(context) ?: return null
        val psiFile = (initialElement.containingFile as? MiniZincFile) ?: return null

        return psiFile
    }

    override fun isAcceptableAsNode(element: Any?): Boolean {
        return when (element) {
            is MiniZincClassDeclaration -> true
            is MiniZincConstraint -> !element.text.contains("association")
            is MiniZincGoal -> true
            is MiniZincDeclaration -> true
            is MiniZincParameter -> true
            is MiniZincFile -> true
            else -> false
        }
    }

    override fun getElementTitle(element: PsiElement?): String {
        return ReadAction.compute<String, Throwable> {
            if (element?.isValid == false) return@compute ""

            return@compute when (element) {
                is MiniZincFile -> element.name
                is MiniZincDeclarationImpl -> element.symbol.toString()
                is MiniZincClassDeclarationImpl -> element.symbol.toString()
                is MiniZincConstraint -> {
                    if (element.text.contains("constraint_name")) {
                        if (element.text.contains("contract constraints")) {
                            return@compute "contract constraints"
                        } else {
                            if (element.text.contains("nurse type constraint")) {
                                    return@compute "nurse type constraint"
                                }
                        }
                        return@compute "size constraint"
                         // TODO: extract constraint name
                    } else {
                        return@compute MyBundle.getMessage("diagrams.elements.constraint")
                    }
                }
                is MiniZincGoal -> MyBundle.getMessage("diagrams.elements.goal")
                is MiniZincFieldElementImpl -> element.name
                else -> element.toString()
            }
        }
    }

    override fun getItemName(
        nodeElement: PsiElement?,
        nodeItem: Any?,
        builder: DiagramBuilder,
    ): SimpleColoredText? {
        if (nodeItem !is MiniZincDiagramNode) return null

        val element = nodeItem.identifyingElement

        val textAttributes =
            EditorColorsUtil.getGlobalOrDefaultColorScheme()
                .getAttributes(MiniZincSyntaxHighlighter.IDENTIFIERS)

        return SimpleColoredText(
            getElementTitle(element),
            SimpleTextAttributes.fromTextAttributes(textAttributes),
        )
    }

    override fun getItemType(
        nodeElement: PsiElement?,
        nodeItem: Any?,
        builder: DiagramBuilder?,
    ): SimpleColoredText? {
        if (nodeItem !is MiniZincDiagramNode) return null

        val element = nodeItem.identifyingElement

        if (element !is MiniZincParameter) return null

        val textAttributes =
            EditorColorsUtil.getGlobalOrDefaultColorScheme()
                .getAttributes(MiniZincSyntaxHighlighter.KEYWORD)

        val typeText =
            ReadAction.compute<String, Throwable> {
                return@compute when (element.isValid) {
                    true -> element.getType().text
                    false -> ""
                }
            }

        return SimpleColoredText(typeText, SimpleTextAttributes.fromTextAttributes(textAttributes))
    }

    override fun getNodeTooltip(element: PsiElement?): String? {
        return provider?.vfsResolver?.getQualifiedName(element)
    }

    override fun getNodeItems(element: PsiElement): Array<DiagramNode<PsiElement>> {
        var nodeItems: Array<DiagramNode<PsiElement>> = emptyArray()
        // nodeItems = nodeItems.plus(MiniZincDiagramNode(element, provider!!))

        return nodeItems
    }

    override fun findElementsInDataContext(context: DataContext): Collection<PsiElement> {
        val elements = mutableListOf<PsiElement>()
        val initialElement = CommonDataKeys.PSI_ELEMENT.getData(context) ?: return elements

        // Walk through the PSI tree to find declarations
        initialElement.containingFile.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)

                    if (element !is MiniZincFile && isAcceptableAsNode(element)) {
                        elements.add(element)
                    }
                }
            }
        )

        return elements
    }
}
