package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramNode
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramColorManagerBase
import com.intellij.diagram.DiagramNode
import com.intellij.ui.JBColor
import java.awt.Color
import java.awt.Font

class MiniZincDiagramColorManager(val provider: MiniZincDiagramProvider) :
    DiagramColorManagerBase() {
    private val TRANSPARENT = JBColor(Color(0, 0, 0, 0), Color(0, 0, 0, 0))

    override fun getNodeHeaderBackground(
        builder: DiagramBuilder,
        node: DiagramNode<*>,
        element: Any?,
    ): Color {
        val shape = getNodeShape(node)

        // Set elsewhere
        if (shape !== Shape.None) {
            return TRANSPARENT
        }

        return getActualNodeHeaderBackground(builder, node, element)
    }

    fun getActualNodeHeaderBackground(
        builder: DiagramBuilder,
        node: DiagramNode<*>,
        element: Any?,
    ): Color {
        if (node !is MiniZincDiagramNode) return TRANSPARENT

        val variable = node.isVariable()

        if (variable) {
            return builder.colorScheme.getColor(MiniZincDiagramColors.NODE_VARIABLE)!!
        }

        val visibilityManager = provider.createVisibilityManager()
        val visibilityLevel = node.visibilityLevel

        if (visibilityLevel == visibilityManager.DOMAIN_LEVEL) {
            return builder.colorScheme.getColor(MiniZincDiagramColors.NODE_DOMAIN)!!
        } else if (visibilityLevel == visibilityManager.INSTANCE_LEVEL) {
            return builder.colorScheme.getColor(MiniZincDiagramColors.NODE_INSTANCE)!!
        }

        return super.getNodeHeaderBackground(builder, node, element)
    }

    override fun getNodeBorderColor(
        builder: DiagramBuilder,
        node: DiagramNode<*>?,
        isSelected: Boolean,
    ): Color {
        // Borders are rectangular even on non-rectangular nodes.
        if (!isSelected) {
            // Hide borders for un-selected nodes.
            return TRANSPARENT
        }

        return super.getNodeBorderColor(builder, node, isSelected)
    }

    override fun getNodeHeaderFont(builder: DiagramBuilder): Font {
        return super.getNodeHeaderFont(builder).deriveFont(Font.BOLD)
    }

    fun getNodeShape(node: DiagramNode<*>): Shape {
        if (node !is MiniZincDiagramNode) return Shape.None

        val type = node.getType()

        return when (type) {
            MiniZincDiagramNode.Type.Entity -> Shape.None
            MiniZincDiagramNode.Type.Relationship -> Shape.Diamond
            MiniZincDiagramNode.Type.Attribute -> Shape.Oval
            MiniZincDiagramNode.Type.Constraint -> Shape.RoundedRectangle
            MiniZincDiagramNode.Type.Goal -> Shape.Flag
            else -> Shape.None
        }
    }

    enum class Shape {
        Diamond,
        Oval,
        RoundedRectangle,
        Flag,
        None,
    }
}
