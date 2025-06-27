package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.MiniZincIcons
import com.bardiharborow.minizinc.MyBundle
import com.intellij.openapi.fileTypes.LanguageFileType

class MiniZincFileType : LanguageFileType(MiniZincLanguage.INSTANCE) {
    companion object {
        val INSTANCE = MiniZincFileType()
    }

    override fun getName() = "MiniZinc"

    override fun getDisplayName(): String {
        return MyBundle.getMessage("language.miniZinc.fileType.name")
    }

    override fun getDescription(): String {
        return MyBundle.getMessage("language.miniZinc.fileType.name")
    }

    override fun getDefaultExtension() = "mzn"

    override fun getIcon() = MiniZincIcons.FILE
}
