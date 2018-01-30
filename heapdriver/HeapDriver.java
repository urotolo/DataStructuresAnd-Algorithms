/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapdriver;
import java.lang.Math;
/**
 *
 * @author Ulisse Rotolo
 *  Could not get code to run properly.
 */
public class HeapDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        int [] values1 = {10, 45, 67, 64, 35, 44, 22, 76, 89, 654, 76};
        
      /**  for(int i = 0; values1.length-1 > i; i++){
            
            values1[i] = (int) (Math.random()*3)+10;
            
        }    */
        
        
        MaxHeap heap1 = new MaxHeap(values1);
        heap1.printMaxHeap();
        heap1.printMaxHeap();
    }
    
}
