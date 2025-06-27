package com.bardiharborow.minizinc.language.formatting

import com.intellij.application.options.CodeStyle
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.util.ThrowableRunnable
import java.lang.RuntimeException

class MiniZincFormatterTest : BasePlatformTestCase() {
    fun testFormatter() {
        myFixture.configureByFile("formatter_before.mzn")
        CodeStyle.getLanguageSettings(myFixture.file).SPACE_AROUND_ASSIGNMENT_OPERATORS = true
        CodeStyle.getLanguageSettings(myFixture.file).KEEP_BLANK_LINES_IN_CODE = 2

        WriteCommandAction.writeCommandAction(project)
            .run<RuntimeException?>(
                ThrowableRunnable {
                    CodeStyleManager.getInstance(project)
                        .reformatText(myFixture.file, listOf(myFixture.file.textRange))
                }
            )
        myFixture.checkResultByFile("formatter_after.mzn")
    }

    override fun getTestDataPath() = "src/test/testData"
}
