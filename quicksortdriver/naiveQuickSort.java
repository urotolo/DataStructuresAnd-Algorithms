/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortdriver;

/**
 *
 * @author paradigmshift
 */
public class naiveQuickSort {
    
  //  private int [] data;
    private int p, r;
    
    
   // naiveQuickSort(){
        
        //data = passedInArray;
        //p = 1;
        //r = passedInArray.length;
        
   // }
    
    
    public void quickSort(int [] dataArray, int p, int r){
        
        int q;
        p = 1;
        r = dataArray.length;
        
        if (p < r) {     // base case is the implied empty else case
        
            q = partition(dataArray, p, r); // split 2 subproblems at q
            quickSort(dataArray, p, q-1);
            quickSort(dataArray, q+1, r);
            
        }
    }
    
    
    
    private int partition(int [] dataArray, int p, int r){
        
        int x = dataArray[r]; // The Value  x is called the pivot value, chosen at index r
        int i = p - 1;
        
        for(int j = p; j <= r - 1; j++)  //// j is loop variable. Iterate through subarray .
        {       
            
            if (dataArray[j] <= x) // we find a "small" value less than the pivot x
            {
                i = i + 1;
                
                int tmp = dataArray[i];
                dataArray[i] = dataArray[j]; // The "small element goes left
                dataArray[j] = tmp;
                
                tmp = dataArray[i+1];
                dataArray[i+1] = dataArray[r]; // put pivot between left and right sides
                dataArray[r] = tmp;
                
                return i + 1; // This is the index q in quickSort
                
            }
            
        }
        return 0;
        
        
    }
    
}
