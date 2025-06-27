package com.bardiharborow.minizinc.language

import com.intellij.lang.Language

class MiniZincLanguage : Language("MiniZinc") {
    override fun isCaseSensitive() = true

    companion object {
        val INSTANCE = MiniZincLanguage()
    }
}
