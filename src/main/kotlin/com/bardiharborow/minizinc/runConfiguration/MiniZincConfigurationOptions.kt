package com.bardiharborow.minizinc.runConfiguration

import com.intellij.execution.configurations.LocatableRunConfigurationOptions
import com.intellij.openapi.components.StoredProperty

class MiniZincConfigurationOptions : LocatableRunConfigurationOptions() {
    private val scriptName: StoredProperty<String?> = string("").provideDelegate(this, "scriptName")

    private val commandLineOptions: StoredProperty<String?> =
        string("").provideDelegate(this, "commandLineOptions")

    private val solver: StoredProperty<String?> = string("").provideDelegate(this, "solver")

    fun getScriptName(): String {
        return scriptName.getValue(this) ?: ""
    }

    fun setScriptName(scriptName: String) {
        return this.scriptName.setValue(this, scriptName)
    }

    fun getCommandLineOptions(): String {
        return commandLineOptions.getValue(this) ?: ""
    }

    fun setCommandLineOptions(commandLineOptions: String) {
        this.commandLineOptions.setValue(this, commandLineOptions)
    }

    fun getSolver(): String {
        return solver.getValue(this) ?: ""
    }

    fun setSolver(solver: String) {
        this.solver.setValue(this, solver)
    }
}
