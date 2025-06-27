package com.bardiharborow.minizinc.language.editing

import com.bardiharborow.minizinc.language.MiniZincFileType
import com.intellij.codeInsight.generation.actions.CommentByBlockCommentAction
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincCommenterTest : BasePlatformTestCase() {
    fun testLineComments() {
        // Test that lines can be commented and uncommented
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "<caret>int: i = 0;")
        val lineCommentAction = CommentByLineCommentAction()
        lineCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult("% int: i = 0;")
        lineCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult("int: i = 0;")

        // Test that line comments without a leading space can be uncommented
        myFixture.configureByText(MiniZincFileType.Companion.INSTANCE, "<caret>%int: i = 0;")
        lineCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult("int: i = 0;")
    }

    fun testBlockComments() {
        // Test that blocks can be commented and uncommented
        myFixture.configureByText(
            MiniZincFileType.Companion.INSTANCE,
            "<selection>int: i = 0;</selection>\n",
        )
        val blockCommentAction = CommentByBlockCommentAction()
        blockCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult("/* int: i = 0; */\n")
        blockCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult(" int: i = 0; \n") // TODO: Should be "int: i = 0;\n"

        // Test that block comments without a leading and trailing space can be uncommented
        myFixture.configureByText(
            MiniZincFileType.Companion.INSTANCE,
            "<selection>/*int: i = 0;*/</selection>\n",
        )
        blockCommentAction.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult("int: i = 0;\n")
    }
}
