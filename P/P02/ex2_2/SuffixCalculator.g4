grammar SuffixCalculator;
program:
    stat* EOF
    ;
stat:
    expr? NEWLINE
    ;
expr:
    expr op=('*'|'/'|'+'|'-') expr  #ExprNormal
    | Number                        #ExprNumber
    ;
Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
