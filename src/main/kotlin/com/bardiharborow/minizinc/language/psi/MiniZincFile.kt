package com.bardiharborow.minizinc.language.psi

import com.bardiharborow.minizinc.language.MiniZincFileType
import com.bardiharborow.minizinc.language.MiniZincLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class MiniZincFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, MiniZincLanguage.INSTANCE) {
    override fun getFileType() = MiniZincFileType.INSTANCE

    override fun toString() = "MiniZinc"
}
