package com.bardiharborow.minizinc.language

import com.intellij.testFramework.PlatformTestUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincStructureViewTest : BasePlatformTestCase() {
    fun testVariables() {
        doTest(
            "examples/Products.mzn",
            """-Products.mzn
 x_a
 x_b
 profit""",
        )
    }

    fun testClasses() {
        doTest(
            "examples/Classes.mzn",
            """-Classes.mzn
 -Entity
  name""",
        )
    }

    private fun doTest(fileName: String, expected: String) {
        myFixture.configureByFile(fileName)
        myFixture.testStructureView { component ->
            PlatformTestUtil.expandAll(component.tree)
            PlatformTestUtil.assertTreeEqual(component.tree, expected)
        }
    }

    override fun getTestDataPath() = "src/test/testData"
}
