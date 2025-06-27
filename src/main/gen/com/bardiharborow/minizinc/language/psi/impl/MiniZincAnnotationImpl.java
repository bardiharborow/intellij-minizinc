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

public class MiniZincAnnotationImpl extends ASTWrapperPsiElement implements MiniZincAnnotation {

  public MiniZincAnnotationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitAnnotation(this);
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
  @NotNull
  public MiniZincIdentifier getIdentifier() {
    return findNotNullChildByClass(MiniZincIdentifier.class);
  }

  @Override
  @NotNull
  public MiniZincParameters getParameters() {
    return findNotNullChildByClass(MiniZincParameters.class);
  }

}
