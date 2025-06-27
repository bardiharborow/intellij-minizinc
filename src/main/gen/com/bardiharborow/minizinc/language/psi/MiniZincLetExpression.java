// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincLetExpression extends MiniZincExpression {

  @Nullable
  MiniZincCommaOrSemi getCommaOrSemi();

  @NotNull
  MiniZincExpression getExpression();

  @Nullable
  MiniZincLetDeclarationList getLetDeclarationList();

}
