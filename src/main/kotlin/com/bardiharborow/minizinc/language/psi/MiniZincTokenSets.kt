package com.bardiharborow.minizinc.language.psi

import com.intellij.psi.tree.TokenSet

interface MiniZincTokenSets {
    companion object {
        // val IDENTIFIERS: TokenSet = TokenSet.create(MiniZincTypes.IDENTIFIER)

        val COMMENTS: TokenSet =
            TokenSet.create(
                MiniZincTypes.BNF_LINE_COMMENT,
                MiniZincTypes.BNF_FILE_DOCUMENTATION_COMMENT,
                MiniZincTypes.BNF_DOCUMENTATION_COMMENT,
                MiniZincTypes.BNF_BLOCK_COMMENT,
            )

        val STRING_LITERALS: TokenSet = TokenSet.create(MiniZincTypes.BNF_STRING_LITERAL)
    }
}
