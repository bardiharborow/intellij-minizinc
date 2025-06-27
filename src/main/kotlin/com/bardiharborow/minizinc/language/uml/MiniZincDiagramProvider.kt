package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.uml.actions.NewMiniZincClass
import com.bardiharborow.minizinc.language.uml.actions.NewMiniZincField
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramDataModel
import com.intellij.diagram.DiagramCategory
import com.intellij.diagram.DiagramDataModel
import com.intellij.diagram.DiagramEdgeCreationPolicy
import com.intellij.diagram.DiagramPresentationModel
import com.intellij.diagram.DiagramProvider
import com.intellij.diagram.DiagramPsiScopeManager
import com.intellij.diagram.extras.DiagramExtras
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.graph.view.Graph2D
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NlsContexts.Label
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import org.intellij.lang.annotations.Pattern

class MiniZincDiagramProvider : DiagramProvider<PsiElement>(), DumbAware {
    @Pattern("[a-zA-Z0-9_-]*")
    override fun getID(): String {
        return "MiniZinc"
    }

    override fun getPresentableName(): @Label String {
        return MyBundle.getMessage("diagrams.title")
    }

    override fun createDataModel(
        project: Project,
        element: PsiElement?,
        file: VirtualFile?,
        model: DiagramPresentationModel,
    ): DiagramDataModel<PsiElement> {
        return MiniZincDiagramDataModel(project, element, file, this)
    }

    override fun createVisibilityManager(): MiniZincDiagramVisibilityManager {
        return myVisibilityManager
    }

    override fun createScopeManager(project: Project): DiagramPsiScopeManager<PsiElement> {
        return DiagramPsiScopeManager(project)
    }

    override fun createNodeContentManager(): MiniZincDiagramNodeContentManager {
        return myContentManager
    }

    override fun createPresentationModel(
        project: Project,
        graph: Graph2D,
    ): DiagramPresentationModel {
        return MiniZincDiagramPresentationModel(graph, project, this)
    }

    override fun getAllContentCategories(): Array<DiagramCategory> {
        return myContentManager.contentCategories
    }

    override fun getElementManager(): MiniZincDiagramElementManager {
        return MiniZincDiagramElementManager(this)
    }

    override fun getVfsResolver(): MiniZincDiagramVfsResolver {
        return myVfsResolver
    }

    override fun getColorManager(): MiniZincDiagramColorManager {
        return MiniZincDiagramColorManager(this)
    }

    override fun getExtras(): DiagramExtras<PsiElement?> {
        return MiniZincDiagramExtras()
    }

    override fun getRelationshipManager(): MiniZincDiagramRelationshipManager {
        return myRelationshipManager
    }

    override fun getEdgeCreationPolicy(): DiagramEdgeCreationPolicy<PsiElement>? {
        return myEdgeCreationPolicy
    }

    override fun getCreateNewActions(): Array<AnAction> {
        return arrayOf(NewMiniZincClass())
    }

    override fun getCreateNewNodeElementActions(): Array<AnAction?> {
        return arrayOf(NewMiniZincField())
    }

    companion object {
        private val myVisibilityManager = MiniZincDiagramVisibilityManager()
        private val myVfsResolver = MiniZincDiagramVfsResolver()
        private val myRelationshipManager = MiniZincDiagramRelationshipManager()
        private val myContentManager = MiniZincDiagramNodeContentManager()
        private val myEdgeCreationPolicy = MiniZincDiagramEdgeCreationPolicy()
    }
}
