Overview
YodaCalc is a Java-based calculator program designed to evaluate mathematical expressions. It supports basic arithmetic operations, including addition, subtraction, multiplication, division, and the use of parentheses for defining the order of operations. This program is particularly useful for applications requiring custom interpretation and processing of math expressions in a string format.

Features
Support for Basic Arithmetic: Handles +, -, *, / operations.
Parentheses Handling: Correctly interprets expressions enclosed in ( and ) to respect the mathematical order of operations.
Space Tolerance: Ignores spaces in the input, allowing for flexible input formatting.
Postfix Conversion: Internally converts the infix expression (standard mathematical notation) to postfix notation for easier computation.
How It Works
Input Processing: The program first removes any spaces from the input string to standardize it.
Infix to Postfix Conversion: It then converts the standardized infix expression to a postfix expression, making use of a stack to handle operator precedence and parentheses.
Evaluation: The postfix expression is evaluated using a stack to handle the operands and operators.
Usage
To use YodaCalc, simply call the calc method with a string representing the math expression. For example:

java
Copy code
System.out.println(YodaCalc.calc("3 * (4 + 5) - 6 / 2"));
Limitations
Does not support exponentiation or functions like sin, cos, etc.
Handles only numerical inputs; does not support variables.
Limited error handling for malformed expressions.
Example
In the main method, an example calculation is demonstrated:

java
Copy code
System.out.println(calc("(3*9+2+3  * (3 + 5))"));
This prints the evaluated result of the given expression.

YodaCalc provides a basic yet effective tool for evaluating mathematical expressions in string format in Java. Its conversion to postfix notation and efficient evaluation mechanism make it a handy utility for simple arithmetic calculations in various Java applications.






