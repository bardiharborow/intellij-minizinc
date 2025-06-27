package com.bardiharborow.minizinc.language.structure

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincFile
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.bardiharborow.minizinc.language.psi.impl.MiniZincClassElementImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincDeclarationImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincParameterImpl
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor

class MiniZincStructureViewTreeElement(private val element: NavigatablePsiElement) :
    StructureViewTreeElement, SortableTreeElement {
    override fun getValue(): NavigatablePsiElement = element

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<out TreeElement> {
        val treeElements: MutableList<TreeElement> = mutableListOf()

        if (element is MiniZincFile) {
            element.accept(
                object : PsiRecursiveElementWalkingVisitor() {
                    override fun visitElement(element: PsiElement) {
                        super.visitElement(element)

                        when (element) {
                            is MiniZincDeclaration -> {
                                treeElements.add(
                                    MiniZincStructureViewTreeElement(
                                        element as MiniZincDeclarationImpl
                                    )
                                )
                            }
                            is MiniZincClassDeclaration -> {
                                treeElements.add(
                                    MiniZincStructureViewTreeElement(
                                        element as MiniZincClassElementImpl
                                    )
                                )
                            }
                        }
                    }
                }
            )

            return treeElements.toTypedArray()
        }

        if (element is MiniZincClassDeclaration) {
            element.accept(
                object : PsiRecursiveElementWalkingVisitor() {
                    override fun visitElement(element: PsiElement) {
                        super.visitElement(element)

                        when (element) {
                            is MiniZincParameter -> {
                                treeElements.add(
                                    MiniZincStructureViewTreeElement(
                                        element as MiniZincParameterImpl
                                    )
                                )
                            }
                        }
                    }
                }
            )

            return treeElements.toTypedArray()
        }

        return StructureViewTreeElement.EMPTY_ARRAY
    }

    override fun getAlphaSortKey(): String {
        return element.name ?: ""
    }

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return element.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return element.canNavigateToSource()
    }
}
