package com.bardiharborow.minizinc.language.uml.components

import com.bardiharborow.minizinc.language.uml.MiniZincDiagramProvider
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramNode
import com.intellij.psi.PsiElement
import java.awt.Component
import java.awt.Graphics
import java.awt.Polygon
import javax.swing.JComponent
import kotlin.math.roundToInt
import kotlin.math.sin

class FlagComponent(
    val node: DiagramNode<PsiElement>,
    val builder: DiagramBuilder,
    val panel: Component,
    val provider: MiniZincDiagramProvider,
) : JComponent() {
    var polygon: Polygon? = null
    var cachedHeight = 0
    var cachedWidth = 0

    init {
        this.setFocusable(false)
        this.setOpaque(false)
    }

    private fun generateFlag() : Polygon {
        val amplitude = 2

        val flag = Polygon()

        var x = 0
        var stepSize = 1
        while (x <= width) {
            val angle: Double = (2 * Math.PI * x / width) - Math.PI
            val y = (amplitude * sin(angle)).roundToInt() + amplitude
            flag.addPoint(x, y)
            x += stepSize
        }

        x = width
        while (x >= 0) {
            val angle: Double = (2 * Math.PI * x / width) - Math.PI
            val y: Int = (height + (amplitude * sin(angle))).roundToInt() - amplitude
            flag.addPoint(x, y)
            x -= stepSize
        }

        return flag
    }

    public override fun paintComponent(g: Graphics) {
        g.color =
            provider.colorManager.getActualNodeHeaderBackground(
                builder,
                node,
                node.identifyingElement,
            )

        if (cachedHeight != height || cachedWidth != width || polygon == null) {
            this.cachedHeight = height
            this.cachedWidth = width
            this.polygon = generateFlag()
        }

        g.fillPolygon(polygon!!)
    }

    override fun getWidth() = panel.width

    override fun getHeight() = panel.height

    override fun getX() = panel.x

    override fun getY() = panel.y
}
