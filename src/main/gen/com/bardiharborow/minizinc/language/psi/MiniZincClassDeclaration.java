// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincClassDeclaration extends PsiElement {

  @Nullable
  MiniZincAnnotations getAnnotations();

  @Nullable
  MiniZincClassExtendsClause getClassExtendsClause();

  @NotNull
  List<MiniZincConstraint> getConstraintList();

  @Nullable
  MiniZincIdentifier getIdentifier();

  @NotNull
  List<MiniZincParameter> getParameterList();

}
