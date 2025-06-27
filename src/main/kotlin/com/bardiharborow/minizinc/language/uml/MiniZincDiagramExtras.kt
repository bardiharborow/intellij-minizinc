package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.language.uml.MiniZincDiagramColorManager.Shape
import com.bardiharborow.minizinc.language.uml.components.DiamondComponent
import com.bardiharborow.minizinc.language.uml.components.FlagComponent
import com.bardiharborow.minizinc.language.uml.components.OvalComponent
import com.bardiharborow.minizinc.language.uml.components.RoundedRectangleComponent
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramNode
import com.intellij.diagram.components.DiagramNodeContainer
import com.intellij.diagram.extras.custom.CommonDiagramExtras
import com.intellij.openapi.graph.view.NodeRealizer
import com.intellij.psi.PsiElement
import com.intellij.ui.SimpleColoredComponent
import com.intellij.util.ui.JBUI
import javax.swing.JComponent
import javax.swing.JPanel

class MiniZincDiagramExtras : CommonDiagramExtras<PsiElement>() {
    override fun isExpandCollapseActionsImplemented(): Boolean = true

    override fun isDeleteActionImplemented(): Boolean = false

    override fun createNodeComponent(
        node: DiagramNode<PsiElement>,
        builder: DiagramBuilder,
        nodeRealizer: NodeRealizer,
        wrapper: JPanel,
    ): JComponent {
        val nodeComponent =
            super.createNodeComponent(node, builder, nodeRealizer, wrapper) as DiagramNodeContainer

        (nodeComponent.header.components.last() as JComponent).border = JBUI.Borders.empty(15)

        val colorManager = node.provider.colorManager as MiniZincDiagramColorManager
        val nodeShape = colorManager.getNodeShape(node)

        when (nodeShape) {
            Shape.Oval -> {
                val oval =
                    OvalComponent(
                        node,
                        builder,
                        nodeComponent.header.components.last() as SimpleColoredComponent,
                        builder.provider as MiniZincDiagramProvider,
                    )

                nodeComponent.header.add(oval)
            }

            Shape.Diamond -> {
                (nodeComponent.header.components.last() as JComponent).border =
                    JBUI.Borders.empty(25)
                val diam =
                    DiamondComponent(
                        node,
                        builder,
                        nodeComponent.header.components.last() as SimpleColoredComponent,
                        builder.provider as MiniZincDiagramProvider,
                    )
                nodeComponent.header.add(diam)
            }

            Shape.RoundedRectangle -> {
                val roundedRectangle =
                    RoundedRectangleComponent(
                        node,
                        builder,
                        nodeComponent.header.components.last() as SimpleColoredComponent,
                        builder.provider as MiniZincDiagramProvider,
                    )

                nodeComponent.header.add(roundedRectangle)
            }

            Shape.Flag -> {
                // TODO
                val flag =
                    FlagComponent(
                        node,
                        builder,
                        nodeComponent.header.components.last() as SimpleColoredComponent,
                        builder.provider as MiniZincDiagramProvider,
                    )

                nodeComponent.header.add(flag)
            }

            Shape.None -> {}
        }

        return nodeComponent
    }
}
