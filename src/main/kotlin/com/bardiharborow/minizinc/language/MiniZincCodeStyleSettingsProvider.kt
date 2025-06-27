package com.bardiharborow.minizinc.language

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class MiniZincCodeStyleSettingsProvider : CodeStyleSettingsProvider() {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        return MiniZincCodeStyleSettings(settings)
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings,
    ): CodeStyleConfigurable {
        return object :
            CodeStyleAbstractConfigurable(settings, modelSettings, this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return MiniZincCodeStyleMainPanel(currentSettings, settings)
            }
        }
    }

    private class MiniZincCodeStyleMainPanel(
        currentSettings: CodeStyleSettings?,
        settings: CodeStyleSettings,
    ) : TabbedLanguageCodeStylePanel(MiniZincLanguage.INSTANCE, currentSettings, settings)
}
