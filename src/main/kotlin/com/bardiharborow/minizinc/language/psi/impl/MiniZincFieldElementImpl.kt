package com.bardiharborow.minizinc.language.psi.impl

import com.bardiharborow.minizinc.language.MiniZincSymbol
import com.bardiharborow.minizinc.language.psi.MiniZincIdentifier
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

@Suppress("UnstableApiUsage")
abstract class MiniZincFieldElementImpl(node: ASTNode) :
    ASTWrapperPsiElement(node), PsiSymbolDeclaration, PsiNameIdentifierOwner, ItemPresentation {
    abstract fun getIdentifier(): MiniZincIdentifier

    override fun getNameIdentifier(): MiniZincIdentifier? = getIdentifier()

    override fun getDeclaringElement(): PsiElement = nameIdentifier ?: this

    override fun getRangeInDeclaringElement(): TextRange {
        return nameIdentifier?.textRange ?: TextRange.EMPTY_RANGE
    }

    override fun getName(): String {
        return nameIdentifier?.text ?: ""
    }

    override fun setName(name: String): PsiElement {
        return this
    }

    override fun getSymbol(): Symbol {
        return MiniZincSymbol(this.containingFile, name)
    }

    override fun getIcon(unused: Boolean): Icon? = getIcon(0)

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Field

    override fun getPresentation(): ItemPresentation = this

    override fun getPresentableText(): String = name

    override fun toString(): String = "parameter"
}
