package com.bardiharborow.minizinc.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class MiniZincStatementElementImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun deleteChildInternal(child: ASTNode) {
        // Ensure the statement is deleted if its child element is deleted
        super.deleteChildInternal(child)
        delete()
    }
}
