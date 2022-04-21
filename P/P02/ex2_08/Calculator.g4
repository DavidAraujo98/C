grammar Calculator;
program: stat* EOF;
stat: expr? NEWLINE # StatExpr
    | assig? NEWLINE # StatAssig;
assig: ID '=' expr;
expr:
	expr expr op = ('*' | '/' | '%')    # ExprMulDivMod
	| expr expr op = ('+' | '-')    	# ExprAddSub
	| expr op = ('!+' | '!-')           # ExprUnary
	| Double							# ExprDouble
	| '(' expr ')'						# ExprParent
	| ID								# ExprId;
Double: [0-9]+ ('.' [0-9])?;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;