package com.bardiharborow.minizinc.language.editing

import com.bardiharborow.minizinc.language.psi.MiniZincTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class MiniZincBraceMatcher : PairedBraceMatcher {
    override fun getPairs() =
        arrayOf(
            BracePair(MiniZincTypes.BNF_BRACE_LEFT, MiniZincTypes.BNF_BRACE_RIGHT, true),
            BracePair(MiniZincTypes.BNF_BRACKET_LEFT, MiniZincTypes.BNF_BRACKET_RIGHT, true),
            BracePair(MiniZincTypes.BNF_PARENTHESIS_LEFT, MiniZincTypes.BNF_PARENTHESIS_RIGHT, true),
        )

    override fun isPairedBracesAllowedBeforeType(
        type: IElementType,
        tokenType: IElementType?,
    ): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}
