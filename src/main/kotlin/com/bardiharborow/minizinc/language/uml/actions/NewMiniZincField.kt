package com.bardiharborow.minizinc.language.uml.actions

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.MiniZincFileType
import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramDataModel
import com.intellij.diagram.actions.DiagramCreateNewElementAction
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

class NewMiniZincField :
    DiagramCreateNewElementAction<PsiElement, CreateNewInfo>(
        "Field",
        "desc",
        AllIcons.Nodes.Field,
    ) {
    override fun createElement(
        dataModel: DiagramDataModel<PsiElement>,
        createInfo: CreateNewInfo,
        event: AnActionEvent,
    ): PsiElement? {
        val psiElement = event.getData(PlatformCoreDataKeys.PSI_ELEMENT)!!

        var dummyFile =
            PsiFileFactory.getInstance(createInfo.psiFile.project)
                .createFileFromText(
                    "jj.mzn",
                    MiniZincFileType.INSTANCE,
                    "class Foo (" + createInfo.type + ": " + createInfo.name + ");\n",
                )

        val parameter = dummyFile.firstChild.firstChild.lastChild.prevSibling
        val lastParenthesis = psiElement.lastChild

        val finalParameter = createInfo.psiFile.addBefore(parameter, lastParenthesis)

        if (lastParenthesis.prevSibling.prevSibling is MiniZincParameter) {
            if (lastParenthesis.prevSibling.prevSibling.lastChild.text != ";") {
                createInfo.psiFile.addBefore(
                    dummyFile.lastChild.prevSibling.lastChild,
                    finalParameter,
                )
            }
        }

        return finalParameter
    }

    override fun prepare(event: AnActionEvent): CreateNewInfo? {
        val builder = getBuilder(event)
        if (builder == null) return null

        val originalElement: PsiElement = builder.dataModel.originalElement as PsiElement
        val file = originalElement.containingFile

        val dialog = NewFieldOnUmlDialog(file)
        dialog.title = MyBundle.getMessage("diagrams.actions.createField")
        dialog.show()
        if (dialog.exitCode != 0) {
            return null
        }

        return CreateNewInfo(dialog.getFieldName(), dialog.getTypeName(), file)
    }

    override fun isEnabled(event: AnActionEvent, builder: DiagramBuilder): Boolean {
        val psiElement = event.getData(PlatformCoreDataKeys.PSI_ELEMENT)

        return super.isEnabled(event, builder) && psiElement is MiniZincClassDeclaration
    }

    override fun getActionName(): String {
        return MyBundle.getMessage("diagrams.actions.createField")
    }
}
