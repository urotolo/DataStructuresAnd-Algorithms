package ramandselectsort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Professor: Dr.Whitley Assignment number: 4 Data Structures and Algorithms 333
 * Date: 10/5/17
 *
 * @author Ulisse Rotolo - This program builds two algorithms, count sort and
 * randomized quick select. For organizational purposes, even though I am
 * sacrificing a small amount of computing power, I separated my two algorithms
 * into two distinct classes. My main class will prompt the user and ask if the
 * user would like to run the algorithms again or instead would rather to exit
 * the program.
 *
 * Important note: Count sort works flawlessly. Randomized select sort somewhat
 * works. On rare occasions the output is totally sorted on other occasions the
 * compiler may throw a runtime error. Usually randomized select sort runs, yet
 * sorts the output partially correct and partially incorrect.
 */
public class RAMandSelectSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int arraySize, arrayHighestValue = 0;
        int[] array1, memoryAllocatedArray;
        boolean loop = true;

        countingSort countSort1 = new countingSort();
        RandomizedQuickSelect randSelect1 = new RandomizedQuickSelect();

        while (loop == true) // While loop begins
        {
            System.out.println("");
            System.out.println("May on rare occasion throw runtime error, for randomizedQuickSelect");
            System.out.println("Enter array size - ");
            arraySize = scan.nextInt();
            System.out.println("");

            array1 = new int[arraySize];   // array size
            memoryAllocatedArray = new int[array1.length];

            for (int i = 0; i <= array1.length - 1; i++) {
                array1[i] = (int) ((Math.random() * 10) + 10);       // array indexs are filled with random values
                if (array1[i] >= arrayHighestValue) {
                    arrayHighestValue = array1[i];
                }
            }

            System.out.println("Count Sort - ");    // countSort calculation begins
            System.out.println(Arrays.toString(array1));

            System.out.println("");
            countSort1.countingSort(array1, memoryAllocatedArray, arrayHighestValue);
            System.out.println("");

            System.out.println("randomizedQuickSelect - ");  // randomizedQuickSelectSort calculation begins
            System.out.println(Arrays.toString(array1));
            System.out.println(randSelect1.randomizedQuickSelect(array1, 0, array1.length - 1, 0));
            System.out.println(Arrays.toString(array1));

            System.out.println("Would you like to re-enter values to be sorted?"); // Promts user to begin loop again or terminate loop
            System.out.println("Enter yes or no.");

            String again = scan.next();

            if (again.equalsIgnoreCase("yes")) {
                loop = true;
            } else if (again.equalsIgnoreCase("no")) {
                loop = false;
                System.out.println("loop terminated, may the force be with you on your journey.");
            }

        } // While loop ends

    }

}
