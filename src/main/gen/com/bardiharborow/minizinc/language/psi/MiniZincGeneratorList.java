// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincGeneratorList extends PsiElement {

  @NotNull
  List<MiniZincExpression> getExpressionList();

  @NotNull
  List<MiniZincGenerator> getGeneratorList();

  @NotNull
  List<MiniZincGeneratorEquation> getGeneratorEquationList();

}
