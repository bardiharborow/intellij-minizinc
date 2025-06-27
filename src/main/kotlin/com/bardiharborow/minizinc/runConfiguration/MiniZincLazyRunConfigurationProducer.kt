package com.bardiharborow.minizinc.runConfiguration

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class MiniZincLazyRunConfigurationProducer :
    LazyRunConfigurationProducer<MiniZincRunConfiguration>(), DumbAware {
    override fun getConfigurationFactory(): ConfigurationFactory {
        return MiniZincConfigurationType()
    }

    override fun setupConfigurationFromContext(
        config: MiniZincRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>,
    ): Boolean {
        val file = context.psiLocation?.containingFile?.virtualFile ?: return false

        config.setScriptName(file.path)

        return true
    }

    override fun isConfigurationFromContext(
        config: MiniZincRunConfiguration,
        context: ConfigurationContext,
    ): Boolean = true
}
