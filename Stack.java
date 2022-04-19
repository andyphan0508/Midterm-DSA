/** User definition of the class Stack
 *  examine and re-implement by Phan An Duy **/

/* @parameter: Using the <E> Generics
* so that we can add the desire datatype
* for the most case -> The parameter is String
* due to the requirement is String data type*/
public class Stack<E> {

    //..Some global initialize:
    int maxSize;
    char[] stackArray = new char[100];
    int top = -1;

    // Create constructor
    public Stack() {}

    /* Using above constructor to initialize constructor*/
    public Stack(int size) {

        /**Initialize Stack array**/
        int[] array = new int[size];
        maxSize = size;
        top = -1;

    }
    /** Condition to check Stack full or not **/
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == maxSize - -1;
    }
    public int getMaxSize() {
        return top + 1;
    }
    /** ----<CONDITION END>----
     * @return
     * @param c    **/

    /* Push function */
    public void push(char c) {
        stackArray[++top] = c;
    }
    /*Pop function*/
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }
}
