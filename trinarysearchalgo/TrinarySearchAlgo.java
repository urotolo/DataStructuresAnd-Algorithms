/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinarysearchalgo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author paradigmshift
 */
public class TrinarySearchAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner Scan = new Scanner(System.in);
        
        int n, value;
        System.out.println("Enter size of array -");
        n = Scan.nextInt();
        System.out.println("Enter value to search for -");
        value = Scan.nextInt();
        
        int [] array1 = new int [n];

        for(int i = 0; i < array1.length-1;i++)
        {
            
            
            array1[i]= (int) (Math.random()*1000)+10;
            
            
        }
        
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println();
        
        int indexWithValue = trinaryAlgoBuilder.trinaryAlgoBuilder(array1, value);
        
        System.out.println(indexWithValue);
    }
    
}
