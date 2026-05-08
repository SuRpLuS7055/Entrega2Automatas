package uclm.automatas;

import java_cup.runtime.Symbol;

%%
%class Lexer
%public
%unicode
%line
%column
%cup

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn, yytext());
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

LETRA       = [a-zA-Z]
DIGITO      = [0-9]
ID          = {LETRA}({LETRA}|{DIGITO}|_)*
NUM         = {DIGITO}+
STRING      = \"[^\"]*\"

ESPACIOS    = [ \t\r\n\f]+

COMENT1     = "//".*
COMENT2     = "/*"([^*]|\*+[^*/])*"*"+"/"
COMENT3     = "#".*

%%

{ESPACIOS}  { /* ignorar */ }
{COMENT1}   { return symbol(sym.COMENTARIO, yytext()); }
{COMENT2}   { return symbol(sym.COMENTARIO, yytext()); }
{COMENT3}   { return symbol(sym.COMENTARIO, yytext()); }

"arbol"     { return symbol(sym.ARBOL); }
"node"      { return symbol(sym.NODE); }
"edge"      { return symbol(sym.EDGE); }
"hijos"     { return symbol(sym.HIJOS); }

"label"      { return symbol(sym.LABEL); }
"color"      { return symbol(sym.COLOR); }
"fontcolor"  { return symbol(sym.FONTCOLOR); }
"style"      { return symbol(sym.STYLE); }
"shape"      { return symbol(sym.SHAPE); }
"dir"        { return symbol(sym.DIR); }

"{"         { return symbol(sym.LLAVEI); }
"}"         { return symbol(sym.LLAVED); }
"["         { return symbol(sym.CORCHETEI); }
"]"         { return symbol(sym.CORCHETED); }
"="         { return symbol(sym.ASSIG); }
","         { return symbol(sym.COMA); }
";"         { return symbol(sym.PCOMA); }

{STRING}    { return symbol(sym.STRING, yytext()); }
{NUM}       { return symbol(sym.NUM, yytext()); }
{ID}        { return symbol(sym.ID, yytext()); }

.           { System.out.println("ERROR_LEXICO => " + yytext()); }

<<EOF>>     { return symbol(sym.EOF); }