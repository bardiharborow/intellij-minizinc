package com.bardiharborow.minizinc.language.editing

import com.bardiharborow.minizinc.language.MiniZincFileType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincQuoteHandlerTest : BasePlatformTestCase() {
    fun testDoubleQuotes() {
        myFixture.configureByText(MiniZincFileType.INSTANCE, "<caret>")
        myFixture.type("\"")
        myFixture.checkResult("\"\"")
    }

    fun testOverwritingDoubleQuotes() {
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "\"<caret>\"")
        myFixture.type("\"")
        myFixture.checkResult("\"\"")
    }
}
