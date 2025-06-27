// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.bardiharborow.minizinc.language.psi.MiniZincTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.bardiharborow.minizinc.language.psi.*;

public class MiniZincBaseTypeTailImpl extends ASTWrapperPsiElement implements MiniZincBaseTypeTail {

  public MiniZincBaseTypeTailImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitBaseTypeTail(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniZincVisitor) accept((MiniZincVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MiniZincExpression getExpression() {
    return findChildByClass(MiniZincExpression.class);
  }

  @Override
  @Nullable
  public MiniZincIdentifier getIdentifier() {
    return findChildByClass(MiniZincIdentifier.class);
  }

  @Override
  @Nullable
  public MiniZincTypeAndIdentifierList getTypeAndIdentifierList() {
    return findChildByClass(MiniZincTypeAndIdentifierList.class);
  }

  @Override
  @Nullable
  public MiniZincTypeList getTypeList() {
    return findChildByClass(MiniZincTypeList.class);
  }

}
