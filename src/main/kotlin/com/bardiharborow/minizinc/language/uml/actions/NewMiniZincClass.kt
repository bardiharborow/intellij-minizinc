package com.bardiharborow.minizinc.language.uml.actions

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.MiniZincFileType
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramDataModel
import com.intellij.diagram.actions.DiagramCreateNewElementAction
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import org.jetbrains.annotations.Nls

class NewMiniZincClass :
    DiagramCreateNewElementAction<PsiElement, CreateNewInfo>(
        "Class",
        "desc",
        AllIcons.Nodes.Class,
    ) {
    override fun createElement(
        dataModel: DiagramDataModel<PsiElement>,
        createInfo: CreateNewInfo,
        event: AnActionEvent,
    ): PsiElement? {
        var dummyFile =
            PsiFileFactory.getInstance(createInfo.psiFile.project)
                .createFileFromText(
                    "jj.mzn",
                    MiniZincFileType.INSTANCE,
                    "class " + createInfo.name + " ();\n",
                )

        val newElement = dummyFile.firstChild
        val firstChild = createInfo.psiFile.firstChild
        createInfo.psiFile.addBefore(newElement, firstChild)
        createInfo.psiFile.addBefore(dummyFile.firstChild.nextSibling, firstChild)

        return newElement.firstChild
    }

    override fun prepare(event: AnActionEvent): CreateNewInfo? {
        val builder = getBuilder(event)
        if (builder == null) return null

        val originalElement: PsiElement = builder.dataModel.originalElement as PsiElement
        val file = originalElement.containingFile

        val dialog = NewClassOnUmlDialog(file)
        dialog.title = MyBundle.getMessage("diagrams.actions.createClass")
        dialog.show()
        if (dialog.getExitCode() != 0) {
            return null
        }

        return CreateNewInfo(dialog.getClassName(), "", file)
    }

    override fun isEnabled(event: AnActionEvent, builder: DiagramBuilder): Boolean {
        val psiElement = event.getData(PlatformCoreDataKeys.PSI_ELEMENT)

        return super.isEnabled(event, builder) && psiElement == null
    }

    override fun getActionName(): @Nls String {
        return MyBundle.getMessage("diagrams.actions.createClass")
    }
}
