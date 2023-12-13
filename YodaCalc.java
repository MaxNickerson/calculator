  import java.util.*;

public class YodaCalc {
    /**
     * This method takes in the input string, 
     * evaluates the math expression, and
     * returns the result as a decimal value.
     * 
     * @param   input   the input math string,
     *                  supporting: +, -, *, /, (, )
     * @return          the evaluated result
     */
    public static double calc(String input) {
        String inputre = "";
        String inputpost = "";

        Stack<Character> stacky = new Stack<Character>();

        // remakes input w/o spaces
        for (int i = 0; i < input.length(); i++) 
        {
            if (input.substring(i, i + 1).equals(" "))
            {
                // nothing
            }
            else 
            {
                inputre += input.substring(i, i + 1);
            }
        }


        for (int i = 0; i < inputre.length(); i++) 
        {
            char temp = inputre.charAt(i);

            if (Character.isLetterOrDigit(temp)) 
            {
                inputpost += temp;
            }


            else if (temp == '(')
            { 
                stacky.push(temp);
            }

            
            else if (temp == ')' ) 
            { 
                while (!stacky.isEmpty() && stacky.peek() != '(') 
                {
                    inputpost += " " + stacky.peek();
                    stacky.pop();
                }
                stacky.pop();
            }

            else 
            {  
                while (!stacky.isEmpty() && power(temp) <= power(stacky.peek())) 
                {
                    inputpost += " " + stacky.peek();
                    stacky.pop();
                }
                inputpost += " ";
                stacky.push(temp);
            }
        }
        while (!stacky.isEmpty()) 
        {
            inputpost += " " + stacky.peek();
            stacky.pop();
        }

        Stack<Double> result = new Stack<Double>();

        for (int i = 0; i < inputpost.length(); i++) 
        {
            char curr = inputpost.charAt(i);

            if (curr == ' ') 
            {
                
            }

            else if (Character.isDigit(curr)) 
            {
                double l = 0;
                while (Character.isDigit(curr)) 
                {
                    l = l * 10 + (double)(curr - '0');
                    i++;
                    curr = inputpost.charAt(i);
                }
                i--;

                result.push(l);
            }

            else 
            {
                double s1 = result.pop();
                double s2 = result.pop();
                
                if (curr == '+') 
                {
                    result.push(s2 + s1);
                }
                else if (curr == '-') 
                {
                    result.push(s2 - s1);
                }
                else if (curr == '*') 
                {
                    result.push(s2 * s1);
                }
                else if (curr == '/') 
                {
                    result.push(s2 / s1);
                }
            }
        }
        return result.pop();
        
    }

    // method return s power of an operator
    public static int power(char symbol) {

        if (symbol == '+' || symbol == '-') {
            return 1;
        }
        else if (symbol == '/' || symbol == '*') {
            return 2;
        }
        else if (symbol == '^') {
            return 3;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("(3*9+2+3  * (3 + 5))");

        System.out.println(calc("(3*9+2+3  * (3 + 5))"));
    }
}
