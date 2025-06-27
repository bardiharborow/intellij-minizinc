package com.bardiharborow.minizinc.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.bardiharborow.minizinc.language.psi.MiniZincTypes.*;

%%

%{
  public _MiniZincLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MiniZincLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

FILE_DOCUMENTATION_COMMENT="/"\*\*\*~(\*"/")
DOCUMENTATION_COMMENT="/"\*\*~(\*"/")
BLOCK_COMMENT="/"\*~(\*"/")
LINE_COMMENT=%.*
TOKEN_INTEGER=[0-9]+
WHITE_SPACE=[\s\n]+
TOKEN_IDENTIFIER=[^\"'\s\.\-\[\]\^\/,;:(){}&|$.∞%<>⟷⇔>→⇒<←⇐∨⊻∧===!=≠<<=≤>>=≥∈⊆⊇~=~!=∪∖∩+++~+~*~*~]+
STRING_LITERAL=\"[^\"]*\"|'[^']*'
TOKEN_148='[^']*'

%%
<YYINITIAL> {
  {WHITE_SPACE}                      { return WHITE_SPACE; }

  "["                                { return BNF_BRACKET_LEFT; }
  "[|"                               { return BNF_BRACKET_LEFT_2D; }
  "]"                                { return BNF_BRACKET_RIGHT; }
  "|]"                               { return BNF_BRACKET_RIGHT_2D; }
  ".."                               { return BNF_OPERATOR_DOTDOT; }
  "'..'"                             { return BNF_OPERATOR_DOTDOT_QUOTED; }
  "..<"                              { return BNF_OPERATOR_DOTDOT_LE; }
  "'..<'"                            { return BNF_OPERATOR_DOTDOT_LE_QUOTED; }
  "<.."                              { return BNF_OPERATOR_LE_DOTDOT; }
  "'<..'"                            { return BNF_OPERATOR_LE_DOTDOT_QUOTED; }
  "<..<"                             { return BNF_OPERATOR_LE_DOTDOT_LE; }
  "'<..<'"                           { return BNF_OPERATOR_LE_DOTDOT_LE_QUOTED; }
  "."                                { return BNF_PERIOD; }
  "::"                               { return BNF_OPERATOR_COLONCOLON; }
  "_"                                { return BNF_UNDERSCORE; }
  "ann"                              { return BNF_KEYWORD_ANN; }
  "annotation"                       { return BNF_KEYWORD_ANNOTATION; }
  "any"                              { return BNF_KEYWORD_ANY; }
  "array"                            { return BNF_KEYWORD_ARRAY; }
  "bool"                             { return BNF_KEYWORD_BOOL; }
  "case"                             { return BNF_KEYWORD_CASE; }
  "class"                            { return BNF_KEYWORD_CLASS; }
  "constraint"                       { return BNF_KEYWORD_CONSTRAINT; }
  "default"                          { return BNF_KEYWORD_DEFAULT; }
  "extends"                          { return BNF_KEYWORD_EXTENDS; }
  "new"                              { return BNF_KEYWORD_NEW; }
  "div"                              { return BNF_OPERATOR_IDIV; }
  "'div'"                            { return BNF_OPERATOR_IDIV_QUOTED; }
  "diff"                             { return BNF_OPERATOR_DIFF; }
  "'diff'"                           { return BNF_OPERATOR_DIFF_QUOTED; }
  "else"                             { return BNF_KEYWORD_ELSE; }
  "elseif"                           { return BNF_KEYWORD_ELSEIF; }
  "endif"                            { return BNF_KEYWORD_ENDIF; }
  "enum"                             { return BNF_KEYWORD_ENUM; }
  "float"                            { return BNF_KEYWORD_FLOAT; }
  "function"                         { return BNF_KEYWORD_FUNCTION; }
  "if"                               { return BNF_KEYWORD_IF; }
  "include"                          { return BNF_KEYWORD_INCLUDE; }
  "infinity"                         { return BNF_KEYWORD_INFINITY; }
  "intersect"                        { return BNF_OPERATOR_INTERSECT; }
  "'intersect'"                      { return BNF_OPERATOR_INTERSECT_QUOTED; }
  "in"                               { return BNF_OPERATOR_IN; }
  "'in'"                             { return BNF_OPERATOR_IN_QUOTED; }
  "int"                              { return BNF_KEYWORD_INT; }
  "let"                              { return BNF_KEYWORD_LET; }
  "list"                             { return BNF_KEYWORD_LIST; }
  "maximize"                         { return BNF_KEYWORD_MAXIMIZE; }
  "minimize"                         { return BNF_KEYWORD_MINIMIZE; }
  "mod"                              { return BNF_OPERATOR_MOD; }
  "'mod'"                            { return BNF_OPERATOR_MOD_QUOTED; }
  "not"                              { return BNF_OPERATOR_NOT; }
  "'not'"                            { return BNF_OPERATOR_NOT_QUOTED; }
  "of"                               { return BNF_KEYWORD_OF; }
  "output"                           { return BNF_KEYWORD_OUTPUT; }
  "opt"                              { return BNF_KEYWORD_OPT; }
  "par"                              { return BNF_KEYWORD_PAR; }
  "predicate"                        { return BNF_KEYWORD_PREDICATE; }
  "record"                           { return BNF_KEYWORD_RECORD; }
  "satisfy"                          { return BNF_KEYWORD_SATISFY; }
  "set"                              { return BNF_KEYWORD_SET; }
  "solve"                            { return BNF_KEYWORD_SOLVE; }
  "string"                           { return BNF_KEYWORD_STRING; }
  "subset"                           { return BNF_OPERATOR_SUBSET; }
  "'subset'"                         { return BNF_OPERATOR_SUBSET_QUOTED; }
  "superset"                         { return BNF_OPERATOR_SUPERSET; }
  "'superset'"                       { return BNF_OPERATOR_SUPERSET_QUOTED; }
  "symdiff"                          { return BNF_OPERATOR_SYMDIFF; }
  "'symdiff'"                        { return BNF_OPERATOR_SYMDIFF_QUOTED; }
  "test"                             { return BNF_KEYWORD_TEST; }
  "then"                             { return BNF_KEYWORD_THEN; }
  "tuple"                            { return BNF_KEYWORD_TUPLE; }
  "type"                             { return BNF_KEYWORD_TYPE; }
  "union"                            { return BNF_OPERATOR_UNION; }
  "'union'"                          { return BNF_OPERATOR_UNION_QUOTED; }
  "var"                              { return BNF_KEYWORD_VAR; }
  "variant_record"                   { return BNF_KEYWORD_VARIANT_RECORD; }
  "where"                            { return BNF_KEYWORD_WHERE; }
  "xor"                              { return BNF_OPERATOR_XOR; }
  "'xor'"                            { return BNF_OPERATOR_XOR_QUOTED; }
  "+"                                { return BNF_OPERATOR_PLUS; }
  "'+'"                              { return BNF_OPERATOR_PLUS_QUOTED; }
  "-"                                { return BNF_OPERATOR_MINUS; }
  "'-'"                              { return BNF_OPERATOR_MINUS_QUOTED; }
  "*"                                { return BNF_OPERATOR_MULT; }
  "'*'"                              { return BNF_OPERATOR_MULT_QUOTED; }
  "/"                                { return BNF_OPERATOR_DIV; }
  "'/'"                              { return BNF_OPERATOR_DIV_QUOTED; }
  "^-1"                              { return BNF_OPERATOR_POW_MINUS1; }
  "^"                                { return BNF_OPERATOR_POW; }
  "'^'"                              { return BNF_OPERATOR_POW_QUOTED; }
  "++"                               { return BNF_OPERATOR_PLUSPLUS; }
  "'++'"                             { return BNF_OPERATOR_PLUSPLUS_QUOTED; }
  "<>"                               { return BNF_KEYWORD_ABSENT; }
  "<"                                { return BNF_OPERATOR_LE; }
  "'<'"                              { return BNF_OPERATOR_LE_QUOTED; }
  "<="                               { return BNF_OPERATOR_LQ; }
  "'<='"                             { return BNF_OPERATOR_LQ_QUOTED; }
  ">"                                { return BNF_OPERATOR_GR; }
  "'>'"                              { return BNF_OPERATOR_GR_QUOTED; }
  ">="                               { return BNF_OPERATOR_GQ; }
  "'>='"                             { return BNF_OPERATOR_GQ_QUOTED; }
  "=="                               { return BNF_OPERATOR_EQ; }
  "'=='"                             { return BNF_OPERATOR_EQ_QUOTED; }
  "!="                               { return BNF_OPERATOR_NQ; }
  "'!='"                             { return BNF_OPERATOR_NQ_QUOTED; }
  "->"                               { return BNF_OPERATOR_IMPL; }
  "'->'"                             { return BNF_OPERATOR_IMPL_QUOTED; }
  "<-"                               { return BNF_OPERATOR_RIMPL; }
  "'<-'"                             { return BNF_OPERATOR_RIMPL_QUOTED; }
  "<->"                              { return BNF_OPERATOR_EQUIV; }
  "'<->'"                            { return BNF_OPERATOR_EQUIV_QUOTED; }
  "\\\\/"                            { return BNF_OPERATOR_OR; }
  "'\\\\/'"                          { return BNF_OPERATOR_OR_QUOTED; }
  "/\\\\"                            { return BNF_OPERATOR_AND; }
  "'/\\'"                            { return BNF_OPERATOR_AND_QUOTED; }
  "~+"                               { return BNF_OPERATOR_WEAK_PLUS; }
  "~*"                               { return BNF_OPERATOR_WEAK_MULT; }
  "~="                               { return BNF_OPERATOR_WEAK_EQ; }
  "~!="                              { return BNF_OPERATOR_WEAK_NQ; }
  "~-"                               { return BNF_OPERATOR_WEAK_MINUS; }
  "~/"                               { return BNF_OPERATOR_WEAK_DIV; }
  "~div"                             { return BNF_OPERATOR_WEAK_IDIV; }
  "("                                { return BNF_PARENTHESIS_LEFT; }
  ")"                                { return BNF_PARENTHESIS_RIGHT; }
  ","                                { return BNF_COMMA; }
  ":"                                { return BNF_COLON; }
  ";"                                { return BNF_SEMICOLON; }
  "{"                                { return BNF_BRACE_LEFT; }
  "|"                                { return BNF_PIPE; }
  "}"                                { return BNF_BRACE_RIGHT; }
  "\""                               { return BNF_QUOTE; }
  "="                                { return BNF_EQUALS; }
  "type_inst_identifier"             { return BNF_TYPE_INST_IDENTIFIER; }
  "quoted_identifier"                { return BNF_QUOTED_IDENTIFIER; }
  "float_literal"                    { return BNF_FLOAT_LITERAL; }
  "interpolated_string_start"        { return BNF_INTERPOLATED_STRING_START; }
  "interpolated_string_middle"       { return BNF_INTERPOLATED_STRING_MIDDLE; }
  "interpolated_string_end"          { return BNF_INTERPOLATED_STRING_END; }

  {FILE_DOCUMENTATION_COMMENT}       { return BNF_FILE_DOCUMENTATION_COMMENT; }
  {DOCUMENTATION_COMMENT}            { return BNF_DOCUMENTATION_COMMENT; }
  {BLOCK_COMMENT}                    { return BNF_BLOCK_COMMENT; }
  {LINE_COMMENT}                     { return BNF_LINE_COMMENT; }
  {TOKEN_INTEGER}                    { return BNF_TOKEN_INTEGER; }
  {WHITE_SPACE}                      { return BNF_WHITE_SPACE; }
  {TOKEN_IDENTIFIER}                 { return BNF_TOKEN_IDENTIFIER; }
  {STRING_LITERAL}                   { return BNF_STRING_LITERAL; }
  {TOKEN_148}                        { return BNF_TOKEN_148; }

}

[^] { return BAD_CHARACTER; }
