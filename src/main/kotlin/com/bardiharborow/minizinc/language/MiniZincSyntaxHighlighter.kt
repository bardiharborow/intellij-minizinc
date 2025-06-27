package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.language.psi.MiniZincTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NotNull

class MiniZincSyntaxHighlighter : SyntaxHighlighterBase() {
    @NotNull
    override fun getHighlightingLexer(): Lexer {
        return MiniZincLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): @NotNull Array<TextAttributesKey?> {
        return when (tokenType) {
            MiniZincTypes.BNF_FILE_DOCUMENTATION_COMMENT -> COMMENT_KEYS
            MiniZincTypes.BNF_DOCUMENTATION_COMMENT -> COMMENT_KEYS
            MiniZincTypes.BNF_BLOCK_COMMENT -> COMMENT_KEYS

            MiniZincTypes.BNF_BRACE_LEFT -> BRACES_KEYS
            MiniZincTypes.BNF_BRACE_RIGHT -> BRACES_KEYS
            MiniZincTypes.BNF_BRACKET_LEFT -> BRACKETS_KEYS
            MiniZincTypes.BNF_BRACKET_LEFT_2D -> BRACKETS_KEYS
            MiniZincTypes.BNF_BRACKET_RIGHT -> BRACKETS_KEYS
            MiniZincTypes.BNF_BRACKET_RIGHT_2D -> BRACKETS_KEYS
            MiniZincTypes.BNF_COMMA -> COMMA_KEYS
            // MiniZincTypes.BNF_COLON -> SEMICOLON_KEYS
            MiniZincTypes.BNF_KEYWORD_ABSENT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ANN -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ANNOTATION -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ANY -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ARRAY -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_BOOL -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_CASE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_CLASS -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_CONSTRAINT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_DEFAULT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ELSE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ELSEIF -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ENDIF -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_ENUM -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_EXTENDS -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_FLOAT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_FUNCTION -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_IF -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_INCLUDE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_INFINITY -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_INT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_LET -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_LIST -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_MAXIMIZE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_MINIMIZE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_NEW -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_OF -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_OPT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_OUTPUT -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_PAR -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_PREDICATE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_RECORD -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_SATISFY -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_SET -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_SOLVE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_STRING -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_TEST -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_THEN -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_TUPLE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_TYPE -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_VAR -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_VARIANT_RECORD -> KEYWORD_KEYS
            MiniZincTypes.BNF_KEYWORD_WHERE -> KEYWORD_KEYS
            MiniZincTypes.BNF_LINE_COMMENT -> COMMENT_KEYS
            MiniZincTypes.BNF_OPERATOR_AND -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_COLONCOLON -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_DIFF -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_DIV -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_DOTDOT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_DOTDOT_LE -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_EQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_EQUIV -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_GQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_GR -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_IDIV -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_IMPL -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_IN -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_INTERSECT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_LE -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_LE_DOTDOT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_LE_DOTDOT_LE -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_LQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_MINUS -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_MOD -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_MULT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_NOT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_NQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_OR -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_PLUS -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_PLUSPLUS -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_POW -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_POW_MINUS1 -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_RIMPL -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_SUBSET -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_SUPERSET -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_SYMDIFF -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_UNION -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_DIV -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_EQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_IDIV -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_MINUS -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_MULT -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_NQ -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_WEAK_PLUS -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_OPERATOR_XOR -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_PARENTHESIS_LEFT -> PARENTHESES_KEYS
            MiniZincTypes.BNF_PARENTHESIS_RIGHT -> PARENTHESES_KEYS
            // MiniZinc.BNF_PIPE
            // MiniZincTypes.BNF_QUOTE -> QUOTE
            MiniZincTypes.BNF_SEMICOLON -> SEMICOLON_KEYS
            MiniZincTypes.BNF_STRING_LITERAL -> STRING_KEYS
            MiniZincTypes.BNF_TOKEN_IDENTIFIER -> IDENTIFIER_KEYS
            MiniZincTypes.BNF_TOKEN_INTEGER -> NUMBERS_KEYS
            MiniZincTypes.BNF_COLON -> OPERATION_SIGN_KEYS
            MiniZincTypes.BNF_EQUALS -> OPERATION_SIGN_KEYS
            // BNF_UNDERSCORE
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val STRING: TextAttributesKey? =
            createTextAttributesKey("MINIZINC_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT: TextAttributesKey? =
            createTextAttributesKey(
                "MiniZinc_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT,
            )
        val BAD_CHARACTER: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val KEYWORD: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val SEMICOLON: TextAttributesKey? =
            createTextAttributesKey(
                "MiniZinc_SEMICOLON",
                DefaultLanguageHighlighterColors.SEMICOLON,
            )
        val COMMA: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_COMMA", DefaultLanguageHighlighterColors.COMMA)

        val OPERATION_SIGN: TextAttributesKey? =
            createTextAttributesKey(
                "MiniZinc_OPERATION_SIGN",
                DefaultLanguageHighlighterColors.OPERATION_SIGN,
            )
        val PARENTHESES: TextAttributesKey? =
            createTextAttributesKey(
                "MiniZinc_PARENTHESES",
                DefaultLanguageHighlighterColors.PARENTHESES,
            )
        val BRACES: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_BRACES", DefaultLanguageHighlighterColors.BRACES)
        val BRACKETS: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val IDENTIFIERS: TextAttributesKey? =
            createTextAttributesKey(
                "MiniZinc_IDENTIFIERS",
                DefaultLanguageHighlighterColors.IDENTIFIER,
            )
        val NUMBERS: TextAttributesKey? =
            createTextAttributesKey("MiniZinc_NUMBERS", DefaultLanguageHighlighterColors.NUMBER)

        private val BAD_CHAR_KEYS: Array<TextAttributesKey?> =
            arrayOf<TextAttributesKey?>(BAD_CHARACTER)
        private val STRING_KEYS: Array<TextAttributesKey?> = arrayOf<TextAttributesKey?>(STRING)
        private val COMMENT_KEYS: Array<TextAttributesKey?> = arrayOf<TextAttributesKey?>(COMMENT)
        private val EMPTY_KEYS: Array<TextAttributesKey?> = arrayOfNulls<TextAttributesKey>(0)
        private val KEYWORD_KEYS: Array<TextAttributesKey?> = arrayOf(KEYWORD)
        private val SEMICOLON_KEYS: Array<TextAttributesKey?> = arrayOf(SEMICOLON)
        private val OPERATION_SIGN_KEYS: Array<TextAttributesKey?> = arrayOf(OPERATION_SIGN)
        private val COMMA_KEYS: Array<TextAttributesKey?> = arrayOf(COMMA)
        private val PARENTHESES_KEYS: Array<TextAttributesKey?> = arrayOf(PARENTHESES)
        private val BRACES_KEYS: Array<TextAttributesKey?> = arrayOf(BRACES)
        private val BRACKETS_KEYS: Array<TextAttributesKey?> = arrayOf(BRACKETS)
        private val IDENTIFIER_KEYS: Array<TextAttributesKey?> = arrayOf(IDENTIFIERS)
        private val NUMBERS_KEYS: Array<TextAttributesKey?> = arrayOf(NUMBERS)
    }
}
