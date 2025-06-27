package com.bardiharborow.minizinc.language.uml.components

import com.bardiharborow.minizinc.language.uml.MiniZincDiagramProvider
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramNode
import com.intellij.psi.PsiElement
import java.awt.Component
import java.awt.Graphics
import java.awt.Polygon
import javax.swing.JComponent

class DiamondComponent(
    val node: DiagramNode<PsiElement>,
    val builder: DiagramBuilder,
    val panel: Component,
    val provider: MiniZincDiagramProvider,
) : JComponent() {
    init {
        this.setFocusable(false)
        this.setOpaque(false)
    }

    public override fun paintComponent(g: Graphics) {
        g.color =
            provider.colorManager.getActualNodeHeaderBackground(
                builder,
                node,
                node.identifyingElement,
            )
        g.fillPolygon(
            Polygon(
                intArrayOf(x + width / 2, x + width, x + width / 2, 0, x + width / 2),
                intArrayOf(0, y + height / 2, y + height, y + height / 2, 0),
                5,
            )
        )
        //        g.drawLine(x + width / 2, 0, x + width, y + height / 2)
        //        g.drawLine(x + width, y + height / 2, x + width / 2, y + height)
        //        g.drawLine(x + width / 2, y + height, 0, y + height / 2)
        //        g.drawLine(0, y + height / 2, x + width / 2, 0)
    }

    override fun getWidth() = panel.width

    override fun getHeight() = panel.height

    override fun getX() = panel.x

    override fun getY() = panel.y
}
