package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.language.psi.impl.MiniZincIncludeImpl
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeRegistry
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.impl.include.FileIncludeInfo
import com.intellij.psi.impl.include.FileIncludeProvider
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.Consumer
import com.intellij.util.indexing.FileContent

class MiniZincIncludeProvider : FileIncludeProvider() {
    override fun getId(): String = MiniZincLanguage.INSTANCE.id

    override fun acceptFile(file: VirtualFile): Boolean {
        return FileTypeRegistry.getInstance().isFileOfType(file, MiniZincFileType.INSTANCE)
    }

    override fun registerFileTypesUsedForIndexing(fileTypeSink: Consumer<in FileType>) {
        fileTypeSink.consume(MiniZincFileType.INSTANCE)
    }

    override fun getIncludeInfos(content: FileContent): Array<FileIncludeInfo> {
        val includeStatements =
            PsiTreeUtil.collectElementsOfType(content.psiFile, MiniZincIncludeImpl::class.java)
                .toList()

        return includeStatements
            .map { i -> FileIncludeInfo(i.stringLiteral?.text ?: "") }
            .toTypedArray()
    }
}
