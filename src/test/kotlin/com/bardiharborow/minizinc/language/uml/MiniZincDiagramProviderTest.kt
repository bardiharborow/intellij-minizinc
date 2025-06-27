package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramDataModel
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramEdge
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramNode
import com.intellij.diagram.DiagramRelationshipInfoAdapter
import com.intellij.diagram.presentation.DiagramLineType
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.impl.SimpleDataContext
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class MiniZincDiagramProviderTest : BasePlatformTestCase() {
    val provider = MiniZincDiagramProvider()

    fun testDataModel() {
        myFixture.configureByFile("Problem.mzn")

        val elements =
            provider.elementManager.findElementsInDataContext(
                SimpleDataContext.builder().add(CommonDataKeys.PSI_ELEMENT, myFixture.file).build()
            )

        assertSize(2, elements)
        assert(elements.first() is MiniZincClassDeclaration)
        assert(elements.last() is MiniZincParameter)

        val dataModel = MiniZincDiagramDataModel(myFixture.project, myFixture.file, null, provider)

        for (element in elements) {
            dataModel.addElement(element)
        }

        val classDeclarationNode = MiniZincDiagramNode(elements.first(), provider)
        val parameterNode = MiniZincDiagramNode(elements.last(), provider)

        val nodes = dataModel.nodes.toMutableList()
        val edges = dataModel.edges.toMutableList()

        assertContainsElements(nodes, classDeclarationNode, parameterNode)

        assertContainsElements(
            edges,
            MiniZincDiagramEdge(
                classDeclarationNode,
                parameterNode,
                DiagramRelationshipInfoAdapter("attribute", DiagramLineType.SOLID),
            ),
        )

        val edge = edges.first()

        assertEquals(edge.source, classDeclarationNode)
        assertEquals(edge.target, parameterNode)

        dataModel.refreshDataModel()

        assertContainsElements(dataModel.nodes, nodes)
        assertContainsElements(dataModel.edges, edges)
    }

    override fun getTestDataPath() = "src/test/testData/diagrams"
}
