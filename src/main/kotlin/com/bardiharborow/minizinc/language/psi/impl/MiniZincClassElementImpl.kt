package com.bardiharborow.minizinc.language.psi.impl

import com.bardiharborow.minizinc.language.psi.MiniZincIdentifier
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.psi.PsiNameIdentifierOwner

abstract class MiniZincClassElementImpl(node: ASTNode) :
    MiniZincDeclarationElementImpl(node), PsiSymbolDeclaration, PsiNameIdentifierOwner {
    abstract fun getIdentifier(): MiniZincIdentifier

    override fun getIdentifierList(): List<MiniZincIdentifier> {
        return listOf(getIdentifier())
    }

    override fun getNameIdentifier(): MiniZincIdentifier? = getIdentifier()
}
