package com.bardiharborow.minizinc.runConfiguration

import com.intellij.execution.ExecutionException
import com.intellij.execution.Executor
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.LocatableConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project

class MiniZincRunConfiguration(project: Project, factory: ConfigurationFactory, name: String) :
    LocatableConfigurationBase<MiniZincConfigurationOptions>(project, factory, name) {
    override fun getOptions(): MiniZincConfigurationOptions {
        return super.getOptions() as MiniZincConfigurationOptions
    }

    fun getScriptName(): String {
        return options.getScriptName()
    }

    fun setScriptName(scriptName: String) {
        return options.setScriptName(scriptName)
    }

    fun getCommandLineOptions(): String {
        return options.getCommandLineOptions()
    }

    fun setCommandLineOptions(commandLineOptions: String) {
        return options.setCommandLineOptions(commandLineOptions)
    }

    fun getSolver(): String {
        return options.getSolver()
    }

    fun setSolver(solver: String) {
        return options.setSolver(solver)
    }

    override fun getConfigurationEditor(): MiniZincSettingsEditor {
        return MiniZincSettingsEditor(project)
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return object : CommandLineState(environment) {
            @Throws(ExecutionException::class)
            override fun startProcess(): ProcessHandler {
                var commandLine: GeneralCommandLine =
                    GeneralCommandLine()
                        .withExePath("minizinc")
                        .withParameters(
                            options.getCommandLineOptions().split(" ").filter { it.isNotBlank() }
                        )

                if (getSolver().isNotBlank()) {
                    commandLine = commandLine.withParameters("--solver", getSolver())
                }

                commandLine = commandLine.withParameters(options.getScriptName())

                val processHandler =
                    ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)

                ProcessTerminatedListener.attach(processHandler)

                return processHandler
            }
        }
    }
}
