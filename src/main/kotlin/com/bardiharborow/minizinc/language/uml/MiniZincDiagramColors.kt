package com.bardiharborow.minizinc.language.uml

import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.ui.JBColor
import java.awt.Color

class MiniZincDiagramColors {
    companion object {
        val NODE_VARIABLE: ColorKey =
            ColorKey.createColorKey(
                "MINIZINC_DIAGRAM_NODE_VARIABLE",
                JBColor(Color(134, 166, 220), Color(134, 166, 220)),
            )
        val NODE_DOMAIN: ColorKey =
            ColorKey.createColorKey(
                "MINIZINC_DIAGRAM_NODE_DOMAIN",
                JBColor(Color(252, 238, 190), Color(252, 238, 190)),
            )
        val NODE_INSTANCE: ColorKey =
            ColorKey.createColorKey(
                "MINIZINC_DIAGRAM_NODE_INSTANCE",
                JBColor(Color(179, 200, 184), Color(179, 200, 184)),
            )
    }
}
