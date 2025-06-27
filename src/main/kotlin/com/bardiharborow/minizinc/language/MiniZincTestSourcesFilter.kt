package com.bardiharborow.minizinc.language

import com.intellij.openapi.fileTypes.FileTypeRegistry
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile

class MiniZincTestSourcesFilter : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        return FileTypeRegistry.getInstance().isFileOfType(file, MiniZincCheckerFileType.INSTANCE)
    }
}
