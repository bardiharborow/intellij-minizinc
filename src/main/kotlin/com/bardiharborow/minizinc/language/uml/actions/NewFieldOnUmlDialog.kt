package com.bardiharborow.minizinc.language.uml.actions

import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.psi.PsiFile
import com.intellij.ui.components.JBCheckBox
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class NewFieldOnUmlDialog(val psiFile: PsiFile) : DialogWrapper(psiFile.project) {
    private val myVariable: JBCheckBox
    private val myOptional: JBCheckBox

    private val myFieldName: JTextField
    private val myTypeName: ComboBox<String>
    private val myPanel: JPanel

    init {
        myVariable = JBCheckBox()
        myOptional = JBCheckBox()

        myFieldName = JTextField()
        myTypeName = ComboBox(arrayOf("int", "bool", "float", "string"))
        myTypeName.isEditable = true

        myPanel =
            FormBuilder.createFormBuilder()
                .addLabeledComponent("Variable", myVariable)
                .addLabeledComponent("Optional", myOptional)
                .addLabeledComponent("Type", myTypeName)
                .addLabeledComponent("Name", myFieldName)
                .panel

        this.init()
    }

    override fun createCenterPanel(): JComponent? = myPanel

    override fun getPreferredFocusedComponent(): JComponent {
        return this.myFieldName
    }

    fun getFieldName(): String {
        return this.myFieldName.getText()
    }

    fun getTypeName(): String {
        return (if (myVariable.isSelected) "var " else "") +
            (if (myOptional.isSelected) "opt " else "") +
            myTypeName.selectedItem as String
    }

    override fun doValidate(): ValidationInfo? {
        val className = this.myFieldName.getText()
        if (className == null) {
            return ValidationInfo("This should not be empty", this.myFieldName)
        }

        return null
    }
}
