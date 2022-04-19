/** Stack configuration: "Stack.java"
 * pre-examine and re-create by Phan An Duy **/

import java.lang.*;

public class Task1_2 extends Stack {

    /** New Stack for the operators **/
    static Stack operators = new Stack();

    static String toPostfix (String infix) {

        /** This function is mainly for checking the
         * operators and push-pop accordingly to the
         * status of the infix Operators location from
         * line 18-47**/
        // Checking the symbol.
        char symbol;
        String postfix = "";
        for(int i = 0;i < infix.length(); ++i)
        //while there is input to be read
        {
            symbol = infix.charAt(i);
            //if it's an operand, add it to the string

            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol=='(') {
                operators.push((char)(symbol));
            }
            else if (symbol==')') {
                while (operators.peek() != '(') {
                    postfix = postfix + operators.pop();
                }
                operators.pop();
            }
            else {
                while (!operators.isEmpty() && !(operators.peek()=='(')
                        && operator(symbol) <= operator(operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push((char)(symbol));
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }

    //..Checking the priority of the operators
    static int operator(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
    /** This function is for creating the Postfix evaluation
     * by scanning all the text length, checking all the
     * operands and operator, and perform stack push-pop
     * to calculate properly **/
    static char evalPostfix(String exp) throws NumberFormatException {

        Stack stack = new Stack<>();

        //..Scanning the all integers by length using .length()
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            //..If the character is the digits -> push the characters
            if (Character.isDigit(c)) {
                stack.push((char)(c - '0'));
            } else {

                /**If the scanned character is an operator, pop two
                 * elements from stack apply the operator **/
                int value1 = stack.pop();
                int value2 = stack.pop();

                /**Adding the case for postfix evaluation
                 * by switching between each operators**/
                switch (c) {
                    case '+':
                        stack.push((char) (value2 + value1));
                        break;
                    case '-':
                        stack.push((char)(value2 - value1));
                        break;
                    case '/':
                        stack.push((char)(value2 / value1));
                        break;
                    case '*':
                        stack.push((char)(value2 * value1));
                        break;
                }
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        String infix = "9-(5+2*2)/3";
        System.out.println(toPostfix(infix));
        System.out.println(evalPostfix(infix));
    }
}
