package com.bardiharborow.minizinc.language.editing

import com.bardiharborow.minizinc.language.psi.MiniZincTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class MiniZincQuoteHandler :
    SimpleTokenSetQuoteHandler(MiniZincTypes.BNF_QUOTE, MiniZincTypes.BNF_STRING_LITERAL)
