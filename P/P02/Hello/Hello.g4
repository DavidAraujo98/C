grammar Hello;                  // Define a grammar called Hello
top :   greetings | bye;
greetings   :   'hello' ID;     // match keyword hello followed by an identifier
bye :   'goodbye' ID;
name:   ID+;
main:   top* EOF;

ID  :   [A-Za-z]+;                 // match lower-case identifiers
WS  :   [ \t\r\n]+ -> skip;     // skip spaces, tabs, newlines, \r (Windows)