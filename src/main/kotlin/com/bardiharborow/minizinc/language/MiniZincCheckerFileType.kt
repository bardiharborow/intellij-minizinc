package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.MiniZincIcons
import com.bardiharborow.minizinc.MyBundle
import com.intellij.openapi.fileTypes.LanguageFileType

class MiniZincCheckerFileType : LanguageFileType(MiniZincLanguage.INSTANCE) {
    companion object {
        val INSTANCE = MiniZincCheckerFileType()
    }

    override fun getName() = "MiniZinc Checker"

    override fun getDisplayName(): String {
        return MyBundle.getMessage("language.miniZincChecker.fileType.name")
    }

    override fun getDescription(): String {
        return MyBundle.getMessage("language.miniZincChecker.fileType.name")
    }

    override fun getDefaultExtension() = "mzc.mzn"

    override fun getIcon() = MiniZincIcons.FILE
}
