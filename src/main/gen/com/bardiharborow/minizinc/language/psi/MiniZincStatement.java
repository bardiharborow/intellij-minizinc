// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincStatement extends PsiElement {

  @Nullable
  MiniZincAnnotation getAnnotation();

  @Nullable
  MiniZincAssignment getAssignment();

  @Nullable
  MiniZincClassDeclaration getClassDeclaration();

  @Nullable
  MiniZincConstraint getConstraint();

  @Nullable
  MiniZincDeclaration getDeclaration();

  @Nullable
  MiniZincFunction getFunction();

  @Nullable
  MiniZincGoal getGoal();

  @Nullable
  MiniZincInclude getInclude();

  @Nullable
  MiniZincOutput getOutput();

  @Nullable
  MiniZincPredicate getPredicate();

}
