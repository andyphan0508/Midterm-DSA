import java.util.*;

public class Task1_1 {

    public static void main(String[] args) {
        /*..User input elements
         * of the array*/
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements you want to store: ");
        num = scanner.nextInt();

        /*..Array initialize
         * for this one, we'll choose size of 20 for more headroom*/
        int[] array = new int[20];
        System.out.println("Enter the array node relatively to your array size");

        /*..Function for looped input*/
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("The elements of the array: ");
        for (int i = 0; i < num; i++) {
            System.out.print("[" + array[i] + "]");
        }

        /*.Checking the prime number
        in the array*/
        for (int i = 0; i < num; i++) {

            // j = 2 (skipping the first number 0, 1 <- because is not prime number)
            int j = 2, prime = 1;
            while (j < array[i]) {
                if (array[i] % j == 0) {
                    prime = 0;
                    break;
                } j++;
            }
            if (prime == 1) {
                System.out.print("\n In this array, these are prime number:" + array[i]);
            }
        }
        /*..Using <Insertion Sort> to sort the array*/
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        int n = array.length;
        for (int j : array) System.out.print(j + " ");
    }
}
