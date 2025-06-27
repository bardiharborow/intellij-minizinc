// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincFunction extends PsiElement {

  @NotNull
  MiniZincAnnotationParameter getAnnotationParameter();

  @Nullable
  MiniZincAnnotations getAnnotations();

  @Nullable
  MiniZincIdOrQuotedOp getIdOrQuotedOp();

  @Nullable
  MiniZincIdentifier getIdentifier();

  @NotNull
  MiniZincOperationItemTail getOperationItemTail();

  @NotNull
  MiniZincParameters getParameters();

  @NotNull
  MiniZincType getType();

}
