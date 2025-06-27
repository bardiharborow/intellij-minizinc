package com.bardiharborow.minizinc.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincFindUsagesTest : BasePlatformTestCase() {
    fun testFindUsages() {
        myFixture.configureByText(
            MiniZincFileType.INSTANCE,
            "int: f<caret>oo = 1;\nconstraint foo == 1;",
        )
        // TODO: UsingAction
        val usages = myFixture.testFindUsages()
        assertEmpty(usages)
    }
}
