package com.bardiharborow.minizinc.language

import com.intellij.testFramework.EditorTestUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincSyntaxHighlightingTest : BasePlatformTestCase() {
    fun testDeclarationHighlighting() {
        val testFile = myFixture.configureByFile("Declaration.mzn")
        EditorTestUtil.testFileSyntaxHighlighting(
            testFile,
            "src/test/testData/highlighting/Declaration.txt",
            false,
        )
    }

    fun testProductsHighlighting() {
        val testFile = myFixture.configureByFile("Products.mzn")
        EditorTestUtil.testFileSyntaxHighlighting(
            testFile,
            "src/test/testData/highlighting/Products.txt",
            false,
        )
    }

    override fun getTestDataPath() = "src/test/testData/highlighting"
}
