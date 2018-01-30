package hashdrivermain;
import java.util.LinkedList;

/**
 *
 * @author paradigmshift
 */
public class ChainedHashTable {
    
    private int size; // serves as m
    private double goldenRatio = 0.6180339887; // serves as A
    private LinkedList<Integer>[] table;
    
    
    
    /**
     * // Constructor
     * 
     * @param int n - Is taken in by the method header and is used 
     * to dictate the size of the array of object Integer type "table".
     *
     */
    
    ChainedHashTable(int n)
    {
        size = 1;
        while( size <= n)
        {
            
            size += size*2;
            
        }
        table = new LinkedList[size];
        
        for(int i = 0; i < size; ++i)
        {
            table[i] = new LinkedList();
        }
        
        //hashMap = new Integer[size];
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
     * 
     * @param x - Value to be inserted.
     * Uses the hash call to find proper index,
     * then dynamically adds the value into the respective
     * linkedList in the respective index the key
     * is hashed to.
     * 
     */
    
    public void insert(Integer x)
    {
        table[hash(x)].offerFirst(x);
    }
    
    
    
    /**
     * 
     * @param x - Value to be deleted from hash table.
     * Uses inbuilt list library call .contains
     * to see if value is existent within hash table.
     * Then proceeds to remove that value if value is
     * existent, else states value is not located in this
     * hash table.
     */
    
    public void delete(Integer x)
    {
        if(table[hash(x)].contains(x))
        {
            table[hash(x)].remove(x);
            System.out.println("Integer element " + x + " has been removed from the "
                    + "table.");
        }
        
        else if(!table[hash(x)].contains(x))
        {
            System.out.println("Integer element " + x + " was not found in the table.");
        }
    }
    
    
    
    /**
     * 
     * @param x - Value to be searched for.
     * Arithmetical hash function call is used
     * to find value of index location in 0(n) constant time.
     * @return If value found return value, else 
     * return null.
     */
    
    public Integer search(Integer x)
    {
        if(table[hash(x)].indexOf(x) == -1)
            return null;
        else
            return table[hash(x)].get(table[hash(x)].indexOf(x) );
    }
    
    
    
    /**
     * This method simple prints the content within the table to console.
     * Prints the various linkedList declared within table.
     * 
     */
    
    public void printTable()
    {
        int indexCount = 0;
        for(int i = 0; i < size; ++i)
        {
            System.out.println("Index count " + indexCount + ": "
            + table[i]);
            System.out.println("");
            indexCount++;
        }
    }
    
    
    
    
}
