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

public class MiniZincStatementImpl extends MiniZincStatementElementImpl implements MiniZincStatement {

  public MiniZincStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniZincVisitor) accept((MiniZincVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MiniZincAnnotation getAnnotation() {
    return findChildByClass(MiniZincAnnotation.class);
  }

  @Override
  @Nullable
  public MiniZincAssignment getAssignment() {
    return findChildByClass(MiniZincAssignment.class);
  }

  @Override
  @Nullable
  public MiniZincClassDeclaration getClassDeclaration() {
    return findChildByClass(MiniZincClassDeclaration.class);
  }

  @Override
  @Nullable
  public MiniZincConstraint getConstraint() {
    return findChildByClass(MiniZincConstraint.class);
  }

  @Override
  @Nullable
  public MiniZincDeclaration getDeclaration() {
    return findChildByClass(MiniZincDeclaration.class);
  }

  @Override
  @Nullable
  public MiniZincFunction getFunction() {
    return findChildByClass(MiniZincFunction.class);
  }

  @Override
  @Nullable
  public MiniZincGoal getGoal() {
    return findChildByClass(MiniZincGoal.class);
  }

  @Override
  @Nullable
  public MiniZincInclude getInclude() {
    return findChildByClass(MiniZincInclude.class);
  }

  @Override
  @Nullable
  public MiniZincOutput getOutput() {
    return findChildByClass(MiniZincOutput.class);
  }

  @Override
  @Nullable
  public MiniZincPredicate getPredicate() {
    return findChildByClass(MiniZincPredicate.class);
  }

}
