grammar Calculator;
program: stat* EOF;
stat:
	print? ';'    #StatPrint
	| assig? ';'  #StatAssig;
print: 
    expr                  #PrintExpr
    | ID                  #PrintID
    | 'reduce' expr       #PrintReduce;
assig: expr '->' ID;
expr:
	expr expr op = ('*' | '/' | '%')	# ExprMulDivMod
	| expr expr op = ('+' | '-')		# ExprAddSub
	| expr op = ('!+' | '!-')			# ExprUnary
	| Double							# ExprDouble
	| '(' expr ')'						# ExprParent
	| ID								# ExprId;
Double: [0-9]+ ('.' [0-9])?;
ID: [a-zA-Z_]+;
WS: [ \t\n]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;