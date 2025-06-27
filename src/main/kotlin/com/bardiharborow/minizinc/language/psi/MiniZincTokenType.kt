package com.bardiharborow.minizinc.language.psi

import com.bardiharborow.minizinc.language.MiniZincLanguage
import com.intellij.psi.tree.IElementType

class MiniZincTokenType(debugName: String) :
    IElementType(debugName, MiniZincLanguage.Companion.INSTANCE) {
    override fun toString(): String {
        return "MiniZincTokenType." + super.toString()
    }
}
