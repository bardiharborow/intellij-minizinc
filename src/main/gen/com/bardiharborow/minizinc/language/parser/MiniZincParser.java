// This is a generated file. Not intended for manual editing.
package com.bardiharborow.minizinc.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.bardiharborow.minizinc.language.psi.MiniZincTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MiniZincParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return model(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BNF_ANNOTATION_EXPRESSION, BNF_ARRAY_ACCESS_EXPRESSION, BNF_ATOM_EXPRESSION, BNF_ATOM_SET_EXPRESSION,
      BNF_BOOL_LITERAL, BNF_CALL_EXPRESSION, BNF_COMP_OR_EXPRESSION, BNF_EXPRESSION,
      BNF_IF_THEN_ELSE_EXPRESSION, BNF_INFIX_EXPRESSION, BNF_INFIX_SET_EXPRESSION, BNF_INTEGER_LITERAL,
      BNF_LET_EXPRESSION, BNF_POSTFIX_EXPRESSION, BNF_POSTFIX_SET_EXPRESSION, BNF_PREFIX_EXPRESSION,
      BNF_PREFIX_SET_EXPRESSION, BNF_RECORD_LITERAL, BNF_SET_EXPRESSION, BNF_SET_LITERAL,
      BNF_SIMPLE_ARRAY_LITERAL, BNF_SIMPLE_ARRAY_LITERAL_2_D, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_HEAD,
      BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_ROW, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_ROW_HEAD, BNF_SIMPLE_ARRAY_LITERAL_2_D_LIST, BNF_SIMPLE_ARRAY_LITERAL_3_D_LIST,
      BNF_STRING_EXPRESSION, BNF_TUPLE_LITERAL),
  };

  /* ********************************************************** */
  // field_access
  public static boolean access_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "access_tail")) return false;
    if (!nextTokenIs(b, BNF_PERIOD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_access(b, l + 1);
    exit_section_(b, m, BNF_ACCESS_TAIL, r);
    return r;
  }

  /* ********************************************************** */
  // "annotation" identifier parameters ("=" expression)?
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_ANNOTATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_ANNOTATION);
    r = r && identifier(b, l + 1);
    r = r && parameters(b, l + 1);
    r = r && annotation_3(b, l + 1);
    exit_section_(b, m, BNF_ANNOTATION, r);
    return r;
  }

  // ("=" expression)?
  private static boolean annotation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_3")) return false;
    annotation_3_0(b, l + 1);
    return true;
  }

  // "=" expression
  private static boolean annotation_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom_expression | "output" | string_expression
  public static boolean annotation_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_ANNOTATION_EXPRESSION, "<annotation expression>");
    r = atom_expression(b, l + 1);
    if (!r) r = consumeTokenFast(b, BNF_KEYWORD_OUTPUT);
    if (!r) r = string_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ("ann" ':' identifier)?
  public static boolean annotation_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_parameter")) return false;
    Marker m = enter_section_(b, l, _NONE_, BNF_ANNOTATION_PARAMETER, "<annotation parameter>");
    annotation_parameter_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // "ann" ':' identifier
  private static boolean annotation_parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_ANN, BNF_COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ("::" annotation_expression)+
  public static boolean annotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations")) return false;
    if (!nextTokenIs(b, BNF_OPERATOR_COLONCOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotations_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!annotations_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotations", c)) break;
    }
    exit_section_(b, m, BNF_ANNOTATIONS, r);
    return r;
  }

  // "::" annotation_expression
  private static boolean annotations_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_OPERATOR_COLONCOLON);
    r = r && annotation_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (array_access_expression ',')* array_access_expression ','?
  public static boolean array_access_expr_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_expr_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_ARRAY_ACCESS_EXPR_LIST, "<array access expr list>");
    r = array_access_expr_list_0(b, l + 1);
    r = r && array_access_expression(b, l + 1);
    r = r && array_access_expr_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (array_access_expression ',')*
  private static boolean array_access_expr_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_expr_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_access_expr_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_access_expr_list_0", c)) break;
    }
    return true;
  }

  // array_access_expression ','
  private static boolean array_access_expr_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_expr_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_access_expression(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean array_access_expr_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_expr_list_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // expression | ".." | "..<" | "<.." | "<..<"
  public static boolean array_access_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_ARRAY_ACCESS_EXPRESSION, "<array access expression>");
    r = expression(b, l + 1, -1);
    if (!r) r = consumeTokenFast(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenFast(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenFast(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenFast(b, BNF_OPERATOR_LE_DOTDOT_LE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier "=" expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, BNF_TOKEN_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, BNF_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ("par" | "var")? ("opt")? ("set" "of")? base_type_tail | "any" type_inst_identifier | "any"
  public static boolean base_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_BASE_TYPE, "<base type>");
    r = base_type_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, BNF_KEYWORD_ANY, BNF_TYPE_INST_IDENTIFIER);
    if (!r) r = consumeToken(b, BNF_KEYWORD_ANY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("par" | "var")? ("opt")? ("set" "of")? base_type_tail
  private static boolean base_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base_type_0_0(b, l + 1);
    r = r && base_type_0_1(b, l + 1);
    r = r && base_type_0_2(b, l + 1);
    r = r && base_type_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("par" | "var")?
  private static boolean base_type_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0_0")) return false;
    base_type_0_0_0(b, l + 1);
    return true;
  }

  // "par" | "var"
  private static boolean base_type_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0_0_0")) return false;
    boolean r;
    r = consumeToken(b, BNF_KEYWORD_PAR);
    if (!r) r = consumeToken(b, BNF_KEYWORD_VAR);
    return r;
  }

  // ("opt")?
  private static boolean base_type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0_1")) return false;
    consumeToken(b, BNF_KEYWORD_OPT);
    return true;
  }

  // ("set" "of")?
  private static boolean base_type_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0_2")) return false;
    base_type_0_2_0(b, l + 1);
    return true;
  }

  // "set" "of"
  private static boolean base_type_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_SET, BNF_KEYWORD_OF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "int" | "bool" | "float" | "string" | "ann" | "tuple" '(' type_list ')' | "record" '(' type_and_identifier_list ')' | identifier | 'new' identifier | set_expression
  public static boolean base_type_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_tail")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_BASE_TYPE_TAIL, "<base type tail>");
    r = consumeToken(b, BNF_KEYWORD_INT);
    if (!r) r = consumeToken(b, BNF_KEYWORD_BOOL);
    if (!r) r = consumeToken(b, BNF_KEYWORD_FLOAT);
    if (!r) r = consumeToken(b, BNF_KEYWORD_STRING);
    if (!r) r = consumeToken(b, BNF_KEYWORD_ANN);
    if (!r) r = base_type_tail_5(b, l + 1);
    if (!r) r = base_type_tail_6(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = base_type_tail_8(b, l + 1);
    if (!r) r = set_expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "tuple" '(' type_list ')'
  private static boolean base_type_tail_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_tail_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_TUPLE, BNF_PARENTHESIS_LEFT);
    r = r && type_list(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // "record" '(' type_and_identifier_list ')'
  private static boolean base_type_tail_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_tail_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_RECORD, BNF_PARENTHESIS_LEFT);
    r = r && type_and_identifier_list(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'new' identifier
  private static boolean base_type_tail_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_tail_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_NEW);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  public static boolean bool_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_BOOL_LITERAL, "<bool literal>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // p_call_expression | quoted_op_call
  public static boolean call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_CALL_EXPRESSION, "<call expression>");
    r = p_call_expression(b, l + 1);
    if (!r) r = quoted_op_call(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "class" identifier class_extends_clause? class_parameters annotations?
  public static boolean class_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_CLASS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BNF_CLASS_DECLARATION, null);
    r = consumeToken(b, BNF_KEYWORD_CLASS);
    p = r; // pin = 1
    r = r && report_error_(b, identifier(b, l + 1));
    r = p && report_error_(b, class_declaration_2(b, l + 1)) && r;
    r = p && report_error_(b, class_parameters(b, l + 1)) && r;
    r = p && class_declaration_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // class_extends_clause?
  private static boolean class_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_2")) return false;
    class_extends_clause(b, l + 1);
    return true;
  }

  // annotations?
  private static boolean class_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_4")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "extends" identifier
  public static boolean class_extends_clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_extends_clause")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_EXTENDS);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, BNF_CLASS_EXTENDS_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // '(' ((parameter | constraint) ';')* ((parameter | constraint) ';'?)? ')'
  static boolean class_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters")) return false;
    if (!nextTokenIs(b, BNF_PARENTHESIS_LEFT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, BNF_PARENTHESIS_LEFT);
    p = r; // pin = 1
    r = r && report_error_(b, class_parameters_1(b, l + 1));
    r = p && report_error_(b, class_parameters_2(b, l + 1)) && r;
    r = p && consumeToken(b, BNF_PARENTHESIS_RIGHT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((parameter | constraint) ';')*
  private static boolean class_parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_parameters_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_parameters_1", c)) break;
    }
    return true;
  }

  // (parameter | constraint) ';'
  private static boolean class_parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_parameters_1_0_0(b, l + 1);
    r = r && consumeToken(b, BNF_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter | constraint
  private static boolean class_parameters_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_1_0_0")) return false;
    boolean r;
    r = parameter(b, l + 1);
    if (!r) r = constraint(b, l + 1);
    return r;
  }

  // ((parameter | constraint) ';'?)?
  private static boolean class_parameters_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_2")) return false;
    class_parameters_2_0(b, l + 1);
    return true;
  }

  // (parameter | constraint) ';'?
  private static boolean class_parameters_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_parameters_2_0_0(b, l + 1);
    r = r && class_parameters_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter | constraint
  private static boolean class_parameters_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_2_0_0")) return false;
    boolean r;
    r = parameter(b, l + 1);
    if (!r) r = constraint(b, l + 1);
    return r;
  }

  // ';'?
  private static boolean class_parameters_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_parameters_2_0_1")) return false;
    consumeToken(b, BNF_SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // ',' | ';'
  public static boolean comma_or_semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comma_or_semi")) return false;
    if (!nextTokenIs(b, "<comma or semi>", BNF_COMMA, BNF_SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_COMMA_OR_SEMI, "<comma or semi>");
    r = consumeToken(b, BNF_COMMA);
    if (!r) r = consumeToken(b, BNF_SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comp_expr_list_head ','?
  public static boolean comp_expr_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_COMP_EXPR_LIST, "<comp expr list>");
    r = comp_expr_list_head(b, l + 1);
    r = r && comp_expr_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ','?
  private static boolean comp_expr_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_1")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // (expression (':' expression)? ',')* expression (':' expression)? ','
  public static boolean comp_expr_list_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_COMP_EXPR_LIST_HEAD, "<comp expr list head>");
    r = comp_expr_list_head_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    r = r && comp_expr_list_head_2(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (expression (':' expression)? ',')*
  private static boolean comp_expr_list_head_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comp_expr_list_head_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comp_expr_list_head_0", c)) break;
    }
    return true;
  }

  // expression (':' expression)? ','
  private static boolean comp_expr_list_head_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && comp_expr_list_head_0_0_1(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' expression)?
  private static boolean comp_expr_list_head_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_0_0_1")) return false;
    comp_expr_list_head_0_0_1_0(b, l + 1);
    return true;
  }

  // ':' expression
  private static boolean comp_expr_list_head_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' expression)?
  private static boolean comp_expr_list_head_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_2")) return false;
    comp_expr_list_head_2_0(b, l + 1);
    return true;
  }

  // ':' expression
  private static boolean comp_expr_list_head_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_expr_list_head_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (expression ("where" expression)? ',')* expression ("where" expression)? ','?
  public static boolean comp_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_COMP_OR_EXPRESSION, "<comp or expression>");
    r = comp_or_expression_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    r = r && comp_or_expression_2(b, l + 1);
    r = r && comp_or_expression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (expression ("where" expression)? ',')*
  private static boolean comp_or_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comp_or_expression_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comp_or_expression_0", c)) break;
    }
    return true;
  }

  // expression ("where" expression)? ','
  private static boolean comp_or_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && comp_or_expression_0_0_1(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("where" expression)?
  private static boolean comp_or_expression_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_0_0_1")) return false;
    comp_or_expression_0_0_1_0(b, l + 1);
    return true;
  }

  // "where" expression
  private static boolean comp_or_expression_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BNF_KEYWORD_WHERE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("where" expression)?
  private static boolean comp_or_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_2")) return false;
    comp_or_expression_2_0(b, l + 1);
    return true;
  }

  // "where" expression
  private static boolean comp_or_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BNF_KEYWORD_WHERE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean comp_or_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_or_expression_3")) return false;
    consumeTokenFast(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // generator_list
  public static boolean comp_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comp_tail")) return false;
    if (!nextTokenIs(b, "<comp tail>", BNF_TOKEN_IDENTIFIER, BNF_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_COMP_TAIL, "<comp tail>");
    r = generator_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "constraint" expression annotations?
  public static boolean constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_CONSTRAINT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_CONSTRAINT);
    r = r && expression(b, l + 1, -1);
    r = r && constraint_2(b, l + 1);
    exit_section_(b, m, BNF_CONSTRAINT, r);
    return r;
  }

  // annotations?
  private static boolean constraint_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_2")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // type ':' identifier annotations? ("=" expression)? | "enum" identifier annotations? ("=" (enum_init | "[" string_lit_list "]"))? | "type" identifier annotations? "=" type
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_DECLARATION, "<declaration>");
    r = declaration_0(b, l + 1);
    if (!r) r = declaration_1(b, l + 1);
    if (!r) r = declaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type ':' identifier annotations? ("=" expression)?
  private static boolean declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    r = r && identifier(b, l + 1);
    r = r && declaration_0_3(b, l + 1);
    r = r && declaration_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean declaration_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0_3")) return false;
    annotations(b, l + 1);
    return true;
  }

  // ("=" expression)?
  private static boolean declaration_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0_4")) return false;
    declaration_0_4_0(b, l + 1);
    return true;
  }

  // "=" expression
  private static boolean declaration_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "enum" identifier annotations? ("=" (enum_init | "[" string_lit_list "]"))?
  private static boolean declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_ENUM);
    r = r && identifier(b, l + 1);
    r = r && declaration_1_2(b, l + 1);
    r = r && declaration_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean declaration_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1_2")) return false;
    annotations(b, l + 1);
    return true;
  }

  // ("=" (enum_init | "[" string_lit_list "]"))?
  private static boolean declaration_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1_3")) return false;
    declaration_1_3_0(b, l + 1);
    return true;
  }

  // "=" (enum_init | "[" string_lit_list "]")
  private static boolean declaration_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_EQUALS);
    r = r && declaration_1_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // enum_init | "[" string_lit_list "]"
  private static boolean declaration_1_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_init(b, l + 1);
    if (!r) r = declaration_1_3_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "[" string_lit_list "]"
  private static boolean declaration_1_3_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_1_3_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACKET_LEFT);
    r = r && string_lit_list(b, l + 1);
    r = r && consumeToken(b, BNF_BRACKET_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // "type" identifier annotations? "=" type
  private static boolean declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_TYPE);
    r = r && identifier(b, l + 1);
    r = r && declaration_2_2(b, l + 1);
    r = r && consumeToken(b, BNF_EQUALS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean declaration_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2_2")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ("elseif" expression "then" expression)*
  public static boolean elseif_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, BNF_ELSEIF_LIST, "<elseif list>");
    while (true) {
      int c = current_position_(b);
      if (!elseif_list_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseif_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // "elseif" expression "then" expression
  private static boolean elseif_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_ELSEIF);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_KEYWORD_THEN);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' enum_id_list ','? '}' | identifier '(' expression ')' | "_" '(' expression ')'
  static boolean enum_construct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_construct")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_construct_0(b, l + 1);
    if (!r) r = enum_construct_1(b, l + 1);
    if (!r) r = enum_construct_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' enum_id_list ','? '}'
  private static boolean enum_construct_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_construct_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACE_LEFT);
    r = r && enum_id_list(b, l + 1);
    r = r && enum_construct_0_2(b, l + 1);
    r = r && consumeToken(b, BNF_BRACE_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean enum_construct_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_construct_0_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  // identifier '(' expression ')'
  private static boolean enum_construct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_construct_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" '(' expression ')'
  private static boolean enum_construct_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_construct_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_UNDERSCORE, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((identifier ',')* identifier)?
  static boolean enum_id_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_id_list")) return false;
    enum_id_list_0(b, l + 1);
    return true;
  }

  // (identifier ',')* identifier
  private static boolean enum_id_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_id_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_id_list_0_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier ',')*
  private static boolean enum_id_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_id_list_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_id_list_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_id_list_0_0", c)) break;
    }
    return true;
  }

  // identifier ','
  private static boolean enum_id_list_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_id_list_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (enum_construct "++")* enum_construct
  static boolean enum_init(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_init")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_init_0(b, l + 1);
    r = r && enum_construct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (enum_construct "++")*
  private static boolean enum_init_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_init_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_init_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_init_0", c)) break;
    }
    return true;
  }

  // enum_construct "++"
  private static boolean enum_init_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_init_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_construct(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_PLUSPLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (expression ',')* expression ','?
  public static boolean expr_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_EXPR_LIST, "<expr list>");
    r = expr_list_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    r = r && expr_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (expression ',')*
  private static boolean expr_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_list_0", c)) break;
    }
    return true;
  }

  // expression ','
  private static boolean expr_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean expr_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // "." (identifier | integer_literal)
  public static boolean field_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_access")) return false;
    if (!nextTokenIs(b, BNF_PERIOD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BNF_FIELD_ACCESS, null);
    r = consumeToken(b, BNF_PERIOD);
    p = r; // pin = 1
    r = r && field_access_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identifier | integer_literal
  private static boolean field_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_access_1")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = integer_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ("function" type ':' id_or_quoted_op | type ':' identifier) parameters annotation_parameter annotations? operation_item_tail
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_FUNCTION, "<function>");
    r = function_0(b, l + 1);
    r = r && parameters(b, l + 1);
    r = r && annotation_parameter(b, l + 1);
    r = r && function_3(b, l + 1);
    r = r && operation_item_tail(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "function" type ':' id_or_quoted_op | type ':' identifier
  private static boolean function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_0_0(b, l + 1);
    if (!r) r = function_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "function" type ':' id_or_quoted_op
  private static boolean function_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_FUNCTION);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    r = r && id_or_quoted_op(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type ':' identifier
  private static boolean function_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean function_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_3")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id_list "in" expression ("where" expression)?
  public static boolean generator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator")) return false;
    if (!nextTokenIs(b, "<generator>", BNF_TOKEN_IDENTIFIER, BNF_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_GENERATOR, "<generator>");
    r = id_list(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_IN);
    r = r && expression(b, l + 1, -1);
    r = r && generator_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("where" expression)?
  private static boolean generator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_3")) return false;
    generator_3_0(b, l + 1);
    return true;
  }

  // "where" expression
  private static boolean generator_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_WHERE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier "=" expression
  public static boolean generator_equation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_equation")) return false;
    if (!nextTokenIs(b, BNF_TOKEN_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, BNF_GENERATOR_EQUATION, r);
    return r;
  }

  /* ********************************************************** */
  // (generator | generator_equation ("where" expression)? ',')* (generator | generator_equation ("where" expression)?) ','?
  public static boolean generator_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list")) return false;
    if (!nextTokenIs(b, "<generator list>", BNF_TOKEN_IDENTIFIER, BNF_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_GENERATOR_LIST, "<generator list>");
    r = generator_list_0(b, l + 1);
    r = r && generator_list_1(b, l + 1);
    r = r && generator_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (generator | generator_equation ("where" expression)? ',')*
  private static boolean generator_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!generator_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "generator_list_0", c)) break;
    }
    return true;
  }

  // generator | generator_equation ("where" expression)? ','
  private static boolean generator_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generator(b, l + 1);
    if (!r) r = generator_list_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // generator_equation ("where" expression)? ','
  private static boolean generator_list_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generator_equation(b, l + 1);
    r = r && generator_list_0_0_1_1(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("where" expression)?
  private static boolean generator_list_0_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_0_0_1_1")) return false;
    generator_list_0_0_1_1_0(b, l + 1);
    return true;
  }

  // "where" expression
  private static boolean generator_list_0_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_0_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_WHERE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // generator | generator_equation ("where" expression)?
  private static boolean generator_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generator(b, l + 1);
    if (!r) r = generator_list_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // generator_equation ("where" expression)?
  private static boolean generator_list_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generator_equation(b, l + 1);
    r = r && generator_list_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("where" expression)?
  private static boolean generator_list_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_1_1_1")) return false;
    generator_list_1_1_1_0(b, l + 1);
    return true;
  }

  // "where" expression
  private static boolean generator_list_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_WHERE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean generator_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_list_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // "solve" annotations? ("satisfy" | ("minimize" | "maximize") expression)
  public static boolean goal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "goal")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_SOLVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_SOLVE);
    r = r && goal_1(b, l + 1);
    r = r && goal_2(b, l + 1);
    exit_section_(b, m, BNF_GOAL, r);
    return r;
  }

  // annotations?
  private static boolean goal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "goal_1")) return false;
    annotations(b, l + 1);
    return true;
  }

  // "satisfy" | ("minimize" | "maximize") expression
  private static boolean goal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "goal_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_SATISFY);
    if (!r) r = goal_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("minimize" | "maximize") expression
  private static boolean goal_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "goal_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = goal_2_1_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "minimize" | "maximize"
  private static boolean goal_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "goal_2_1_0")) return false;
    boolean r;
    r = consumeToken(b, BNF_KEYWORD_MINIMIZE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_MAXIMIZE);
    return r;
  }

  /* ********************************************************** */
  // ((identifier | "_") ',')* (identifier | "_") ','?
  public static boolean id_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list")) return false;
    if (!nextTokenIs(b, "<id list>", BNF_TOKEN_IDENTIFIER, BNF_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_ID_LIST, "<id list>");
    r = id_list_0(b, l + 1);
    r = r && id_list_1(b, l + 1);
    r = r && id_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((identifier | "_") ',')*
  private static boolean id_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!id_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_list_0", c)) break;
    }
    return true;
  }

  // (identifier | "_") ','
  private static boolean id_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_list_0_0_0(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier | "_"
  private static boolean id_list_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_0_0_0")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = consumeToken(b, BNF_UNDERSCORE);
    return r;
  }

  // identifier | "_"
  private static boolean id_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_1")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (!r) r = consumeToken(b, BNF_UNDERSCORE);
    return r;
  }

  // ','?
  private static boolean id_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // identifier ("^-1")? | "'<->'" | "'->'"| "'<-'" | "'\\/'" | "'xor'" | "'/\\'" | "'<'" | "'>'" | "'<='" | "'>='" | "'='" | "'!='" | "'in'" | "'subset'" | "'superset'" | "'union'" | "'diff'" | "'symdiff'" | "'..'" | "'<..'" | "'..<'" | "'<..<'" | "'+'" | "'-'" | "'*'" | "'^'" | "'/'" | "'div'" | "'mod'" | "'intersect'" | "'not'" | "'++'"
  public static boolean id_or_quoted_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_or_quoted_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_ID_OR_QUOTED_OP, "<id or quoted op>");
    r = id_or_quoted_op_0(b, l + 1);
    if (!r) r = consumeToken(b, BNF_OPERATOR_EQUIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IMPL_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_RIMPL_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_OR_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_XOR_QUOTED);
    if (!r) r = consumeToken(b, "'/\\'");
    if (!r) r = consumeToken(b, BNF_OPERATOR_LE_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_GR_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_LQ_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_GQ_QUOTED);
    if (!r) r = consumeToken(b, "'='");
    if (!r) r = consumeToken(b, BNF_OPERATOR_NQ_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IN_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SUBSET_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SUPERSET_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_UNION_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DIFF_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SYMDIFF_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DOTDOT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_LE_DOTDOT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DOTDOT_LE_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_LE_DOTDOT_LE_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_PLUS_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MINUS_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MULT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_POW_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IDIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MOD_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_INTERSECT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_NOT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_PLUSPLUS_QUOTED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier ("^-1")?
  private static boolean id_or_quoted_op_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_or_quoted_op_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && id_or_quoted_op_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("^-1")?
  private static boolean id_or_quoted_op_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_or_quoted_op_0_1")) return false;
    consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    return true;
  }

  /* ********************************************************** */
  // TOKEN_IDENTIFIER
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, BNF_TOKEN_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_TOKEN_IDENTIFIER);
    exit_section_(b, m, BNF_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // "if" expression "then" expression (elseif_list "else" expression)? "endif"
  public static boolean if_then_else_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_then_else_expression")) return false;
    if (!nextTokenIsFast(b, BNF_KEYWORD_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BNF_KEYWORD_IF);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_KEYWORD_THEN);
    r = r && expression(b, l + 1, -1);
    r = r && if_then_else_expression_4(b, l + 1);
    r = r && consumeToken(b, BNF_KEYWORD_ENDIF);
    exit_section_(b, m, BNF_IF_THEN_ELSE_EXPRESSION, r);
    return r;
  }

  // (elseif_list "else" expression)?
  private static boolean if_then_else_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_then_else_expression_4")) return false;
    if_then_else_expression_4_0(b, l + 1);
    return true;
  }

  // elseif_list "else" expression
  private static boolean if_then_else_expression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_then_else_expression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseif_list(b, l + 1);
    r = r && consumeToken(b, BNF_KEYWORD_ELSE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "include" STRING_LITERAL
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BNF_INCLUDE, null);
    r = consumeTokens(b, 1, BNF_KEYWORD_INCLUDE, BNF_STRING_LITERAL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TOKEN_INTEGER
  public static boolean integer_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_literal")) return false;
    if (!nextTokenIs(b, BNF_TOKEN_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_TOKEN_INTEGER);
    exit_section_(b, m, BNF_INTEGER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // type_and_identifier ("=" expression)?
  public static boolean let_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_LET_DECLARATION, "<let declaration>");
    r = type_and_identifier(b, l + 1);
    r = r && let_declaration_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("=" expression)?
  private static boolean let_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_1")) return false;
    let_declaration_1_0(b, l + 1);
    return true;
  }

  // "=" expression
  private static boolean let_declaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((let_declaration | constraint) comma_or_semi)* (let_declaration | constraint) comma_or_semi?
  public static boolean let_declaration_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_LET_DECLARATION_LIST, "<let declaration list>");
    r = let_declaration_list_0(b, l + 1);
    r = r && let_declaration_list_1(b, l + 1);
    r = r && let_declaration_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((let_declaration | constraint) comma_or_semi)*
  private static boolean let_declaration_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!let_declaration_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_declaration_list_0", c)) break;
    }
    return true;
  }

  // (let_declaration | constraint) comma_or_semi
  private static boolean let_declaration_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_declaration_list_0_0_0(b, l + 1);
    r = r && comma_or_semi(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // let_declaration | constraint
  private static boolean let_declaration_list_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list_0_0_0")) return false;
    boolean r;
    r = let_declaration(b, l + 1);
    if (!r) r = constraint(b, l + 1);
    return r;
  }

  // let_declaration | constraint
  private static boolean let_declaration_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list_1")) return false;
    boolean r;
    r = let_declaration(b, l + 1);
    if (!r) r = constraint(b, l + 1);
    return r;
  }

  // comma_or_semi?
  private static boolean let_declaration_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_declaration_list_2")) return false;
    comma_or_semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "let" '{' (let_declaration_list | let_declaration_list comma_or_semi)? '}' "in" expression
  public static boolean let_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expression")) return false;
    if (!nextTokenIsFast(b, BNF_KEYWORD_LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_LET, BNF_BRACE_LEFT);
    r = r && let_expression_2(b, l + 1);
    r = r && consumeTokens(b, 0, BNF_BRACE_RIGHT, BNF_OPERATOR_IN);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, BNF_LET_EXPRESSION, r);
    return r;
  }

  // (let_declaration_list | let_declaration_list comma_or_semi)?
  private static boolean let_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expression_2")) return false;
    let_expression_2_0(b, l + 1);
    return true;
  }

  // let_declaration_list | let_declaration_list comma_or_semi
  private static boolean let_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_declaration_list(b, l + 1);
    if (!r) r = let_expression_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // let_declaration_list comma_or_semi
  private static boolean let_expression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expression_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_declaration_list(b, l + 1);
    r = r && comma_or_semi(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement+
  static boolean model(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ("=" expression)?
  public static boolean operation_item_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_item_tail")) return false;
    Marker m = enter_section_(b, l, _NONE_, BNF_OPERATION_ITEM_TAIL, "<operation item tail>");
    operation_item_tail_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // "=" expression
  private static boolean operation_item_tail_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_item_tail_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_EQUALS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "output" ("::" output_annotation)? expression
  public static boolean output(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output")) return false;
    if (!nextTokenIs(b, BNF_KEYWORD_OUTPUT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_KEYWORD_OUTPUT);
    r = r && output_1(b, l + 1);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, BNF_OUTPUT, r);
    return r;
  }

  // ("::" output_annotation)?
  private static boolean output_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_1")) return false;
    output_1_0(b, l + 1);
    return true;
  }

  // "::" output_annotation
  private static boolean output_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_OPERATOR_COLONCOLON);
    r = r && output_annotation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string_expression | identifier '(' ')' | identifier '(' expr_list ')' | '(' expression ')'
  public static boolean output_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_annotation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_OUTPUT_ANNOTATION, "<output annotation>");
    r = string_expression(b, l + 1);
    if (!r) r = output_annotation_1(b, l + 1);
    if (!r) r = output_annotation_2(b, l + 1);
    if (!r) r = output_annotation_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier '(' ')'
  private static boolean output_annotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_annotation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeTokens(b, 0, BNF_PARENTHESIS_LEFT, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier '(' expr_list ')'
  private static boolean output_annotation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_annotation_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && expr_list(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')'
  private static boolean output_annotation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_annotation_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier "^-1"? '(' comp_or_expression? ')' ('(' expression ')')?
  static boolean p_call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "p_call_expression")) return false;
    if (!nextTokenIsFast(b, BNF_TOKEN_IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = identifier(b, l + 1);
    r = r && p_call_expression_1(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_LEFT);
    p = r; // pin = 3
    r = r && report_error_(b, p_call_expression_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, BNF_PARENTHESIS_RIGHT)) && r;
    r = p && p_call_expression_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // "^-1"?
  private static boolean p_call_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "p_call_expression_1")) return false;
    consumeTokenFast(b, BNF_OPERATOR_POW_MINUS1);
    return true;
  }

  // comp_or_expression?
  private static boolean p_call_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "p_call_expression_3")) return false;
    comp_or_expression(b, l + 1);
    return true;
  }

  // ('(' expression ')')?
  private static boolean p_call_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "p_call_expression_5")) return false;
    p_call_expression_5_0(b, l + 1);
    return true;
  }

  // '(' expression ')'
  private static boolean p_call_expression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "p_call_expression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type (':' identifier annotations?)?
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BNF_PARAMETER, "<parameter>");
    r = type(b, l + 1);
    p = r; // pin = 1
    r = r && parameter_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (':' identifier annotations?)?
  private static boolean parameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1")) return false;
    parameter_1_0(b, l + 1);
    return true;
  }

  // ':' identifier annotations?
  private static boolean parameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COLON);
    r = r && identifier(b, l + 1);
    r = r && parameter_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean parameter_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1_0_2")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('(' ((parameter ',')* parameter ','?)? ')')?
  public static boolean parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters")) return false;
    Marker m = enter_section_(b, l, _NONE_, BNF_PARAMETERS, "<parameters>");
    parameters_0(b, l + 1);
    exit_section_(b, l, m, true, false, MiniZincParser::parenthesis_recover);
    return true;
  }

  // '(' ((parameter ',')* parameter ','?)? ')'
  private static boolean parameters_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && parameters_0_1(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((parameter ',')* parameter ','?)?
  private static boolean parameters_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_1")) return false;
    parameters_0_1_0(b, l + 1);
    return true;
  }

  // (parameter ',')* parameter ','?
  private static boolean parameters_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_0_1_0_0(b, l + 1);
    r = r && parameter(b, l + 1);
    r = r && parameters_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (parameter ',')*
  private static boolean parameters_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_0_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_0_1_0_0", c)) break;
    }
    return true;
  }

  // parameter ','
  private static boolean parameters_0_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean parameters_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_1_0_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // !(')')
  static boolean parenthesis_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ("predicate" | "test") identifier "^-1"? parameters annotation_parameter annotations? operation_item_tail
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    if (!nextTokenIs(b, "<predicate>", BNF_KEYWORD_PREDICATE, BNF_KEYWORD_TEST)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_PREDICATE, "<predicate>");
    r = predicate_0(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && predicate_2(b, l + 1);
    r = r && parameters(b, l + 1);
    r = r && annotation_parameter(b, l + 1);
    r = r && predicate_5(b, l + 1);
    r = r && operation_item_tail(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "predicate" | "test"
  private static boolean predicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0")) return false;
    boolean r;
    r = consumeToken(b, BNF_KEYWORD_PREDICATE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_TEST);
    return r;
  }

  // "^-1"?
  private static boolean predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_2")) return false;
    consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    return true;
  }

  // annotations?
  private static boolean predicate_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_5")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "'<->'" | "'->'" | "'<-'" | "'\\/'" | "'xor'" | "'/\\'" | "'<'" | "'>'" | "'<='" | "'>='" | "'='" | "'!='" | "'in'" | "'subset'" | "'superset'" | "'union'" | "'diff'" | "'symdiff'" | "'+'" | "'-'" | "'*'" | "'^'" | "'/'" | "'div'" | "'mod'" | "'intersect'" | "'++'" | "'not'"
  public static boolean quoted_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_QUOTED_OP, "<quoted op>");
    r = consumeToken(b, BNF_OPERATOR_EQUIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IMPL_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_RIMPL_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_OR_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_XOR_QUOTED);
    if (!r) r = consumeToken(b, "'/\\'");
    if (!r) r = consumeToken(b, BNF_OPERATOR_LE_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_GR_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_LQ_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_GQ_QUOTED);
    if (!r) r = consumeToken(b, "'='");
    if (!r) r = consumeToken(b, BNF_OPERATOR_NQ_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IN_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SUBSET_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SUPERSET_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_UNION_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DIFF_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_SYMDIFF_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_PLUS_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MINUS_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MULT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_POW_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_DIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_IDIV_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_MOD_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_INTERSECT_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_PLUSPLUS_QUOTED);
    if (!r) r = consumeToken(b, BNF_OPERATOR_NOT_QUOTED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // quoted_op '(' expression (',' expression)? ')'
  public static boolean quoted_op_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_op_call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_QUOTED_OP_CALL, "<quoted op call>");
    r = quoted_op(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && quoted_op_call_3(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' expression)?
  private static boolean quoted_op_call_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_op_call_3")) return false;
    quoted_op_call_3_0(b, l + 1);
    return true;
  }

  // ',' expression
  private static boolean quoted_op_call_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_op_call_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ':' expression
  public static boolean record_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field")) return false;
    if (!nextTokenIs(b, BNF_TOKEN_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, BNF_RECORD_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // '(' (record_field ',')* record_field ','? ')'
  public static boolean record_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_literal")) return false;
    if (!nextTokenIs(b, BNF_PARENTHESIS_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && record_literal_1(b, l + 1);
    r = r && record_field(b, l + 1);
    r = r && record_literal_3(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, BNF_RECORD_LITERAL, r);
    return r;
  }

  // (record_field ',')*
  private static boolean record_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_literal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!record_literal_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "record_literal_1", c)) break;
    }
    return true;
  }

  // record_field ','
  private static boolean record_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_field(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean record_literal_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_literal_3")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // !(';' | 'annotation' | identifier '=' | 'constraint' | type ':' | 'enum' | 'function' | 'solve' | 'include' | 'output' | 'predicate' | 'test' | 'type' | 'class')
  static boolean semicolon_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semicolon_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !semicolon_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | 'annotation' | identifier '=' | 'constraint' | type ':' | 'enum' | 'function' | 'solve' | 'include' | 'output' | 'predicate' | 'test' | 'type' | 'class'
  private static boolean semicolon_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semicolon_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_SEMICOLON);
    if (!r) r = consumeToken(b, BNF_KEYWORD_ANNOTATION);
    if (!r) r = semicolon_recover_0_2(b, l + 1);
    if (!r) r = consumeToken(b, BNF_KEYWORD_CONSTRAINT);
    if (!r) r = semicolon_recover_0_4(b, l + 1);
    if (!r) r = consumeToken(b, BNF_KEYWORD_ENUM);
    if (!r) r = consumeToken(b, BNF_KEYWORD_FUNCTION);
    if (!r) r = consumeToken(b, BNF_KEYWORD_SOLVE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_INCLUDE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_OUTPUT);
    if (!r) r = consumeToken(b, BNF_KEYWORD_PREDICATE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_TEST);
    if (!r) r = consumeToken(b, BNF_KEYWORD_TYPE);
    if (!r) r = consumeToken(b, BNF_KEYWORD_CLASS);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier '='
  private static boolean semicolon_recover_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semicolon_recover_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_EQUALS);
    exit_section_(b, m, null, r);
    return r;
  }

  // type ':'
  private static boolean semicolon_recover_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semicolon_recover_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' expression '|' comp_tail '}'
  public static boolean set_comprehension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_comprehension")) return false;
    if (!nextTokenIs(b, BNF_BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACE_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PIPE);
    r = r && comp_tail(b, l + 1);
    r = r && consumeToken(b, BNF_BRACE_RIGHT);
    exit_section_(b, m, BNF_SET_COMPREHENSION, r);
    return r;
  }

  /* ********************************************************** */
  // '{' expr_list? '}'
  public static boolean set_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_literal")) return false;
    if (!nextTokenIs(b, BNF_BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACE_LEFT);
    r = r && set_literal_1(b, l + 1);
    r = r && consumeToken(b, BNF_BRACE_RIGHT);
    exit_section_(b, m, BNF_SET_LITERAL, r);
    return r;
  }

  // expr_list?
  private static boolean set_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_literal_1")) return false;
    expr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "[" expression (':' expression)? '|' comp_tail "]"
  public static boolean simple_array_comprehension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_comprehension")) return false;
    if (!nextTokenIs(b, BNF_BRACKET_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACKET_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && simple_array_comprehension_2(b, l + 1);
    r = r && consumeToken(b, BNF_PIPE);
    r = r && comp_tail(b, l + 1);
    r = r && consumeToken(b, BNF_BRACKET_RIGHT);
    exit_section_(b, m, BNF_SIMPLE_ARRAY_COMPREHENSION, r);
    return r;
  }

  // (':' expression)?
  private static boolean simple_array_comprehension_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_comprehension_2")) return false;
    simple_array_comprehension_2_0(b, l + 1);
    return true;
  }

  // ':' expression
  private static boolean simple_array_comprehension_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_comprehension_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[" comp_expr_list? "]"
  public static boolean simple_array_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal")) return false;
    if (!nextTokenIs(b, BNF_BRACKET_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACKET_LEFT);
    r = r && simple_array_literal_1(b, l + 1);
    r = r && consumeToken(b, BNF_BRACKET_RIGHT);
    exit_section_(b, m, BNF_SIMPLE_ARRAY_LITERAL, r);
    return r;
  }

  // comp_expr_list?
  private static boolean simple_array_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_1")) return false;
    comp_expr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "[|" (simple_array_literal_2d_indexed_list | simple_array_literal_3d_list) "|]"
  public static boolean simple_array_literal_2d(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d")) return false;
    if (!nextTokenIs(b, BNF_BRACKET_LEFT_2D)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_BRACKET_LEFT_2D);
    r = r && simple_array_literal_2d_1(b, l + 1);
    r = r && consumeToken(b, BNF_BRACKET_RIGHT_2D);
    exit_section_(b, m, BNF_SIMPLE_ARRAY_LITERAL_2_D, r);
    return r;
  }

  // simple_array_literal_2d_indexed_list | simple_array_literal_3d_list
  private static boolean simple_array_literal_2d_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_1")) return false;
    boolean r;
    r = simple_array_literal_2d_indexed_list(b, l + 1);
    if (!r) r = simple_array_literal_3d_list(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // simple_array_literal_2d_indexed_list_head '|'?
  public static boolean simple_array_literal_2d_indexed_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST, "<simple array literal 2 d indexed list>");
    r = simple_array_literal_2d_indexed_list_head(b, l + 1);
    r = r && simple_array_literal_2d_indexed_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '|'?
  private static boolean simple_array_literal_2d_indexed_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_1")) return false;
    consumeToken(b, BNF_PIPE);
    return true;
  }

  /* ********************************************************** */
  // simple_array_literal_2d_indexed_list_row (':' | '|' simple_array_literal_2d_indexed_list_row)?
  public static boolean simple_array_literal_2d_indexed_list_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_head")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_HEAD, "<simple array literal 2 d indexed list head>");
    r = simple_array_literal_2d_indexed_list_row(b, l + 1);
    r = r && simple_array_literal_2d_indexed_list_head_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (':' | '|' simple_array_literal_2d_indexed_list_row)?
  private static boolean simple_array_literal_2d_indexed_list_head_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_head_1")) return false;
    simple_array_literal_2d_indexed_list_head_1_0(b, l + 1);
    return true;
  }

  // ':' | '|' simple_array_literal_2d_indexed_list_row
  private static boolean simple_array_literal_2d_indexed_list_head_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_head_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_COLON);
    if (!r) r = simple_array_literal_2d_indexed_list_head_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '|' simple_array_literal_2d_indexed_list_row
  private static boolean simple_array_literal_2d_indexed_list_head_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_head_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PIPE);
    r = r && simple_array_literal_2d_indexed_list_row(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // simple_array_literal_2d_indexed_list_row_head ','?
  public static boolean simple_array_literal_2d_indexed_list_row(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_ROW, "<simple array literal 2 d indexed list row>");
    r = simple_array_literal_2d_indexed_list_row_head(b, l + 1);
    r = r && simple_array_literal_2d_indexed_list_row_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ','?
  private static boolean simple_array_literal_2d_indexed_list_row_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row_1")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // ((':' | ',')? expression)+
  public static boolean simple_array_literal_2d_indexed_list_row_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row_head")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_SIMPLE_ARRAY_LITERAL_2_D_INDEXED_LIST_ROW_HEAD, "<simple array literal 2 d indexed list row head>");
    r = simple_array_literal_2d_indexed_list_row_head_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!simple_array_literal_2d_indexed_list_row_head_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simple_array_literal_2d_indexed_list_row_head", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (':' | ',')? expression
  private static boolean simple_array_literal_2d_indexed_list_row_head_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row_head_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d_indexed_list_row_head_0_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' | ',')?
  private static boolean simple_array_literal_2d_indexed_list_row_head_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row_head_0_0")) return false;
    simple_array_literal_2d_indexed_list_row_head_0_0_0(b, l + 1);
    return true;
  }

  // ':' | ','
  private static boolean simple_array_literal_2d_indexed_list_row_head_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_indexed_list_row_head_0_0_0")) return false;
    boolean r;
    r = consumeToken(b, BNF_COLON);
    if (!r) r = consumeToken(b, BNF_COMMA);
    return r;
  }

  /* ********************************************************** */
  // expr_list ('|' expr_list)*
  public static boolean simple_array_literal_2d_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_SIMPLE_ARRAY_LITERAL_2_D_LIST, "<simple array literal 2 d list>");
    r = expr_list(b, l + 1);
    r = r && simple_array_literal_2d_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('|' expr_list)*
  private static boolean simple_array_literal_2d_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simple_array_literal_2d_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simple_array_literal_2d_list_1", c)) break;
    }
    return true;
  }

  // '|' expr_list
  private static boolean simple_array_literal_2d_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_2d_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PIPE);
    r = r && expr_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '|' (simple_array_literal_2d_list)? '|' | simple_array_literal_3d_list ',' '|' simple_array_literal_2d_list '|'
  public static boolean simple_array_literal_3d_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_3d_list")) return false;
    if (!nextTokenIs(b, BNF_PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_3d_list_0(b, l + 1);
    if (!r) r = simple_array_literal_3d_list_1(b, l + 1);
    exit_section_(b, m, BNF_SIMPLE_ARRAY_LITERAL_3_D_LIST, r);
    return r;
  }

  // '|' (simple_array_literal_2d_list)? '|'
  private static boolean simple_array_literal_3d_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_3d_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PIPE);
    r = r && simple_array_literal_3d_list_0_1(b, l + 1);
    r = r && consumeToken(b, BNF_PIPE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (simple_array_literal_2d_list)?
  private static boolean simple_array_literal_3d_list_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_3d_list_0_1")) return false;
    simple_array_literal_3d_list_0_1_0(b, l + 1);
    return true;
  }

  // (simple_array_literal_2d_list)
  private static boolean simple_array_literal_3d_list_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_3d_list_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_3d_list ',' '|' simple_array_literal_2d_list '|'
  private static boolean simple_array_literal_3d_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_array_literal_3d_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_3d_list(b, l + 1);
    r = r && consumeTokens(b, 0, BNF_COMMA, BNF_PIPE);
    r = r && simple_array_literal_2d_list(b, l + 1);
    r = r && consumeToken(b, BNF_PIPE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (include | declaration | assignment | constraint | goal | output | predicate | function | class_declaration | annotation) (';' | <<eof>>)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BNF_STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, statement_1(b, l + 1));
    r = p && statement_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, MiniZincParser::semicolon_recover);
    return r || p;
  }

  // !<<eof>>
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // include | declaration | assignment | constraint | goal | output | predicate | function | class_declaration | annotation
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    r = include(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = constraint(b, l + 1);
    if (!r) r = goal(b, l + 1);
    if (!r) r = output(b, l + 1);
    if (!r) r = predicate(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = class_declaration(b, l + 1);
    if (!r) r = annotation(b, l + 1);
    return r;
  }

  // ';' | <<eof>>
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_SEMICOLON);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL | interpolated_string_start string_quote_rest
  public static boolean string_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expression")) return false;
    if (!nextTokenIsFast(b, BNF_INTERPOLATED_STRING_START, BNF_STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_STRING_EXPRESSION, "<string expression>");
    r = consumeTokenFast(b, BNF_STRING_LITERAL);
    if (!r) r = string_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // interpolated_string_start string_quote_rest
  private static boolean string_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BNF_INTERPOLATED_STRING_START);
    r = r && string_quote_rest(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((STRING_LITERAL ',')* STRING_LITERAL)?
  static boolean string_lit_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_lit_list")) return false;
    string_lit_list_0(b, l + 1);
    return true;
  }

  // (STRING_LITERAL ',')* STRING_LITERAL
  private static boolean string_lit_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_lit_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_lit_list_0_0(b, l + 1);
    r = r && consumeToken(b, BNF_STRING_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING_LITERAL ',')*
  private static boolean string_lit_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_lit_list_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_lit_list_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_lit_list_0_0", c)) break;
    }
    return true;
  }

  // STRING_LITERAL ','
  private static boolean string_lit_list_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_lit_list_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_STRING_LITERAL, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((expression ',')* expression ','?) (interpolated_string_middle ((expression ',')* expression ','?))* interpolated_string_end
  public static boolean string_quote_rest(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_STRING_QUOTE_REST, "<string quote rest>");
    r = string_quote_rest_0(b, l + 1);
    r = r && string_quote_rest_1(b, l + 1);
    r = r && consumeToken(b, BNF_INTERPOLATED_STRING_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (expression ',')* expression ','?
  private static boolean string_quote_rest_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_quote_rest_0_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    r = r && string_quote_rest_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression ',')*
  private static boolean string_quote_rest_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_quote_rest_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_quote_rest_0_0", c)) break;
    }
    return true;
  }

  // expression ','
  private static boolean string_quote_rest_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean string_quote_rest_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_0_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  // (interpolated_string_middle ((expression ',')* expression ','?))*
  private static boolean string_quote_rest_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_quote_rest_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_quote_rest_1", c)) break;
    }
    return true;
  }

  // interpolated_string_middle ((expression ',')* expression ','?)
  private static boolean string_quote_rest_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_INTERPOLATED_STRING_MIDDLE);
    r = r && string_quote_rest_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression ',')* expression ','?
  private static boolean string_quote_rest_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_quote_rest_1_0_1_0(b, l + 1);
    r = r && expression(b, l + 1, -1);
    r = r && string_quote_rest_1_0_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression ',')*
  private static boolean string_quote_rest_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_quote_rest_1_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_quote_rest_1_0_1_0", c)) break;
    }
    return true;
  }

  // expression ','
  private static boolean string_quote_rest_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean string_quote_rest_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_quote_rest_1_0_1_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // '(' expression ',' expr_list? ')'
  public static boolean tuple_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal")) return false;
    if (!nextTokenIs(b, BNF_PARENTHESIS_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_COMMA);
    r = r && tuple_literal_3(b, l + 1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, BNF_TUPLE_LITERAL, r);
    return r;
  }

  // expr_list?
  private static boolean tuple_literal_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_literal_3")) return false;
    expr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (base_type | "array" "[" type_list "]" "of" base_type | "list" "of" base_type) ("++" base_type)?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_TYPE, "<type>");
    r = type_0(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // base_type | "array" "[" type_list "]" "of" base_type | "list" "of" base_type
  private static boolean type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base_type(b, l + 1);
    if (!r) r = type_0_1(b, l + 1);
    if (!r) r = type_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "array" "[" type_list "]" "of" base_type
  private static boolean type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_ARRAY, BNF_BRACKET_LEFT);
    r = r && type_list(b, l + 1);
    r = r && consumeTokens(b, 0, BNF_BRACKET_RIGHT, BNF_KEYWORD_OF);
    r = r && base_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "list" "of" base_type
  private static boolean type_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BNF_KEYWORD_LIST, BNF_KEYWORD_OF);
    r = r && base_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("++" base_type)?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_1_0(b, l + 1);
    return true;
  }

  // "++" base_type
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BNF_OPERATOR_PLUSPLUS);
    r = r && base_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type ':' identifier annotations?
  static boolean type_and_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, BNF_COLON);
    r = r && identifier(b, l + 1);
    r = r && type_and_identifier_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotations?
  private static boolean type_and_identifier_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_3")) return false;
    annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // type_and_identifier_list_head ','?
  public static boolean type_and_identifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_TYPE_AND_IDENTIFIER_LIST, "<type and identifier list>");
    r = type_and_identifier_list_head(b, l + 1);
    r = r && type_and_identifier_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ','?
  private static boolean type_and_identifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_list_1")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // (type_and_identifier ',')* type_and_identifier
  public static boolean type_and_identifier_list_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_list_head")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_TYPE_AND_IDENTIFIER_LIST_HEAD, "<type and identifier list head>");
    r = type_and_identifier_list_head_0(b, l + 1);
    r = r && type_and_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (type_and_identifier ',')*
  private static boolean type_and_identifier_list_head_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_list_head_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_and_identifier_list_head_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_and_identifier_list_head_0", c)) break;
    }
    return true;
  }

  // type_and_identifier ','
  private static boolean type_and_identifier_list_head_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_and_identifier_list_head_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_and_identifier(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (type ',')* type ','?
  public static boolean type_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BNF_TYPE_LIST, "<type list>");
    r = type_list_0(b, l + 1);
    r = r && type(b, l + 1);
    r = r && type_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (type ',')*
  private static boolean type_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_list_0", c)) break;
    }
    return true;
  }

  // type ','
  private static boolean type_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, BNF_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean type_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_2")) return false;
    consumeToken(b, BNF_COMMA);
    return true;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: ATOM(atom_expression)
  // 1: BINARY(infix_expression)
  // 2: POSTFIX(postfix_expression)
  // 3: PREFIX(prefix_expression)
  public static boolean expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = atom_expression(b, l + 1);
    if (!r) r = prefix_expression(b, l + 1);
    p = r;
    r = r && expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && infix_expression_0(b, l + 1)) {
        r = expression(b, l, 1);
        exit_section_(b, l, m, BNF_INFIX_EXPRESSION, r, true, null);
      }
      else if (g < 2 && postfix_expression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, BNF_POSTFIX_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // call_expression | (call_expression access_tail) | (identifier access_tail) | identifier | ('(' expression ')') | ('(' expression ')' access_tail) | ('(' expression ')' "^-1") | ('(' expression ')' access_tail "^-1") | (call_expression "^-1") | (call_expression access_tail "^-1")  | (identifier "^-1") | (identifier access_tail "^-1") | "_" | ("_" access_tail) | ("_" "^-1") | ("_" access_tail "^-1") | ("_" '(' expression ')') | bool_literal | (bool_literal "^-1") | integer_literal | (integer_literal "^-1") | "infinity" | ("infinity" "^-1") | float_literal | (float_literal "^-1") | "<>" | ("<>" "^-1") | set_literal | (set_literal access_tail) | (set_literal "^-1") | (set_literal access_tail "^-1") | set_comprehension | (set_comprehension access_tail) | (set_comprehension "^-1") | (set_comprehension access_tail "^-1") | simple_array_literal | (simple_array_literal access_tail) | simple_array_literal "^-1" | simple_array_literal access_tail "^-1" | simple_array_literal_2d | simple_array_literal_2d access_tail | simple_array_literal_2d "^-1" | simple_array_literal_2d access_tail "^-1" | simple_array_comprehension | simple_array_comprehension access_tail | simple_array_comprehension "^-1" | simple_array_comprehension access_tail "^-1" | if_then_else_expression | if_then_else_expression access_tail | if_then_else_expression "^-1" | if_then_else_expression access_tail "^-1" | let_expression | tuple_literal | tuple_literal access_tail | tuple_literal "^-1" | tuple_literal access_tail "^-1" | record_literal | record_literal access_tail | record_literal "^-1" | record_literal access_tail "^-1" | string_expression
  public static boolean atom_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_ATOM_EXPRESSION, "<atom expression>");
    r = call_expression(b, l + 1);
    if (!r) r = atom_expression_1(b, l + 1);
    if (!r) r = atom_expression_2(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = atom_expression_4(b, l + 1);
    if (!r) r = atom_expression_5(b, l + 1);
    if (!r) r = atom_expression_6(b, l + 1);
    if (!r) r = atom_expression_7(b, l + 1);
    if (!r) r = atom_expression_8(b, l + 1);
    if (!r) r = atom_expression_9(b, l + 1);
    if (!r) r = atom_expression_10(b, l + 1);
    if (!r) r = atom_expression_11(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_UNDERSCORE);
    if (!r) r = atom_expression_13(b, l + 1);
    if (!r) r = atom_expression_14(b, l + 1);
    if (!r) r = atom_expression_15(b, l + 1);
    if (!r) r = atom_expression_16(b, l + 1);
    if (!r) r = bool_literal(b, l + 1);
    if (!r) r = atom_expression_18(b, l + 1);
    if (!r) r = integer_literal(b, l + 1);
    if (!r) r = atom_expression_20(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_INFINITY);
    if (!r) r = atom_expression_22(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_FLOAT_LITERAL);
    if (!r) r = atom_expression_24(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_ABSENT);
    if (!r) r = atom_expression_26(b, l + 1);
    if (!r) r = set_literal(b, l + 1);
    if (!r) r = atom_expression_28(b, l + 1);
    if (!r) r = atom_expression_29(b, l + 1);
    if (!r) r = atom_expression_30(b, l + 1);
    if (!r) r = set_comprehension(b, l + 1);
    if (!r) r = atom_expression_32(b, l + 1);
    if (!r) r = atom_expression_33(b, l + 1);
    if (!r) r = atom_expression_34(b, l + 1);
    if (!r) r = simple_array_literal(b, l + 1);
    if (!r) r = atom_expression_36(b, l + 1);
    if (!r) r = atom_expression_37(b, l + 1);
    if (!r) r = atom_expression_38(b, l + 1);
    if (!r) r = simple_array_literal_2d(b, l + 1);
    if (!r) r = atom_expression_40(b, l + 1);
    if (!r) r = atom_expression_41(b, l + 1);
    if (!r) r = atom_expression_42(b, l + 1);
    if (!r) r = simple_array_comprehension(b, l + 1);
    if (!r) r = atom_expression_44(b, l + 1);
    if (!r) r = atom_expression_45(b, l + 1);
    if (!r) r = atom_expression_46(b, l + 1);
    if (!r) r = if_then_else_expression(b, l + 1);
    if (!r) r = atom_expression_48(b, l + 1);
    if (!r) r = atom_expression_49(b, l + 1);
    if (!r) r = atom_expression_50(b, l + 1);
    if (!r) r = let_expression(b, l + 1);
    if (!r) r = tuple_literal(b, l + 1);
    if (!r) r = atom_expression_53(b, l + 1);
    if (!r) r = atom_expression_54(b, l + 1);
    if (!r) r = atom_expression_55(b, l + 1);
    if (!r) r = record_literal(b, l + 1);
    if (!r) r = atom_expression_57(b, l + 1);
    if (!r) r = atom_expression_58(b, l + 1);
    if (!r) r = atom_expression_59(b, l + 1);
    if (!r) r = string_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // call_expression access_tail
  private static boolean atom_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier access_tail
  private static boolean atom_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')'
  private static boolean atom_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' access_tail
  private static boolean atom_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' "^-1"
  private static boolean atom_expression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeTokensSmart(b, 0, BNF_PARENTHESIS_RIGHT, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' access_tail "^-1"
  private static boolean atom_expression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_expression "^-1"
  private static boolean atom_expression_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_expression access_tail "^-1"
  private static boolean atom_expression_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier "^-1"
  private static boolean atom_expression_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier access_tail "^-1"
  private static boolean atom_expression_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" access_tail
  private static boolean atom_expression_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_UNDERSCORE);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" "^-1"
  private static boolean atom_expression_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_UNDERSCORE, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" access_tail "^-1"
  private static boolean atom_expression_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_UNDERSCORE);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" '(' expression ')'
  private static boolean atom_expression_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_UNDERSCORE, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // bool_literal "^-1"
  private static boolean atom_expression_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // integer_literal "^-1"
  private static boolean atom_expression_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "infinity" "^-1"
  private static boolean atom_expression_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_KEYWORD_INFINITY, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // float_literal "^-1"
  private static boolean atom_expression_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_24")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_FLOAT_LITERAL, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "<>" "^-1"
  private static boolean atom_expression_26(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_26")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_KEYWORD_ABSENT, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal access_tail
  private static boolean atom_expression_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal "^-1"
  private static boolean atom_expression_29(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_29")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal access_tail "^-1"
  private static boolean atom_expression_30(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_30")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension access_tail
  private static boolean atom_expression_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_32")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension "^-1"
  private static boolean atom_expression_33(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_33")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension access_tail "^-1"
  private static boolean atom_expression_34(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_34")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal access_tail
  private static boolean atom_expression_36(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_36")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal "^-1"
  private static boolean atom_expression_37(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_37")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal access_tail "^-1"
  private static boolean atom_expression_38(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_38")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d access_tail
  private static boolean atom_expression_40(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_40")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d "^-1"
  private static boolean atom_expression_41(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_41")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d access_tail "^-1"
  private static boolean atom_expression_42(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_42")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension access_tail
  private static boolean atom_expression_44(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_44")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension "^-1"
  private static boolean atom_expression_45(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_45")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension access_tail "^-1"
  private static boolean atom_expression_46(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_46")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression access_tail
  private static boolean atom_expression_48(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_48")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression "^-1"
  private static boolean atom_expression_49(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_49")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression access_tail "^-1"
  private static boolean atom_expression_50(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_50")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal access_tail
  private static boolean atom_expression_53(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_53")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal "^-1"
  private static boolean atom_expression_54(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_54")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal access_tail "^-1"
  private static boolean atom_expression_55(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_55")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal access_tail
  private static boolean atom_expression_57(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_57")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal "^-1"
  private static boolean atom_expression_58(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_58")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal access_tail "^-1"
  private static boolean atom_expression_59(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expression_59")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "<->" | "->" | "<-" | "\\/" | "xor" | "/\\" | "<" | ">" | "<=" | ">=" | "=" | "!=" | "in" | "subset" | "superset" | "union" | "diff" | "symdiff" | ".." | "..<" | "<.." |  "<..<" | "intersect" | "++" | "+" | "-" | "*" | "/" | "div" | "mod" | "^" | "~+" | "~-" | "~*" | "~/" | "~div" | "~=" | "~!=" | "default" | quoted_identifier
  private static boolean infix_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_EQUIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_IMPL);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_RIMPL);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_OR);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_XOR);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_AND);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_GR);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LQ);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_GQ);
    if (!r) r = consumeTokenSmart(b, BNF_EQUALS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_NQ);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_IN);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_SUBSET);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_SUPERSET);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_UNION);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DIFF);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_SYMDIFF);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_INTERSECT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_PLUSPLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MINUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MULT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_IDIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MOD);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_POW);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_MINUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_MULT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_DIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_IDIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_EQ);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_NQ);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_DEFAULT);
    if (!r) r = consumeTokenSmart(b, BNF_QUOTED_IDENTIFIER);
    return r;
  }

  // ".." | "..<" | "<.." |  "<..<"
  private static boolean postfix_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    return r;
  }

  public static boolean prefix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_expression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = prefix_expression_0(b, l + 1);
    p = r;
    r = p && expression(b, l, -1);
    exit_section_(b, l, m, BNF_PREFIX_EXPRESSION, r, p, null);
    return r || p;
  }

  // ".." | "..<" | "<.." | "<..<" | "not" | "+" | "-"
  private static boolean prefix_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_NOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MINUS);
    return r;
  }

  /* ********************************************************** */
  // Expression root: set_expression
  // Operator priority table:
  // 0: ATOM(atom_set_expression)
  // 1: BINARY(infix_set_expression)
  // 2: POSTFIX(postfix_set_expression)
  // 3: PREFIX(prefix_set_expression)
  public static boolean set_expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "set_expression")) return false;
    addVariant(b, "<set expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<set expression>");
    r = atom_set_expression(b, l + 1);
    if (!r) r = prefix_set_expression(b, l + 1);
    p = r;
    r = r && set_expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean set_expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "set_expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && infix_set_expression_0(b, l + 1)) {
        r = set_expression(b, l, 1);
        exit_section_(b, l, m, BNF_INFIX_SET_EXPRESSION, r, true, null);
      }
      else if (g < 2 && postfix_set_expression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, BNF_POSTFIX_SET_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // '(' expression ')' | '(' expression ')' access_tail | '(' expression ')' "^-1" | '(' expression ')' access_tail "^-1" | identifier | identifier access_tail | identifier "^-1" | identifier access_tail "^-1" | "_" | "_" access_tail | "_" "^-1" | "_" access_tail "^-1" | "_" '(' expression ')' | bool_literal | bool_literal "^-1" | integer_literal | integer_literal "^-1" | "infinity" | "infinity" "^-1" | float_literal | float_literal "^-1" | "<>" | "<>" "^-1" | set_literal | set_literal access_tail | set_literal "^-1" | set_literal access_tail "^-1" | set_comprehension | set_comprehension access_tail | set_comprehension "^-1" | set_comprehension access_tail "^-1" | simple_array_literal | simple_array_literal access_tail | simple_array_literal "^-1" | simple_array_literal access_tail "^-1" | simple_array_literal_2d | simple_array_literal_2d access_tail | simple_array_literal_2d "^-1" | simple_array_literal_2d access_tail "^-1" | simple_array_comprehension | simple_array_comprehension access_tail | simple_array_comprehension "^-1" | simple_array_comprehension access_tail "^-1" | if_then_else_expression | if_then_else_expression access_tail | if_then_else_expression "^-1" | if_then_else_expression access_tail "^-1" | let_expression | call_expression | call_expression access_tail | call_expression "^-1" | call_expression access_tail "^-1" | tuple_literal | tuple_literal access_tail | tuple_literal "^-1" | tuple_literal access_tail "^-1" | record_literal | record_literal access_tail | record_literal "^-1" | record_literal access_tail "^-1" | string_expression
  public static boolean atom_set_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BNF_ATOM_SET_EXPRESSION, "<atom set expression>");
    r = atom_set_expression_0(b, l + 1);
    if (!r) r = atom_set_expression_1(b, l + 1);
    if (!r) r = atom_set_expression_2(b, l + 1);
    if (!r) r = atom_set_expression_3(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = atom_set_expression_5(b, l + 1);
    if (!r) r = atom_set_expression_6(b, l + 1);
    if (!r) r = atom_set_expression_7(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_UNDERSCORE);
    if (!r) r = atom_set_expression_9(b, l + 1);
    if (!r) r = atom_set_expression_10(b, l + 1);
    if (!r) r = atom_set_expression_11(b, l + 1);
    if (!r) r = atom_set_expression_12(b, l + 1);
    if (!r) r = bool_literal(b, l + 1);
    if (!r) r = atom_set_expression_14(b, l + 1);
    if (!r) r = integer_literal(b, l + 1);
    if (!r) r = atom_set_expression_16(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_INFINITY);
    if (!r) r = atom_set_expression_18(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_FLOAT_LITERAL);
    if (!r) r = atom_set_expression_20(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_ABSENT);
    if (!r) r = atom_set_expression_22(b, l + 1);
    if (!r) r = set_literal(b, l + 1);
    if (!r) r = atom_set_expression_24(b, l + 1);
    if (!r) r = atom_set_expression_25(b, l + 1);
    if (!r) r = atom_set_expression_26(b, l + 1);
    if (!r) r = set_comprehension(b, l + 1);
    if (!r) r = atom_set_expression_28(b, l + 1);
    if (!r) r = atom_set_expression_29(b, l + 1);
    if (!r) r = atom_set_expression_30(b, l + 1);
    if (!r) r = simple_array_literal(b, l + 1);
    if (!r) r = atom_set_expression_32(b, l + 1);
    if (!r) r = atom_set_expression_33(b, l + 1);
    if (!r) r = atom_set_expression_34(b, l + 1);
    if (!r) r = simple_array_literal_2d(b, l + 1);
    if (!r) r = atom_set_expression_36(b, l + 1);
    if (!r) r = atom_set_expression_37(b, l + 1);
    if (!r) r = atom_set_expression_38(b, l + 1);
    if (!r) r = simple_array_comprehension(b, l + 1);
    if (!r) r = atom_set_expression_40(b, l + 1);
    if (!r) r = atom_set_expression_41(b, l + 1);
    if (!r) r = atom_set_expression_42(b, l + 1);
    if (!r) r = if_then_else_expression(b, l + 1);
    if (!r) r = atom_set_expression_44(b, l + 1);
    if (!r) r = atom_set_expression_45(b, l + 1);
    if (!r) r = atom_set_expression_46(b, l + 1);
    if (!r) r = let_expression(b, l + 1);
    if (!r) r = call_expression(b, l + 1);
    if (!r) r = atom_set_expression_49(b, l + 1);
    if (!r) r = atom_set_expression_50(b, l + 1);
    if (!r) r = atom_set_expression_51(b, l + 1);
    if (!r) r = tuple_literal(b, l + 1);
    if (!r) r = atom_set_expression_53(b, l + 1);
    if (!r) r = atom_set_expression_54(b, l + 1);
    if (!r) r = atom_set_expression_55(b, l + 1);
    if (!r) r = record_literal(b, l + 1);
    if (!r) r = atom_set_expression_57(b, l + 1);
    if (!r) r = atom_set_expression_58(b, l + 1);
    if (!r) r = atom_set_expression_59(b, l + 1);
    if (!r) r = string_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' expression ')'
  private static boolean atom_set_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' access_tail
  private static boolean atom_set_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' "^-1"
  private static boolean atom_set_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeTokensSmart(b, 0, BNF_PARENTHESIS_RIGHT, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ')' access_tail "^-1"
  private static boolean atom_set_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier access_tail
  private static boolean atom_set_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier "^-1"
  private static boolean atom_set_expression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier access_tail "^-1"
  private static boolean atom_set_expression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" access_tail
  private static boolean atom_set_expression_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_UNDERSCORE);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" "^-1"
  private static boolean atom_set_expression_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_UNDERSCORE, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" access_tail "^-1"
  private static boolean atom_set_expression_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BNF_UNDERSCORE);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "_" '(' expression ')'
  private static boolean atom_set_expression_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_UNDERSCORE, BNF_PARENTHESIS_LEFT);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, BNF_PARENTHESIS_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // bool_literal "^-1"
  private static boolean atom_set_expression_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // integer_literal "^-1"
  private static boolean atom_set_expression_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "infinity" "^-1"
  private static boolean atom_set_expression_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_KEYWORD_INFINITY, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // float_literal "^-1"
  private static boolean atom_set_expression_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_FLOAT_LITERAL, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "<>" "^-1"
  private static boolean atom_set_expression_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, BNF_KEYWORD_ABSENT, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal access_tail
  private static boolean atom_set_expression_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_24")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal "^-1"
  private static boolean atom_set_expression_25(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_25")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_literal access_tail "^-1"
  private static boolean atom_set_expression_26(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_26")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension access_tail
  private static boolean atom_set_expression_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension "^-1"
  private static boolean atom_set_expression_29(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_29")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_comprehension access_tail "^-1"
  private static boolean atom_set_expression_30(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_30")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = set_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal access_tail
  private static boolean atom_set_expression_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_32")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal "^-1"
  private static boolean atom_set_expression_33(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_33")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal access_tail "^-1"
  private static boolean atom_set_expression_34(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_34")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d access_tail
  private static boolean atom_set_expression_36(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_36")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d "^-1"
  private static boolean atom_set_expression_37(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_37")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_literal_2d access_tail "^-1"
  private static boolean atom_set_expression_38(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_38")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_literal_2d(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension access_tail
  private static boolean atom_set_expression_40(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_40")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension "^-1"
  private static boolean atom_set_expression_41(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_41")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_array_comprehension access_tail "^-1"
  private static boolean atom_set_expression_42(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_42")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_array_comprehension(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression access_tail
  private static boolean atom_set_expression_44(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_44")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression "^-1"
  private static boolean atom_set_expression_45(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_45")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_then_else_expression access_tail "^-1"
  private static boolean atom_set_expression_46(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_46")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_then_else_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_expression access_tail
  private static boolean atom_set_expression_49(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_49")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_expression "^-1"
  private static boolean atom_set_expression_50(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_50")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_expression access_tail "^-1"
  private static boolean atom_set_expression_51(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_51")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expression(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal access_tail
  private static boolean atom_set_expression_53(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_53")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal "^-1"
  private static boolean atom_set_expression_54(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_54")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tuple_literal access_tail "^-1"
  private static boolean atom_set_expression_55(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_55")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal access_tail
  private static boolean atom_set_expression_57(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_57")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal "^-1"
  private static boolean atom_set_expression_58(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_58")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // record_literal access_tail "^-1"
  private static boolean atom_set_expression_59(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_set_expression_59")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record_literal(b, l + 1);
    r = r && access_tail(b, l + 1);
    r = r && consumeToken(b, BNF_OPERATOR_POW_MINUS1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "union" | "diff" | "symdiff" | ".." | "..<" | "<.." | "<..<" | "intersect" | "+" | "-" | "*" | "/" | "div" | "mod" | "^" | "~+" | "~-" | "~*" | "~/" | "~div" | "~=" | "~!=" | "default" | quoted_identifier
  private static boolean infix_set_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_set_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_UNION);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DIFF);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_SYMDIFF);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_INTERSECT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MINUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MULT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_IDIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MOD);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_POW);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_MINUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_MULT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_DIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_IDIV);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_EQ);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_WEAK_NQ);
    if (!r) r = consumeTokenSmart(b, BNF_KEYWORD_DEFAULT);
    if (!r) r = consumeTokenSmart(b, BNF_QUOTED_IDENTIFIER);
    return r;
  }

  // ".." | "..<" | "<.." | "<..<"
  private static boolean postfix_set_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_set_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    return r;
  }

  public static boolean prefix_set_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_set_expression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = prefix_set_expression_0(b, l + 1);
    p = r;
    r = p && set_expression(b, l, -1);
    exit_section_(b, l, m, BNF_PREFIX_SET_EXPRESSION, r, p, null);
    return r || p;
  }

  // ".." | "..<" | "<.." | "<..<" | "+" | "-"
  private static boolean prefix_set_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_set_expression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_LE_DOTDOT_LE);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_PLUS);
    if (!r) r = consumeTokenSmart(b, BNF_OPERATOR_MINUS);
    return r;
  }

}
