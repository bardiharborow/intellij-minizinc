package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.language.parser.MiniZincParser
import com.bardiharborow.minizinc.language.psi.MiniZincFile
import com.bardiharborow.minizinc.language.psi.MiniZincTokenSets
import com.bardiharborow.minizinc.language.psi.MiniZincTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType

class MiniZincParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return MiniZincLexerAdapter()
    }

    override fun getCommentTokens() = MiniZincTokenSets.COMMENTS

    override fun getStringLiteralElements() = MiniZincTokenSets.STRING_LITERALS

    override fun createParser(project: Project): PsiParser {
        return MiniZincParser()
    }

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return MiniZincFile(viewProvider)
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return MiniZincTypes.Factory.createElement(node)
    }

    companion object {
        val FILE: IFileElementType = IFileElementType(MiniZincLanguage.INSTANCE)
    }
}
