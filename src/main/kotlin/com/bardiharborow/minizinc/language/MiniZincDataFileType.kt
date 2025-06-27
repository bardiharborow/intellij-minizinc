package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.MiniZincIcons
import com.bardiharborow.minizinc.MyBundle
import com.intellij.openapi.fileTypes.LanguageFileType

class MiniZincDataFileType : LanguageFileType(MiniZincLanguage.INSTANCE) {
    companion object {
        val INSTANCE = MiniZincDataFileType()
    }

    override fun getName() = "MiniZinc Data"

    override fun getDisplayName(): String {
        return MyBundle.getMessage("language.dataFile.fileType.name")
    }

    override fun getDescription(): String {
        return MyBundle.getMessage("language.dataFile.fileType.name")
    }

    override fun getDefaultExtension() = "dzn"

    override fun getIcon() = MiniZincIcons.FILE
}
