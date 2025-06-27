// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MiniZincAtomSetExpression extends MiniZincSetExpression {

  @Nullable
  MiniZincAccessTail getAccessTail();

  @Nullable
  MiniZincExpression getExpression();

  @Nullable
  MiniZincIdentifier getIdentifier();

  @Nullable
  MiniZincSetComprehension getSetComprehension();

  @Nullable
  MiniZincSimpleArrayComprehension getSimpleArrayComprehension();

}
