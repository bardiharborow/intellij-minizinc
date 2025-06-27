package com.bardiharborow.minizinc.language

import com.intellij.find.usages.api.SearchTarget
import com.intellij.find.usages.api.UsageHandler
import com.intellij.icons.AllIcons
import com.intellij.model.Pointer
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.psi.PsiFile
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.search.SearchScope

@Suppress("UnstableApiUsage")
class MiniZincSearchTarget(private val file: PsiFile, private val targetName: String) :
    SearchTarget {
    override val usageHandler: UsageHandler
        get() = MiniZincUsageHandler(targetName)

    override val maximalSearchScope: SearchScope
        get() = LocalSearchScope(file, file.name)

    override fun createPointer(): Pointer<SearchTarget> {
        return Pointer { MiniZincSearchTarget(file, targetName) }
    }

    override fun presentation(): TargetPresentation {
        return TargetPresentation.builder(targetName).icon(AllIcons.Nodes.Variable).presentation()
    }

    override fun equals(other: Any?): Boolean {
        return other is MiniZincSearchTarget && targetName == other.targetName
    }

    override fun hashCode(): Int {
        return targetName.hashCode()
    }
}
