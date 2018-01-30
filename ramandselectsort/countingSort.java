
package ramandselectsort;

import java.util.Arrays;

/**
 *
 * @author paradigmshift
 */
public class countingSort {
    
    
    
    
    
    /**
     * 
     * @param unSortedData - randomized set of values passed in by user in the form of array data structure
     * @param memoryArray - Array used for storing the sorted output
     * @param highestValue - Highest value in array
     */
    
    public void countingSort(int [] unSortedData, int [] memoryArray, int highestValue)
    {
        int [] c = new int [highestValue+1]; // named C, indices 0 to highestValue, length highestValue+1
        
        for(int i = 0; i <= highestValue; i++ ) // Step 0: initialize array c to all 0's || Note to self > ( possibly turn < into <= )
        {
            c[i] = 0;
        }
        
        for(int i = 0; i < unSortedData.length; i++) // Step 1: count occurences of each input value ||  Note to self > ( possibly turn < into <= )
        {
            c[unSortedData[i]]++; // So, each c[i] tallies # inpit values == i
        }
        
        for(int i = 1; i < highestValue+1; i++) // Step 2: each c[i] will tally # input values <= i || Note to self > ( possibly turn < into <= )
        {
            c[i] = c[i] + c[i-1];
        }
        
        for(int i = unSortedData.length-1; i >= 0; --i) // Step 3: scan back through unSortedData, writing memoryAllocatedArray
        {
            memoryArray[c[unSortedData[i]] - 1] = unSortedData[i];
            c[unSortedData[i]]--;
        }
        
        System.out.println(Arrays.toString(memoryArray));
        
    }
    
    
    
    
}
