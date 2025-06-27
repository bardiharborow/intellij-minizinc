package com.bardiharborow.minizinc.language

import com.bardiharborow.minizinc.language.psi.impl.MiniZincClassElementImpl
import com.bardiharborow.minizinc.language.psi.impl.MiniZincDeclarationImpl
import com.intellij.find.usages.api.SearchTarget
import com.intellij.find.usages.symbol.SearchTargetSymbol
import com.intellij.icons.AllIcons
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.navigation.NavigatableSymbol
import com.intellij.navigation.SymbolNavigationService
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.project.Project
import com.intellij.platform.backend.documentation.DocumentationResult
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.navigation.NavigationTarget
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import com.intellij.refactoring.rename.api.RenameTarget
import com.intellij.refactoring.rename.symbol.RenameableSymbol
import com.intellij.ui.GuiUtils

@Suppress("UnstableApiUsage")
class MiniZincSymbol(val file: PsiFile, val name: String) :
    NavigatableSymbol, SearchTargetSymbol, RenameableSymbol, DocumentationTarget, Symbol {
    override fun createPointer(): Pointer<MiniZincSymbol> {
        return Pointer.hardPointer(this)
    }

    override fun equals(other: Any?): Boolean {
        return other is MiniZincSymbol && this.name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override val searchTarget: SearchTarget
        get() = MiniZincSearchTarget(file, name)

    override val renameTarget: RenameTarget
        get() = MiniZincRenameTarget(file, name)

    private fun getDeclaration(): MiniZincDeclarationImpl? {
        val self = this
        var elements = ArrayList<MiniZincDeclarationImpl>()

        // Walk through the PSI tree to find declarations
        file.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)
                    // Check if the element is a class, method, or field declaration
                    when (element) {
                        is MiniZincDeclarationImpl -> {
                            if (element.symbol == self) {
                                elements.add(element)
                            }
                        }
                    }
                }
            }
        )

        if (elements.size != 1) return null
        return elements[0]
    }

    private fun getClassDeclaration(): MiniZincClassElementImpl? {
        val self = this
        var elements = ArrayList<MiniZincClassElementImpl>()

        // Walk through the PSI tree to find declarations
        file.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)
                    // Check if the element is a class, method, or field declaration
                    when (element) {
                        is MiniZincClassElementImpl -> {
                            if (element.symbol == self) {
                                elements.add(element)
                            }
                        }
                    }
                }
            }
        )

        if (elements.size != 1) return null
        return elements[0]
    }

    override fun getNavigationTargets(project: Project): Collection<NavigationTarget> {
        val declaration = getDeclaration() ?: return emptyList()

        return listOf(SymbolNavigationService.getInstance().psiElementNavigationTarget(declaration))
    }

    override val navigatable: Navigatable?
        get() {
            return getDeclaration()
        }

    override fun computePresentation(): TargetPresentation {
        return TargetPresentation.builder(name).icon(AllIcons.Nodes.DoneMark).presentation()
    }

    override fun computeDocumentationHint(): String? = "demo text"

    override fun computeDocumentation(): DocumentationResult? {
        val declaration = getDeclaration()
        var html = "<div class=\"definition\"><pre>"

        if (declaration != null) {
            val attributes =
                EditorColorsManager.getInstance()
                    .globalScheme
                    .getAttributes(MiniZincSyntaxHighlighter.KEYWORD)
                    .clone()
            val foreground = attributes.foregroundColor
            if (foreground != null) {
                html += "<span style=\"color:#" + GuiUtils.colorToHex(foreground) + "\">"
            }
            html += declaration.type?.text ?: ""
            if (foreground != null) {
                html += "</span>"
            }

            html += ": "

            val identifierAttributes =
                EditorColorsManager.getInstance()
                    .globalScheme
                    .getAttributes(MiniZincSyntaxHighlighter.IDENTIFIERS)
                    .clone()
            val identifierForeground = identifierAttributes.foregroundColor
            if (identifierForeground != null) {
                html += "<span style=\"color:#" + GuiUtils.colorToHex(identifierForeground) + "\">"
            }
            html += declaration.name
            if (identifierForeground != null) {
                html += "</span>"
            }
            html += "</pre></div>"
            // html += "<hr><div class=\"content\"><p>docs</p></div>"
        } else {
            val classDeclaration = getClassDeclaration() ?: return null

            val attributes =
                EditorColorsManager.getInstance()
                    .globalScheme
                    .getAttributes(MiniZincSyntaxHighlighter.KEYWORD)
                    .clone()
            val foreground = attributes.foregroundColor
            if (foreground != null) {
                html += "<span style=\"color:#" + GuiUtils.colorToHex(foreground) + "\">"
            }
            html += "class"
            if (foreground != null) {
                html += "</span>"
            }

            html += " "

            val identifierAttributes =
                EditorColorsManager.getInstance()
                    .globalScheme
                    .getAttributes(MiniZincSyntaxHighlighter.IDENTIFIERS)
                    .clone()
            val identifierForeground = identifierAttributes.foregroundColor
            if (identifierForeground != null) {
                html += "<span style=\"color:#" + GuiUtils.colorToHex(identifierForeground) + "\">"
            }
            html += classDeclaration.name
            if (identifierForeground != null) {
                html += "</span>"
            }
            html += "</pre></div>"
            // html += "<hr><div class=\"content\"><p>docs</p></div>"
        }

        return DocumentationResult.documentation(html)
    }

    override fun toString(): String {
        return name
    }
}
