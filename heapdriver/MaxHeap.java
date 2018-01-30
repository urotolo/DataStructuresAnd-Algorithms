
package heapdriver;

import java.util.Arrays;

/**
 *
 * @author paradigmshift
 */
public class MaxHeap {
    
    protected int heapArray[]; // used to store heap at all times
    protected int heapSize; // Equal to heapSize.length-1
    
    
    
    
    public MaxHeap(int [] arbitraryValues)
    {
        
        heapSize = arbitraryValues.length;
        heapArray = new int [heapSize];
        
        heapArray = Arrays.copyOfRange(arbitraryValues, 0, arbitraryValues.length);
        
        buildMaxHeap();
    }
    
    
    
    
    
    protected int parentOf(int index)
    {
     
        
        return (index-1)/2;
    }
    
    
    
    
    protected int leftChildOf(int index)
    {
        
        return 2*index+1;
    }
    
    
    
    
    protected int rightChildOf(int index)
    {
        
        return 2*index+2;
    }
    
    
    
    public void printMaxHeap()
    {
        
        System.out.println(Arrays.toString(heapArray));
        
    }
    
    
    
    
    protected void maxHeapify( int index )
    {
        int left = 2*index+1;  //index of the left child
        int right = 2*index+2; // index of the right child
        int largest = index;
        int tmp;
        
        if ( left < heapSize && heapArray[left] > heapArray[index]) //
              largest = left;
         else 
            largest = index;
        
        
        if ( right < heapSize && heapArray[right] > heapArray[largest])  //
            largest = right;
        
        if ( largest != index) {
            
            tmp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = tmp;
            maxHeapify(largest);
        }
        
    }
    
    
    
    
    private void buildMaxHeap()
    {
        
        for(int i = heapSize/2-1; i >= 0; --i){ //
            
            maxHeapify(i);
            
        }
    }
    
    
    
    
    public void heapSort()
    {
        buildMaxHeap();
        int backUpCopy = heapArray[heapSize]; // Save a copy of heapSize for later
        
        for(int i = heapArray[heapSize]; i > 2;i--){
            
            int tmp = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = tmp;
            
            heapArray[heapSize]--;
            maxHeapify(1);
        }
        
        heapArray[heapSize] = backUpCopy;
    }
}