package com.bardiharborow.minizinc.language.editing

import com.bardiharborow.minizinc.language.MiniZincFileType
import com.intellij.codeInsight.highlighting.BraceMatchingUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincBraceMatcherTest : BasePlatformTestCase() {
    fun testBraces() {
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "<caret>{}")
        val offset = BraceMatchingUtil.getMatchedBraceOffset(myFixture.editor, true, myFixture.file)
        assertEquals(1, offset)
    }

    fun testBrackets() {
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "<caret>[]")
        val offset = BraceMatchingUtil.getMatchedBraceOffset(myFixture.editor, true, myFixture.file)
        assertEquals(1, offset)
    }

    fun testParentheses() {
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "<caret>()")
        val offset = BraceMatchingUtil.getMatchedBraceOffset(myFixture.editor, true, myFixture.file)
        assertEquals(1, offset)
    }
}
