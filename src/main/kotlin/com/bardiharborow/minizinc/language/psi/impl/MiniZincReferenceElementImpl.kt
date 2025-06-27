package com.bardiharborow.minizinc.language.psi.impl

import com.bardiharborow.minizinc.language.MiniZincSymbol
import com.bardiharborow.minizinc.language.psi.MiniZincReference
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor

@Suppress("UnstableApiUsage")
open class MiniZincReferenceElementImpl(node: ASTNode) :
    ASTWrapperPsiElement(node), MiniZincReference {
    override fun getElement() = this

    override fun getRangeInElement(): TextRange {
        return TextRange(0, text.length)
    }

    override fun resolveReference(): Collection<Symbol> {
        return listOf(MiniZincSymbol(this.containingFile, text))
    }

    override fun getOwnReferences(): Collection<PsiSymbolReference> {
        return listOf(this)
    }

    override fun getCompletionVariants(): Collection<LookupElement> {
        var elements = ArrayList<LookupElement>()
        val self = this

        this.containingFile.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(ele: PsiElement) {
                    super.visitElement(ele)
                    if (ele == self.parent.parent) return
                    when (ele) {
                        is MiniZincDeclarationImpl -> {
                            elements.add(
                                LookupElementBuilder.createWithSmartPointer(ele.name!!, ele)
                                    .withIcon(ele.getIcon(0))
                            )
                        }
                    }
                }
            }
        )

        return elements
    }
}
