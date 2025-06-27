package com.bardiharborow.minizinc.language.psi

import com.bardiharborow.minizinc.language.MiniZincLanguage
import com.intellij.psi.tree.IElementType

class MiniZincElementType(debugName: String) :
    IElementType(debugName, MiniZincLanguage.Companion.INSTANCE)
