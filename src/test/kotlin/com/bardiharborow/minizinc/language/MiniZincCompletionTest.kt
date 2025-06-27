package com.bardiharborow.minizinc.language

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincCompletionTest : BasePlatformTestCase() {
    fun testCompletion() {
        myFixture.configureByFiles("completion.mzn")
        myFixture.complete(CompletionType.BASIC)
        val lookupElementStrings = myFixture.lookupElementStrings!!
        assertSameElements<String>(lookupElementStrings, "variableA", "variableB")
    }

    override fun getTestDataPath() = "src/test/testData"
}
