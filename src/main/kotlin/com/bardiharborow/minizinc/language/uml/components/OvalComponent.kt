package com.bardiharborow.minizinc.language.uml.components

import com.bardiharborow.minizinc.language.uml.MiniZincDiagramProvider
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramNode
import com.intellij.psi.PsiElement
import java.awt.Component
import java.awt.Graphics
import javax.swing.JComponent

class OvalComponent(
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
        g.fillOval(x, y, width, height)
    }

    override fun getWidth() = panel.width

    override fun getHeight() = panel.height

    override fun getX() = panel.x

    override fun getY() = panel.y
}
