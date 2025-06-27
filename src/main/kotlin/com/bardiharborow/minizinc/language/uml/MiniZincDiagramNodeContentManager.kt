package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.uml.model.MiniZincDiagramNode
import com.intellij.diagram.AbstractDiagramNodeContentManager
import com.intellij.diagram.DiagramBuilder
import com.intellij.diagram.DiagramCategory
import com.intellij.icons.AllIcons
import com.jetbrains.rhizomedb.Attribute

class MiniZincDiagramNodeContentManager : AbstractDiagramNodeContentManager() {
    companion object {
        private val FIELDS =
            DiagramCategory(
                MyBundle.messagePointer("diagrams.categories.fields"),
                AllIcons.Nodes.Field,
                true,
            )

        private val CATEGORIES = arrayOf(FIELDS)
    }

    override fun getContentCategories(): Array<DiagramCategory> = CATEGORIES

    override fun isInCategory(
        nodeElement: Any?,
        item: Any?,
        category: DiagramCategory,
        builder: DiagramBuilder?,
    ): Boolean {
        if (item !is MiniZincDiagramNode) return false

        val type = item.getType()

        return when (category) {
            FIELDS -> type == MiniZincDiagramNode.Type.Attribute
            else -> false
        }
    }
}
