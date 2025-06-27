package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramNode
import com.intellij.diagram.DiagramEdgeCreationPolicy
import com.intellij.diagram.DiagramNode
import com.intellij.psi.PsiElement

class MiniZincDiagramEdgeCreationPolicy : DiagramEdgeCreationPolicy<PsiElement>() {
    override fun acceptSource(node: DiagramNode<PsiElement>): Boolean {
        return true
//        if (node !is MiniZincDiagramNode) return false
//
//        return node.getType() == MiniZincDiagramNode.Type.Entity
    }

    override fun acceptTarget(node: DiagramNode<PsiElement>): Boolean {
        return true
//        if (node !is MiniZincDiagramNode) return false
//
//        return node.getType() == MiniZincDiagramNode.Type.Entity
    }

    override fun getLineToActionName(): String {
        return MyBundle.getMessage("diagrams.actions.lineTo")
    }
}
