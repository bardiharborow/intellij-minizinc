package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.diagram.DiagramCategory
import com.intellij.diagram.DiagramRelationshipInfo
import com.intellij.diagram.DiagramRelationshipInfoAdapter
import com.intellij.diagram.DiagramRelationshipManager
import com.intellij.diagram.presentation.DiagramLineType
import com.intellij.psi.PsiElement

class MiniZincDiagramRelationshipManager() : DiagramRelationshipManager<PsiElement> {
    override fun getDependencyInfo(
        first: PsiElement?,
        second: PsiElement?,
        category: DiagramCategory?,
    ): DiagramRelationshipInfo? {
        if (first is MiniZincClassDeclaration && second is MiniZincParameter) {
            val classType = second.type.baseTypeList[0]?.baseTypeTail?.identifier?.text
            val isClassType = classType != null
            val isParent = second.parent == first

            val optional = second.type.text?.contains("opt ") == true // TODO

            val upperTargetLabel =
                when (optional) {
                    else -> ""
                }

            val upperSourceLabel = ""

            val name =
                when (!isClassType) {
                    true ->
                        when (optional) {
                            true -> "optionalAttribute"
                            else -> "attribute"
                        }
                    else ->
                        when (optional || !isParent) {
                            true -> "partialRelationship"
                            false -> "totalRelationship"
                        }
                }

            val lineType =
                when (name) {
                    "optionalAttribute" -> DiagramLineType.DASHED
                    "partialRelationship" -> DiagramLineType.DASHED
                    else -> DiagramLineType.SOLID
                }

            return DiagramRelationshipInfoAdapter(
                name,
                lineType,
                upperTargetLabel,
                upperSourceLabel,
            )
        }

        if (first is MiniZincClassDeclaration && second is MiniZincClassDeclaration) {
            // Inheritance
            return DiagramRelationshipInfoAdapter(
                "inheritance",
                DiagramLineType.SOLID,
                1,
                null,
                DiagramRelationshipInfoAdapter.PLAIN,
                null,
                null,
                null,
                null,
                null,
                "",
            )
        }

        return DiagramRelationshipInfoAdapter(
            "",
            DiagramLineType.SOLID,// TODO: lineType,
        )
    }
}
