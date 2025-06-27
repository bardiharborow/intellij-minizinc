package com.bardiharborow.minizinc.language.editing

import com.intellij.editor.TodoItemsTestCase
import com.intellij.ide.todo.TodoIndexPatternProvider
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.psi.impl.cache.TodoCacheManager
import com.intellij.psi.impl.cache.impl.todo.TodoIndex
import com.intellij.psi.impl.cache.impl.todo.TodoIndexEntry
import com.intellij.psi.search.PsiTodoSearchHelper
import com.intellij.util.containers.ContainerUtil
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileBasedIndexEx
import com.intellij.util.indexing.StorageException

/** Modified from com.intellij.editor.TodoItemsTestCase */
class MiniZincTodoItemsTestCase : TodoItemsTestCase() {
    override fun getFileExtension(): String = "mzn"

    override fun supportsCStyleSingleLineComments(): Boolean = false

    override fun supportsCStyleMultiLineComments(): Boolean = true

    override fun testSuccessiveLineComments() {
        testTodos("% [TODO first line]\n%      [second line]")
    }

    override fun testSuccessiveLineCommentsAfterEditing() {
        testTodos("% [TODO first line]\n% <caret>second line")
        type("     ")
        checkTodos("% [TODO first line]\n%      [second line]")
    }

    override fun testNewTodoAfterUnsavedEditing() {
        testTodos("% [TODO first]\nwords\n<caret>")
        val document = editor.document
        val documentManager = FileDocumentManager.getInstance()
        val todoSearchHelper = PsiTodoSearchHelper.getInstance(project)
        assertTodoCountInIndexStorage(0)
        documentManager.saveDocument(document)
        assertFalse("saved doc expected", documentManager.isDocumentUnsaved(document))
        assertEquals(1, todoSearchHelper.getTodoItemsCount(file))
        assertSameTodoCountInIndexAndHighlighting()
        assertTodoCountInIndexStorage(1)
        type("// TODO second")
        assertTrue("unsaved doc expected", documentManager.isDocumentUnsaved(document))
        assertEquals(2, todoSearchHelper.getTodoItemsCount(file))
        checkTodos(
            """
                 // [TODO first]
                 words
                 // [TODO second]
                 """
                .trimIndent()
        )
        assertSameTodoCountInIndexAndHighlighting()
        assertTodoCountInIndexStorage(1)
    }

    override fun testAllLinesLoseHighlightingWithFirstLine() {
        testTodos("% [TO<caret>DO first line]\n%      [second line]")
        delete()
        checkTodos("% TOO first line\n%      second line")
    }

    override fun testContinuationIsNotOverlappedWithFollowingTodo() {
        testTodos("% [TODO first line]\n%  [TODO second line]")
    }

    private fun assertTodoCountInIndexStorage(count: Int) {
        try {
            val map =
                ContainerUtil.getFirstItem<MutableMap<TodoIndexEntry?, Int?>?>(
                    (FileBasedIndex.getInstance() as FileBasedIndexEx)
                        .getIndex<Int?, MutableMap<TodoIndexEntry?, Int?>?>(TodoIndex.NAME)
                        .getIndexedFileData(FileBasedIndex.getFileId(getVFile()))
                        .values
                )
            val result =
                if (map == null) 0 else map.values.stream().mapToInt { o: Int? -> o!! }.sum()
            assertEquals(count, result)
        } catch (e: StorageException) {
            throw RuntimeException(e)
        }
    }

    private fun assertSameTodoCountInIndexAndHighlighting() {
        val todosInIndex =
            TodoCacheManager.getInstance(project)
                .getTodoCount(vFile, TodoIndexPatternProvider.getInstance())
        val todosInHighlighting = PsiTodoSearchHelper.getInstance(project).findTodoItems(file).size
        assertEquals(
            "Mismatch between todos in index and highlighting",
            todosInIndex,
            todosInHighlighting,
        )
    }
}
