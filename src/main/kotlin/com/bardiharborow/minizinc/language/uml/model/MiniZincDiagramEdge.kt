package com.bardiharborow.minizinc.language.uml.model

import com.intellij.diagram.DiagramEdgeBase
import com.intellij.diagram.DiagramNode
import com.intellij.diagram.DiagramRelationshipInfo
import com.intellij.psi.PsiElement

class MiniZincDiagramEdge(
    source: DiagramNode<PsiElement>,
    target: DiagramNode<PsiElement>,
    relationship: DiagramRelationshipInfo,
) : DiagramEdgeBase<PsiElement>(source, target, relationship) {}
