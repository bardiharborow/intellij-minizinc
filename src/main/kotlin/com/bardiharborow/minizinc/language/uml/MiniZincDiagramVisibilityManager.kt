package com.bardiharborow.minizinc.language.uml

import com.bardiharborow.minizinc.MyBundle
import com.bardiharborow.minizinc.language.psi.MiniZincClassDeclaration
import com.bardiharborow.minizinc.language.psi.MiniZincParameter
import com.intellij.diagram.AbstractUmlVisibilityManager
import com.intellij.diagram.VisibilityLevel
import com.intellij.openapi.application.ReadAction
import com.intellij.util.ArrayUtil
import kotlin.Any
import kotlin.Array
import kotlin.Comparator
import kotlin.arrayOf

class MiniZincDiagramVisibilityManager : AbstractUmlVisibilityManager() {
    val INSTANCE_LEVEL =
        VisibilityLevel("domain", MyBundle.messagePointer("visibility.level.domain"))

    val DOMAIN_LEVEL =
        VisibilityLevel("instance", MyBundle.messagePointer("visibility.level.instance"))

    val LEVELS: Array<VisibilityLevel> = arrayOf(DOMAIN_LEVEL, INSTANCE_LEVEL)

    override fun getVisibilityLevels(): Array<VisibilityLevel> = LEVELS

    override fun getVisibilityLevel(element: Any?): VisibilityLevel? {
        return ReadAction.compute<VisibilityLevel?, Throwable> {
            if (element is MiniZincClassDeclaration) {
                val text = element.annotations?.text ?: return@compute null

                if (text.contains("instance")) {
                    return@compute INSTANCE_LEVEL
                } else if (text.contains("domain")) {
                    return@compute DOMAIN_LEVEL
                }
            }

            if (element is MiniZincParameter) {
                val text = element.annotations?.text ?: return@compute null

                if (text.contains("instance")) {
                    return@compute INSTANCE_LEVEL
                } else if (text.contains("domain")) {
                    return@compute DOMAIN_LEVEL
                }
            }

            return@compute null
        }
    }

    override fun getComparator(): Comparator<VisibilityLevel> {
        return Comparator { level1, level2 ->
            ArrayUtil.indexOf(visibilityLevels, level1)
                .compareTo(ArrayUtil.indexOf(visibilityLevels, level2))
        }
    }
}
