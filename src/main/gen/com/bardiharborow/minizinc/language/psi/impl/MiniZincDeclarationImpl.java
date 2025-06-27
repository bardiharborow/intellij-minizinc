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

public class MiniZincDeclarationImpl extends MiniZincDeclarationElementImpl implements MiniZincDeclaration {

  public MiniZincDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniZincVisitor visitor) {
    visitor.visitDeclaration(this);
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
  public MiniZincExpression getExpression() {
    return findChildByClass(MiniZincExpression.class);
  }

  @Override
  @NotNull
  public List<MiniZincIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MiniZincIdentifier.class);
  }

  @Override
  @Nullable
  public MiniZincType getType() {
    return findChildByClass(MiniZincType.class);
  }

}
