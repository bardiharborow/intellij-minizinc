package com.bardiharborow.minizinc.language.structure

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.bardiharborow.minizinc.language.psi.impl.MiniZincDeclarationImpl
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class MiniZincStructureViewModel(
    editor: Editor?,
    file: PsiFile,
    root: MiniZincStructureViewTreeElement,
) : StructureViewModelBase(file, editor, root), StructureViewModel.ElementInfoProvider {
    init {
        this.withSuitableClasses(
            MiniZincDeclaration::class.java,
            MiniZincClassDeclaration::class.java,
            MiniZincParameter::class.java,
        )
        this.withSorters(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.value is MiniZincDeclarationImpl || element.value is MiniZincParameter
    }
}
