package com.bardiharborow.minizinc.language.psi.impl

import com.bardiharborow.minizinc.language.MiniZincFileType
import com.bardiharborow.minizinc.language.MiniZincSymbol
import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincIdentifier
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

@Suppress("UnstableApiUsage")
abstract class MiniZincDeclarationElementImpl(node: ASTNode) :
    ASTWrapperPsiElement(node), PsiSymbolDeclaration, PsiNameIdentifierOwner, ItemPresentation {
    abstract fun getIdentifierList(): List<MiniZincIdentifier>

    override fun getNameIdentifier(): MiniZincIdentifier? = getIdentifierList()[0]

    override fun getDeclaringElement(): MiniZincIdentifier = nameIdentifier!!

    override fun getRangeInDeclaringElement(): TextRange {
        return declaringElement.textRange
    }

    override fun getSymbol(): Symbol {
        return MiniZincSymbol(this.containingFile, name)
    }

    override fun getOwnDeclarations(): Collection<PsiSymbolDeclaration> {
        return listOf(this)
    }

    override fun getIcon(unused: Boolean): Icon? = getIcon(0)

    override fun getIcon(flags: Int): Icon? {
        return when (this) {
            is MiniZincClassDeclaration -> AllIcons.Nodes.Class
            is MiniZincDeclaration -> AllIcons.Nodes.Variable
            else -> super.getIcon(flags)
        }
    }

    override fun setName(name: String): PsiElement {
        var dummyFile =
            PsiFileFactory.getInstance(project)
                .createFileFromText("jj.mzn", MiniZincFileType.INSTANCE, "var int: " + name + ";")

        val newElement =
            dummyFile.firstChild.firstChild.firstChild.nextSibling.nextSibling.nextSibling

        // this.getPattern()!!.replace(newElement)

        return this
    }

    override fun getPresentation(): ItemPresentation = this

    override fun getName(): String {
        return declaringElement.text
    }

    override fun getPresentableText(): String = name

    override fun getNavigationElement(): PsiElement = declaringElement
}
