package com.bardiharborow.minizinc.language.uml.model

import com.bardiharborow.minizinc.language.psi.MiniZincConstraint
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincGoal
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.diagram.DiagramProvider
import com.intellij.diagram.PsiDiagramNode
import com.intellij.openapi.application.ReadAction
import com.intellij.psi.PsiElement
import java.awt.Color
import javax.swing.Icon
import org.jetbrains.annotations.Nls

class MiniZincDiagramNode(psiElement: PsiElement, provider: DiagramProvider<PsiElement>) :
    PsiDiagramNode<PsiElement>(psiElement, provider) {

    enum class Type {
        Entity,
        Relationship,
        Attribute,
        Constraint,
        Variable,
        Goal,
    }

    fun getType(): Type {
        return ReadAction.compute<Type, Throwable> {
            val element = identifyingElement

            return@compute when (element) {
                is MiniZincParameter -> {
                    val className = element.type.baseTypeList[0].baseTypeTail?.identifier?.text
                    if (className != null) {
                        // Parameter represents a relationship with another class
                        return@compute Type.Relationship
                    }

                    return@compute Type.Attribute
                }

                is MiniZincDeclaration -> Type.Variable
                is MiniZincConstraint -> Type.Constraint
                is MiniZincGoal -> Type.Goal
                else -> Type.Entity
            }
        }
    }

    fun isVariable(): Boolean {
        val element = identifyingElement

        if (element is MiniZincDeclaration) {
            return ReadAction.compute<Boolean, Throwable> {
                return@compute element.type?.text?.contains("var ") == true // TODO
            }
        }

        if (element is MiniZincParameter) {
            return ReadAction.compute<Boolean, Throwable> {
                return@compute element.type.text?.contains("var ") == true // TODO
            }
        }

        return false
    }

    override fun getTooltip(): @Nls String? {
        return "tooltip"
    }

    override fun getIcon(ignoredFlags: Int): Icon? {
        // Don't show icons
        return null
    }

    override fun getFileTabForeground(): Color? {
        // TODO(threading): may be removed if IntelliJ fix the underlying threading issue
        return ReadAction.compute<Color?, Throwable> {
            return@compute super.getFileTabForeground()
        }
    }
}
