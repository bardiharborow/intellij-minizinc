package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincFile
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.diagram.DiagramVfsResolver
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiNameIdentifierOwner

class MiniZincDiagramVfsResolver : DiagramVfsResolver<PsiElement> {
    override fun getQualifiedName(element: PsiElement?): String? {
        return when (element) {
            is PsiDirectory -> element.virtualFile.url
            is MiniZincFile -> element.virtualFile?.url
            is MiniZincParameter -> {
                if (element.parent is MiniZincClassDeclaration) {
                    return (element.parent as MiniZincClassDeclaration).identifier?.text +
                        "." +
                        element.identifier?.text
                }

                return null
            }
            is PsiNameIdentifierOwner -> element.name
            else -> null
        }
    }

    override fun resolveElementByFQN(s: String, project: Project): PsiElement? {
        val vFile = VirtualFileManager.getInstance().findFileByUrl(s) ?: return null

        val manager = PsiManager.getInstance(project)
        return manager.findFile(vFile) ?: manager.findDirectory(vFile)
    }
}
