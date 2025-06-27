package com.bardiharborow.minizinc.language.formatting

import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.Spacing
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.formatting.WrapType
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class MiniZincBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    val spacingBuilder: SpacingBuilder,
) : AbstractBlock(node, wrap, alignment) {
    override fun buildChildren(): List<Block?>? {
        val blocks: MutableList<Block?> = ArrayList<Block?>()
        var child: ASTNode? = myNode.firstChildNode
        while (child != null) {
            if (child.elementType !== TokenType.WHITE_SPACE) {
                val block: Block =
                    MiniZincBlock(
                        child,
                        Wrap.createWrap(WrapType.NONE, false),
                        Alignment.createAlignment(),
                        spacingBuilder,
                    )
                blocks.add(block)
            }
            child = child.treeNext
        }
        return blocks
    }

    override fun getIndent(): Indent {
        return Indent.getNoneIndent()
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }
}
