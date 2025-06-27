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

public class MiniZincClassDeclarationImpl extends MiniZincClassElementImpl implements MiniZincClassDeclaration {

  public MiniZincClassDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitClassDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniZincVisitor) accept((MiniZincVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MiniZincAnnotations getAnnotations() {
    return findChildByClass(MiniZincAnnotations.class);
  }

  @Override
  @Nullable
  public MiniZincClassExtendsClause getClassExtendsClause() {
    return findChildByClass(MiniZincClassExtendsClause.class);
  }

  @Override
  @NotNull
  public List<MiniZincConstraint> getConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MiniZincConstraint.class);
  }

  @Override
  @Nullable
  public MiniZincIdentifier getIdentifier() {
    return findChildByClass(MiniZincIdentifier.class);
  }

  @Override
  @NotNull
  public List<MiniZincParameter> getParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MiniZincParameter.class);
  }

}
