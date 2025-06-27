package com.bardiharborow.minizinc.language.formatting

import com.bardiharborow.minizinc.language.MiniZincLanguage
import com.bardiharborow.minizinc.language.psi.MiniZincTypes
import com.intellij.formatting.Alignment
import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.formatting.WrapType
import com.intellij.psi.codeStyle.CodeStyleSettings

class MiniZincFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val codeStyleSettings: CodeStyleSettings = formattingContext.getCodeStyleSettings()
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            MiniZincBlock(
                formattingContext.node,
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                createSpaceBuilder(codeStyleSettings),
            ),
            codeStyleSettings,
        )
    }

    companion object {
        private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, MiniZincLanguage.Companion.INSTANCE)
                .around(MiniZincTypes.BNF_EQUALS)
                .spaceIf(
                    settings
                        .getCommonSettings(MiniZincLanguage.Companion.INSTANCE.getID())
                        .SPACE_AROUND_ASSIGNMENT_OPERATORS
                )
                .after(MiniZincTypes.BNF_IDENTIFIER)
                .none()
        }
    }
}
