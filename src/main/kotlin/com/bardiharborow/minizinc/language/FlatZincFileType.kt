package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.MiniZincIcons
import com.bardiharborow.minizinc.MyBundle
import com.intellij.openapi.fileTypes.LanguageFileType

class FlatZincFileType : LanguageFileType(FlatZincLanguage.INSTANCE) {
    companion object {
        val INSTANCE = FlatZincFileType()
    }

    override fun getName() = "FlatZinc"

    override fun getDisplayName(): String {
        return MyBundle.getMessage("language.flatZinc.fileType.name")
    }

    override fun getDescription(): String {
        return MyBundle.getMessage("language.flatZinc.fileType.name")
    }

    override fun getDefaultExtension(): String {
        return "fzn"
    }

    override fun getIcon() = MiniZincIcons.FILE
}
