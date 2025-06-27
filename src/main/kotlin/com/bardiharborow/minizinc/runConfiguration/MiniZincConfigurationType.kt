package com.bardiharborow.minizinc.runConfiguration

import com.bardiharborow.minizinc.MiniZincIcons
import com.bardiharborow.minizinc.MyBundle
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.SimpleConfigurationType
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NotNullLazyValue

class MiniZincConfigurationType :
    SimpleConfigurationType(
        ID,
        "MiniZinc",
        "MiniZinc run configuration type",
        NotNullLazyValue.createValue { MiniZincIcons.FILE },
    ),
    DumbAware {

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return MiniZincRunConfiguration(
            project,
            this,
            MyBundle.getMessage("runConfiguration.unnamed"),
        )
    }

    override fun getOptionsClass(): Class<out BaseState> = MiniZincConfigurationOptions::class.java

    override fun isEditableInDumbMode() = true

    companion object {
        const val ID: String = "MiniZincRunConfiguration"
    }
}
