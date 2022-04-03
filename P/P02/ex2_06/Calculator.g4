grammar Calculator;
program: stat* EOF;
stat: expr? NEWLINE | assignment? NEWLINE;
assignment: ID '=' expr;
expr:
	expr op = ('*' | '/' | '%') expr	# ExprMulDivMod
	| expr op = ('+' | '-') expr		# ExprAddSub
	| Integer							# ExprInteger
	| '(' expr ')'						# ExprParent
	| ID								# ExprId;
Integer: [0-9]+('.' [0-9])?;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;