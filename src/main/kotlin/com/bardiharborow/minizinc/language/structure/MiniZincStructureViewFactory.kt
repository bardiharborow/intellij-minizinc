package com.bardiharborow.minizinc.language.structure

import com.intellij.ide.structureView.StructureViewBuilder
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class MiniZincStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(file: PsiFile): StructureViewBuilder {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return MiniZincStructureViewModel(
                    editor,
                    file,
                    MiniZincStructureViewTreeElement(file),
                )
            }
        }
    }
}
