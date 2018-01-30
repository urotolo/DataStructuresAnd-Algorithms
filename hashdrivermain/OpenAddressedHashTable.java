package hashdrivermain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author paradigmshift
 */
public class OpenAddressedHashTable {
    
    private int size; // serves as m, this name is more intuitive to me
    private double goldenRatio = 0.6180339887; // serves as A
    private Integer [] table; // array size
    // private static int DELETED = Integer.MIN_VALUE;
    
    
    
    /**
     * // Constructor
     * 
     * @param int n - Is taken in by the method header and is used 
     * to dictate the size of the array of object Integer type "table".
     */
    
    OpenAddressedHashTable(int n) // Constructor
    {
        size = 1;
        while( size <= n)
        {
            size += size*2; // sets size(more commonly called m) variable to the
        }                   // first power of 2 greater then n
        
        table = new Integer [size];
    }
    
    
    
    /**
     * // void type
     * 
     * @param Integer x - Value to insert into table.
     * The variable Integer x is passed in to 
     * the insert function declared here. This is where the linear
     * probing concept takes place to deal with collision. 
     * The entire array table (cannot avoid 0(n) time, because whether
     * it is linkedList or array table, a linear traversal must occur)
     * is traversed. The function then finds, if available, the next open
     * slot and then inserts the variable there.
     */
    
    public void insert(Integer x)
    {
        for(int i = 0; i < size; ++i)
        {
            if(table[hash(i)] == null) //check may actually be -1 instead of null
            {
                table[hash(i)] = x;
                break;
            }
        }
    }
    
    
    
    /**
     * // void type
     * 
     * @param x - Value to delete from table.
     * Traverses the entire table array, searches 
     * to find a match for the value that is of desire to 
     * delete, if match found delete, else next index.
     */
    
    public void delete(Integer x)
    {
        for(int i = 0; i < size; ++i)
        {
            if(table[hash(i)] == x) //check may actually be null instead of -1
            {
                table[hash(i)] = null;
            }
                
        }
        
        System.out.println("Integer " + x + " not found in table. ");
    }
    
    
    
    /**
     * // Object type
     * 
     * @param x - Value searched for.
     * Traverses the entire table for a 
     * match that is equivalent to the 
     * parameter header value. .
     * @return  If found,
     * return value, else return null.
     */
    
    public Integer search(Integer x)
    {
        for(int i = 0; i < size; ++i)
        {
            if(table[hash(i)] == x) //check may actually be null instead of -1
            {
                ArrayList<Integer> toList = new ArrayList<Integer>();
                toList.add(table[hash(i)].intValue());
                return toList.get(0);
            }
            break;
                
            
        }
        return null; // not found
    }
    
    
    
    /**
     * 
     * @param key - value inserted that
     * is then calculated to equal the correct index
     * in the array.
     * @return - Proper array table index.
     */
    
    private int hash(int key)
    {
    
        double d = size * ((key * goldenRatio)%1);
        return (int) d;
    }
    
    
    
    /**
    private int hash(int key, int index) // Assuming I did this correctly, (there is a good chance 
    {                                    // I didnt) I eliminated the need for this method. 
    *                                    // By calling my original hash function for my search, delete
    *                                    // and insertion method in specific places within those respective
    *                                    // functions, it seems the result is logically equivalent to if I
    *                                    // I had used this method to declare variable J as the hash index locater.
    *                                    //

        return (int) ((hash(key) + index)%size);
    }
    */
    
    
    
    /**
     * Simply prints the values within the array table.
     */
    
    public void printTable()
    {
        int indexCounter = 0;
        for(int i = 0; i < size; ++i)
        {
            System.out.println("Index " + indexCounter + ":"
            + table[i]);
            indexCounter++;
                
        }
        
        
    }
    
    
    
    
    
    
    
    
}
