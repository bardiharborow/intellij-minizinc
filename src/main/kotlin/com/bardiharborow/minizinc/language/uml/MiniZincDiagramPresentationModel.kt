package com.bardiharborow.minizinc.language.uml

import com.intellij.diagram.DiagramEdge
import com.intellij.diagram.settings.DiagramConfiguration
import com.intellij.diagram.util.DiagramUpdateService
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.Separator
import com.intellij.openapi.graph.EdgeRealizerProvider
import com.intellij.openapi.graph.view.EdgeRealizer
import com.intellij.openapi.graph.view.Graph2D
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.uml.core.actions.UmlNewAction
import com.intellij.uml.presentation.DiagramPresentationModelImpl
import com.intellij.uml.utils.DiagramBundle

class MiniZincDiagramPresentationModel(
    graph: Graph2D,
    val project: Project,
    provider: MiniZincDiagramProvider,
) : DiagramPresentationModelImpl(graph, project, provider) {
    init {
        // TODO: move to a better location

        val diagramConfiguration = DiagramConfiguration.getInstance()
        // diagramConfiguration.defaultLayout = DiagramLayout.ORTHOGONAL_GROUPS
        diagramConfiguration.setDoShowGridByDefault(false)
        diagramConfiguration.layoutAnimationDurationMillis = 100

        settings.isMergeEdgeBySources = false
        settings.isMergeEdgeByTargets = false
    }

    override fun getCommonActionGroup(): DefaultActionGroup {
        val actions = super.getCommonActionGroup()
        val manager = ActionManager.getInstance()

        val children = actions.getChildren(manager)
        val contentActionGroup = children[1] as DefaultActionGroup

        actions.replaceAction(
            contentActionGroup,
            object :
                ActionGroup(DiagramBundle.message("group.action.text.new", *emptyArray()), false) {
                override fun getChildren(e: AnActionEvent?): Array<AnAction> {
                    if (e == null) {
                        return EMPTY_ARRAY
                    } else {
                        val var10000 =
                            (UmlNewAction()).getGroup(e.dataContext).getChildren(e).toMutableList()

                        var10000.removeAll(listOf(Separator.getInstance()))

                        var10000.forEach { action ->
                            action.templatePresentation.setText(
                                DiagramBundle.message("group.action.text.new", *emptyArray()) +
                                    " " +
                                    action.templatePresentation.text.lowercase()
                            )
                        }

                        return var10000.toTypedArray()
                    }
                }
            },
        )

        //
        //        if (extras.isSourceActionsImplemented) {
        //            actions.add(this.sourceActionGroup)
        //            actions.addSeparator()
        //        }
        //
        //        //        synchronized(this.myActionsLock) {
        //        //            if (this.myElementProvidersActions.getChildrenCount() > 0) {
        //        //                actions.addAll(this.myElementProvidersActions)
        //        //                actions.addSeparator()
        //        //            }
        //        //            if (this.myExtraActions.getChildrenCount() > 0) {
        //        //                actions.addAll(this.myExtraActions)
        //        //                actions.addSeparator()
        //        //            }
        //        //        }
        //
        //        if (extras.isExpandCollapseActionsImplemented) {
        //            actions.add(ActionManager.getInstance().getAction("Uml.CollapseNodes"))
        //            actions.add(ActionManager.getInstance().getAction("Uml.ExpandNodes"))
        //            actions.addSeparator()
        //        }
        //
        //        if (extras.isDeleteActionImplemented) {
        //            actions.add(ActionManager.getInstance().getAction("Diagram.DeleteSelection"))
        //            actions.addSeparator()
        //        }
        //
        //        val refactoring = DiagramRefactoringGroup()
        //        refactoring.isPopup = false
        //        refactoring.getChildren(null).forEach { action ->
        //            if (action is Separator) actions.remove(action)
        //        }
        //        actions.add(refactoring)
        //
        //        // actions.forEach { action -> if (action.template == Separator.getInstance())
        //        // actions.remove(action) }
        //
        //        // actions.add(ActionManager.getInstance().getAction("UML.DefaultGraphPopup"))

        return actions
    }

    override fun refreshModelWhenSmart() {
        DumbService.getInstance(project)
            .runWhenSmart(
                Runnable {
                    DiagramUpdateService.getInstance()
                        .requestDataModelRefreshPreservingLayout(builder)
                        // Ensure that node labels are updated
                        .withNodePresentationsUpdate(true)
                        // Ensure that nodes are resized if the length of their label changes
                        .withAllNodeSizeUpdate()
                        .runAsync()
                        .thenRunAsync(
                            Runnable {
                                this.update()
                                this.stopCurrentCellEditor()
                            },
                            this.builder.graphBuilder.actionExecutor.graphExecutor,
                        )
                }
            )
    }

    fun refresh() {
        refreshModelWhenSmart()
    }

    override fun getEdgeRealizer(
        provider: EdgeRealizerProvider,
        edge: DiagramEdge<*>?,
    ): EdgeRealizer {
        val realizer = super.getEdgeRealizer(provider, edge)

        //        if (edge != null) {
        //            val relationship = edge.relationship
        //            if (relationship is DiagramRelationshipInfoAdapter && relationship.name ==
        // "totalRelationship") {
        //                realizer.lineType = DoubleLine(realizer.lineType as LineTypeImpl)
        //            }
        //        }

        return realizer
    }
}
