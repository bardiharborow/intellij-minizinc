package com.bardiharborow.minizinc.runConfiguration

import com.bardiharborow.minizinc.MyBundle
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel
import javax.swing.JTextField

class MiniZincSettingsEditor(project: Project) : SettingsEditor<MiniZincRunConfiguration>() {
    private val myPanel: JPanel

    private val scriptPathField = TextFieldWithBrowseButton()
    private val argumentsField = JTextField()
    private val solverField = ComboBox<MiniZincSolver>()

    init {
        scriptPathField.addBrowseFolderListener(
            project,
            FileChooserDescriptorFactory.singleFile()
                .withTitle(MyBundle.getMessage("runConfiguration.selectFile")),
        )

        myPanel =
            FormBuilder.createFormBuilder()
                .addLabeledComponent(
                    MyBundle.getMessage("runConfiguration.scriptPath"),
                    scriptPathField,
                )
                .addLabeledComponent(
                    MyBundle.getMessage("runConfiguration.arguments"),
                    argumentsField,
                )
                .addLabeledComponent(MyBundle.getMessage("runConfiguration.solver"), solverField)
                .panel
    }

    override fun resetEditorFrom(runConfiguration: MiniZincRunConfiguration) {
        scriptPathField.text = runConfiguration.getScriptName()
        argumentsField.text = runConfiguration.getCommandLineOptions()

        solverField.removeAllItems()

        // TODO: Implement auto-discovery via `minizinc --solvers`
        solverField.addItem(MiniZincSolver("", "<system default>"))
        solverField.addItem(MiniZincSolver("org.chuffed.chuffed", "Chuffed"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.coin-bc", "COIN-BC"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.cplex", "CPLEX"))
        solverField.addItem(MiniZincSolver("org.minizinc.findmus", "findMUS"))
        solverField.addItem(MiniZincSolver("org.gecode.gecode", "Gecode"))
        solverField.addItem(MiniZincSolver("org.gecode.gist", "Gecode Gist"))
        solverField.addItem(MiniZincSolver("org.minizinc.globalizer", "Globalizer"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.gurobi", "GNU"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.highs", "HiGHS"))
        solverField.addItem(MiniZincSolver("com.google.ortools.sat", "OR Tools CP-SAT"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.scip", "SCIP"))
        solverField.addItem(MiniZincSolver("org.minizinc.mip.xpress", "Xpress"))

        // TODO: Restore the solver when opening the settings editor.
        // miniZincSolverField.selectedItem = demoRunConfiguration.getSolver()
    }

    override fun applyEditorTo(demoRunConfiguration: MiniZincRunConfiguration) {
        demoRunConfiguration.setScriptName(scriptPathField.text)
        demoRunConfiguration.setCommandLineOptions(argumentsField.text)
        demoRunConfiguration.setSolver(solverField.item.id)
    }

    override fun createEditor() = myPanel
}
