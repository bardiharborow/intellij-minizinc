package com.bardiharborow.minizinc.language.psi

import com.intellij.model.psi.PsiCompletableReference
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
interface MiniZincReference : PsiSymbolReference, PsiCompletableReference, PsiElement {}
