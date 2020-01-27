grammar Small_Java;

file : imports code_bloc EOF;

imports
    : single_import*
    ;

single_import
    : IMPORT lib=LIB SC
    ;

code_bloc
    : dec_class
    ;

dec_class
    : MODIF CLASS ID LCB dec* func RCB
    ;

func
    : MAIN LCB instructions RCB
    ;

condition
    : IF LPAREN cond RPAREN THEN LCB then = instructions RCB ( ELSE LCB els = instructions RCB )?
    ;

instructions
    : instruction*
    ;

cond
    : not=NOT notval=cond
    | left=cond op=AND right=cond
    | left=cond op=OR right=cond
    | LPAREN compval = cond RPAREN
    | comp
    ;

comp
    : left=expression op=(GT | LT | GTE | LTE | EQ | NEQ) right=expression
    ;

instruction
    : mov
    | condition
    | read
    | write
    ;

read
    : READ LPAREN read_expression RPAREN SC
    ;

write
    : WRITE LPAREN write_expression RPAREN SC
    ;

read_expression
    : STRING (COMMA ID)+
    ;

write_expression
    : STRING (COMMA ID)*
    ;

dec
    : TYPE ID ( MOV expression)? SC
    | TYPE ID ( MOV STRING)? SC
    ;

mov
    : ID MOV expression SC
    | ID MOV STRING SC
    ;

expression
    : left=expression op=(TIMES | DIV) right=expression
    | left=expression op=(PLUS | MINUS) right=expression
    | LPAREN evalue=expression RPAREN
    | op=(PLUS | MINUS)* avalue=atom
    ;

atom
    : content = ID
    | content = INT_NUMBER
    | content = FLOAT_NUMBER
    ;

FLOAT_NUMBER
    : INT_NUMBER '.' INT_NUMBER
    ;

INT_NUMBER
    : ('0' .. '9')+
    ;

IMPORT
    : 'import'
    ;

MODIF
    : 'public' | 'protected'
    ;

LIB
    : 'Small_Java.lang' | 'Small_Java.io'
    ;

CLASS
    : 'class_SJ'
    ;

MAIN
    : 'main_SJ'
    ;

COMMA
    : ','
    ;

TYPE
    : 'int_SJ' | 'float_SJ' | 'string_SJ'
    ;

MOV
    : ':='
    ;

LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


PLUS
   : '+'
   ;


MINUS
   : '-'
   ;


TIMES
   : '*'
   ;


DIV
   : '/'
   ;

GT
   : '>'
   ;

GTE
   : '>='
   ;

LT
   : '<'
   ;

LTE
   : '<='
   ;

EQ
    : '='
    ;

NEQ
    : '!='
    ;

NOT
    : '!'
    ;

AND
    : '&'
    ;

OR
    : '|'
    ;

POINT
   : '.'
   ;

SC
    : ';'
    ;

LCB
    : '{'
    ;

RCB
    : '}'
    ;

fragment DELSTRING
    : '"'
    ;

IF
    : 'Si'
    ;

ELSE
    : 'Sinon'
    ;

THEN
    : 'Alors'
    ;

READ
    : 'In_SJ'
    ;

WRITE
    : 'Out_SJ'
    ;

FORMAT
    : '%d' | '%f' | '%s'
    ;

STRING
    : DELSTRING .*? DELSTRING
    ;

ID
    : ([a-zA-Z]+[0-9]*)+
    ;

WS
   : [ \r\n\t] + -> skip
   ;