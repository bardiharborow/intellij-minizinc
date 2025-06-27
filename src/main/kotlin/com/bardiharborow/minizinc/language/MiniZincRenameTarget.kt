package com.bardiharborow.minizinc.language

import com.intellij.icons.AllIcons
import com.intellij.model.Pointer
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.psi.PsiFile
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.refactoring.rename.api.RenameTarget
import com.intellij.util.concurrency.annotations.RequiresBackgroundThread
import com.intellij.util.concurrency.annotations.RequiresReadLock

class MiniZincRenameTarget(val file: PsiFile, override val targetName: String) : RenameTarget {
    override val maximalSearchScope: SearchScope
        get() = LocalSearchScope(file)

    override fun createPointer(): Pointer<out RenameTarget> {
        return Pointer { MiniZincRenameTarget(file, targetName) }
    }

    @RequiresReadLock
    @RequiresBackgroundThread
    override fun presentation(): TargetPresentation {
        return TargetPresentation.builder(targetName).icon(AllIcons.Nodes.Variable).presentation()
    }
}
