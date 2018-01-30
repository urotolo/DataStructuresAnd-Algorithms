/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramandselectsort;

import java.util.Random;

/**
 *
 * @author paradigmshift
 */
public class RandomizedQuickSelect {
    
    int pivot, i, tmp;
    Random rand = new Random();
    
    
    
    /**
     * 
     * @param inputArray - Array of unsorted values created by for loop in driver class that
     * randomizes elements in array up to n. Sent in as a parameter from the user, 
     * then into the object declaration and then here into the randomizedQuickSelect method header.
     * @param startBound - Serves as the lowBound for each broken down sub-array.
     * @param endBound - Serves as the highBound for each broken down sub-array.
     * @param orderStatistic -
     * @return - Breaks down array into subproblems using recursion, until base case is reached.
     * 
     * 0(n^2) time - worst case
     * 0(n) time - best case
     */
    public int randomizedQuickSelect(int [] inputArray, int startBound, int endBound, int orderStatistic)
    {
        
        if (startBound == endBound) // base case
            return inputArray[startBound];
        int randomElement = startBound + rand.nextInt(endBound - startBound); 
        
        tmp = inputArray[endBound];
        inputArray[endBound] = inputArray[randomElement]; // swap endBound with random element
        inputArray[randomElement] = tmp;
                    
        pivot = partition(inputArray, startBound, endBound);  
        int k = pivot - startBound+1; // calculate order statistic k of the pivot
        if(orderStatistic == k) // Check if pivot is the ith order statistic
        {
            return inputArray[pivot];
        }
        else if (orderStatistic < k) // Then instead still looking for an earlier order statistic
        {
            return randomizedQuickSelect(inputArray, startBound,  pivot-1, orderStatistic);
        }
        else return randomizedQuickSelect(inputArray, pivot+1, endBound, orderStatistic-k);

    }
    
    /**
     * 
     * @param dataArray - Array passed into method from randomizedQuickSelect method
     * @param lowBound - The lowest bound of the passed in array 
     * @param highBound - The highest bound of the passed in array
     * @return - Returns the value representing where to pivot to the randomizedQuickSort method in order to pivot the next set of arrays
     */
    
    protected int partition(int [] dataArray, int lowBound, int highBound) // defined abstract method
    {
         
        pivot = dataArray[highBound]; // The Value pivot is called the pivot value, chosen at index highbound
        i = lowBound - 1;
        
        for(int j = lowBound; j <= highBound - 1; j++)  //// j is loop variable. Iterate through subarray .
        {
            if (dataArray[j] <= pivot) // we find a "small" value less than the pivot x
            {
                i = i + 1;
                
                tmp = dataArray[i];
                dataArray[i] = dataArray[j]; // The "small element goes left
                dataArray[j] = tmp;                
            }
            
            
        }
        tmp = dataArray[i+1];
        dataArray[i+1] = dataArray[highBound]; // put pivot between left and right sides
        dataArray[highBound] = tmp;
           
        return i + 1; // This is the index pivot in quickSort
        
        
    }
}
