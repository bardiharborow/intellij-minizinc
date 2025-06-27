package com.bardiharborow.minizinc.language.refactoring

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement

class MiniZincRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isSafeDeleteAvailable(element: PsiElement): Boolean {
        return element is MiniZincDeclaration ||
            element is MiniZincParameter ||
            element is MiniZincClassDeclaration
    }

    override fun isInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean = true

    override fun isMemberInplaceRenameAvailable(
        element: PsiElement,
        context: PsiElement?,
    ): Boolean = true
}
