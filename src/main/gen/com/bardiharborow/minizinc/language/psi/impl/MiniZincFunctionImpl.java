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

public class MiniZincFunctionImpl extends ASTWrapperPsiElement implements MiniZincFunction {

  public MiniZincFunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitFunction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniZincVisitor) accept((MiniZincVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MiniZincAnnotationParameter getAnnotationParameter() {
    return findNotNullChildByClass(MiniZincAnnotationParameter.class);
  }

  @Override
  @Nullable
  public MiniZincAnnotations getAnnotations() {
    return findChildByClass(MiniZincAnnotations.class);
  }

  @Override
  @Nullable
  public MiniZincIdOrQuotedOp getIdOrQuotedOp() {
    return findChildByClass(MiniZincIdOrQuotedOp.class);
  }

  @Override
  @Nullable
  public MiniZincIdentifier getIdentifier() {
    return findChildByClass(MiniZincIdentifier.class);
  }

  @Override
  @NotNull
  public MiniZincOperationItemTail getOperationItemTail() {
    return findNotNullChildByClass(MiniZincOperationItemTail.class);
  }

  @Override
  @NotNull
  public MiniZincParameters getParameters() {
    return findNotNullChildByClass(MiniZincParameters.class);
  }

  @Override
  @NotNull
  public MiniZincType getType() {
    return findNotNullChildByClass(MiniZincType.class);
  }

}
