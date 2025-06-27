package com.bardiharborow.minizinc.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincDocumentationTest : BasePlatformTestCase() {
    fun testDocumentation() {
        myFixture.configureByFiles("alldifferent.mzn")
        val originalElement = myFixture.elementAtCaret
        //
        //        var element: PsiElement? =
        //            DocumentationManager.getInstance(project)
        //                .findTargetElement(
        //                    myFixture.getEditor(),
        //                    originalElement.getContainingFile(),
        //                    originalElement,
        //                )
        //
        //        if (element == null) {
        //            element = originalElement
        //        }
        //
        //        val documentationProvider: DocumentationProvider =
        //            DocumentationManager.getProviderFromElement(element)
        //        val generateDoc = documentationProvider.generateDoc(element, originalElement)
        //        assertNotNull(generateDoc)
        //        assertSameLinesWithFile(
        //            getTestDataPath() + "/" + "DocumentationTest.html.expected",
        //            generateDoc!!,
        //        )
    }

    override fun getTestDataPath() = "src/test/testData/documentation"
}
