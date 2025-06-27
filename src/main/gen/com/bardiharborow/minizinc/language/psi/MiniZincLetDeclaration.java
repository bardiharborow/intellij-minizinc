// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincLetDeclaration extends PsiElement {

  @Nullable
  MiniZincAnnotations getAnnotations();

  @Nullable
  MiniZincExpression getExpression();

  @NotNull
  MiniZincIdentifier getIdentifier();

  @NotNull
  MiniZincType getType();

}
