/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinarysearchalgo;

/**
 *
 * @author paradigmshift
 */
public class trinaryAlgoBuilder {
    
    public static int trinaryAlgoBuilder(int [] n, int value)
    {
        return trinarySearch(n, 0, n.length-1, value);
    }
    
    
    public static int trinarySearch(int [] n, int startBound, int endBound, int value)
    {
        
           if(endBound - startBound > 0){
        
        int midPoint1 = startBound + (endBound-startBound)/3;
        int midPoint2 = midPoint1 + (endBound-startBound)/3;
        
     
           // return -1;
        
            if(n[midPoint1] == value)
            {
                return midPoint1;
            }
        
            else if(n[midPoint2] == value)
            {
                return midPoint2;
            }
            else if(n[midPoint1] > value) // first 1/3
            {
                return trinarySearch(n, startBound, midPoint1, value );
            }
                    
            else if(n[midPoint2] < value) // last 3/3
            {
                return trinarySearch(n, midPoint2+1, endBound, value );
            }
        
             // middle 2/3
            
            return trinarySearch(n, midPoint1, midPoint2, value); // could be problem here
            
        
        } else {
               return -1;
           }
        
  }
    
    
}
