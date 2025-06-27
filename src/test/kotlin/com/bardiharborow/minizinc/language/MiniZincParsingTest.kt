package com.bardiharborow.minizinc.language

import com.intellij.testFramework.ParsingTestCase

class MiniZincParsingTest : ParsingTestCase("", "mzn", MiniZincParserDefinition()) {
    fun testDeclaration() {
        doTest(true, true)
    }

    fun testMapColoring() {
        doTest(true, true)
    }

    fun testNQueens() {
        doTest(true, true)
    }

    fun testProducts() {
        doTest(true, true)
    }

    fun testRectanglePacking() {
        doTest(true, true)
    }

    fun testSudoku() {
        doTest(true, true)
    }

    fun testClasses() {
        doTest(true, true)
    }

    override fun getTestDataPath() = "src/test/testData/parsing"

    override fun includeRanges() = true
}
