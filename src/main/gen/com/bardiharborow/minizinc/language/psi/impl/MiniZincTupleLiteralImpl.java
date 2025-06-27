// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.bardiharborow.minizinc.language.psi.MiniZincTypes.*;
import com.bardiharborow.minizinc.language.psi.*;

public class MiniZincTupleLiteralImpl extends MiniZincExpressionImpl implements MiniZincTupleLiteral {

  public MiniZincTupleLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitTupleLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniZincVisitor) accept((MiniZincVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MiniZincExprList getExprList() {
    return findChildByClass(MiniZincExprList.class);
  }

  @Override
  @NotNull
  public MiniZincExpression getExpression() {
    return findNotNullChildByClass(MiniZincExpression.class);
  }

}
