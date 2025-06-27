package com.bardiharborow.minizinc.language.uml.actions

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.psi.PsiFile
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class NewClassOnUmlDialog(val psiFile: PsiFile) : DialogWrapper(psiFile.project) {
    private var myClassName: JTextField? = null
    private var myPanel: JPanel? = null

    init {
        myClassName = JTextField()

        myPanel = FormBuilder.createFormBuilder().addLabeledComponent("Name", myClassName!!).panel

        this.init()
    }

    override fun createCenterPanel(): JComponent? = myPanel

    override fun getPreferredFocusedComponent(): JComponent {
        return this.myClassName!!
    }

    fun getClassName(): String {
        return this.myClassName!!.getText()
    }

    override fun doValidate(): ValidationInfo? {
        val className = this.myClassName!!.getText()
        if (className == null) {
            return ValidationInfo("This should not be empty", this.myClassName)
        }

        return null
    }
}
