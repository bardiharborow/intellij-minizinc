package com.bardiharborow.minizinc.language.editing

import com.intellij.lang.Commenter

class MiniZincCommenter : Commenter {
    override fun getLineCommentPrefix() = "% "

    override fun getBlockCommentPrefix() = "/* "

    override fun getBlockCommentSuffix() = " */"

    override fun getCommentedBlockCommentPrefix() = null

    override fun getCommentedBlockCommentSuffix() = null
}
