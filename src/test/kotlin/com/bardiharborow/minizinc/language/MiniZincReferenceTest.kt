package com.bardiharborow.minizinc.language

import com.intellij.codeInsight.navigation.actions.GotoDeclarationAction
import com.intellij.model.Symbol
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincReferenceTest : BasePlatformTestCase() {
    fun testReference() {
        myFixture.configureByFile("rename_before.mzn")
        val referenceAtCaret = myFixture.findSingleReferenceAtCaret()
        val resolvedSymbols = referenceAtCaret.resolveReference()
        assertSameElements<Symbol>(
            resolvedSymbols,
            listOf<Symbol>(MiniZincSymbol(myFixture.file, "foo")),
        )
    }

    fun testVariableRename() {
        // TODO: UsingHandler
        myFixture.testRename("rename_before.mzn", "rename_after.mzn", "bar")
    }

    fun testGoTo() {
        myFixture.configureByFile("rename_before.mzn")

        val declarationElement =
            GotoDeclarationAction.findTargetElement(
                project,
                myFixture.editor,
                myFixture.caretOffset,
            )

        assertNotNull(declarationElement)
    }

    override fun getTestDataPath() = "src/test/testData"
}
