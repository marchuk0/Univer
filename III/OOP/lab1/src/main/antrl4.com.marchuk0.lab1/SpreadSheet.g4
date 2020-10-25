grammar SpreadSheet;


//Tokens

POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
LPAR: '(';
RPAR: ')';
INC: 'inc';
DEC: 'dec';
MMIN: 'mmin';
MMAX: 'mmax';
ARGSEPARATOP: ',';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;






formula
    : '=' expression EOF
    ;


expression
   : NUMBER                                         # Number
   | LPAR inner=expression RPAR                     # Parentheses
   | operator = MMIN LPAR inner=minargs RPAR        # Minimum
   | operator = MMAX LPAR inner=maxargs RPAR        # Maximum
   | left=expression operator=POW right=expression  # Power
   | left=expression operator=MUL right=expression  # Multiplication
   | left=expression operator=DIV right=expression  # Division
   | left=expression operator=ADD right=expression  # Addition
   | left=expression operator=SUB right=expression  # Subtraction
   ;

minargs
   : expression #SimpleMinArgs
   | expression ARGSEPARATOP minargs #RecursiveMinArgs
   ;
maxargs
   : expression #SimpleMaxArgs
   | expression ARGSEPARATOP maxargs #RecursiveMAxArgs
   ;



