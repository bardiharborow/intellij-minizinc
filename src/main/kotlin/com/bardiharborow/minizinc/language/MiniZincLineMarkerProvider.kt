package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.psi.impl.MiniZincGoalImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincOutputImpl
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

class MiniZincLineMarkerProvider : LineMarkerProvider, DumbAware {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<PsiElement>? {
        return when (element) {
            is MiniZincGoalImpl ->
                LineMarkerInfo(
                    element,
                    element.textRange,
                    AllIcons.Chooser.Right,
                    { MyBundle.getMessage("language.miniZinc.lineMarkers.goal") },
                    null,
                    Alignment.RIGHT,
                    MyBundle.getLazyMessage("language.miniZinc.lineMarkers.goal"),
                )
            is MiniZincOutputImpl ->
                LineMarkerInfo(
                    element,
                    element.textRange,
                    AllIcons.FileTypes.Text,
                    { MyBundle.getMessage("language.miniZinc.lineMarkers.output") },
                    null,
                    Alignment.RIGHT,
                    MyBundle.getLazyMessage("language.miniZinc.lineMarkers.output"),
                )
            else -> null
        }
    }
}
