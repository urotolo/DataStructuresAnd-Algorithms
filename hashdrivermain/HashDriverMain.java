package hashdrivermain;

/**
 *
 * @author Ulisse Rotolo
 * Date - 9/13/17
 * Professor - Dr.Whitley
 * Class - Data Structures and Algorithms 333
 * Assignment - Hashing ( Open Address and Chaining )
 * 
 * Description of functionality - This program utilizes two similar but distinct
 * hashing algorithms. Open address and Chaining. The program is structured with three classes.
 * The hashDriver class, the OpenAddressHashing algorithm class and the ChainingHashing algorithm
 * class. The driver class is used to test objects and method/functions created from the
 * other two distinct algorithm classes. The main feature of the open address Class is it deals with
 * collision using linear probing, while the chaining hashing algorithm class deals with collision using
 * Linked list in each index of a Object array. This chained hashing algorithm is probably my favorite data structure
 * thus far. I find it too be a ingenious way to deal with collision.
 * 
 * Chaining Hash works well all round from what I can tell.
 * Open address Hash works well with the exception of its search method
 * of which I ran into problems.
 * 
 */

public class HashDriverMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ChainedHashTable chainHash1 = new ChainedHashTable(25);   // Hash table sizes
        OpenAddressedHashTable openHash1 = new OpenAddressedHashTable(25);
        
        System.out.println("Empty Chain Hash Table -"); // Empty Chaining hash table
        System.out.println("");
        System.out.println("");
        chainHash1.printTable();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Filled Chained Hash Table: "); // Chaining Hash table is filled by demonstrating 
        System.out.println("");                            // insert method competency
        System.out.println("");
        
        chainHash1.insert(0);
        chainHash1.insert(1);
        chainHash1.insert(1);
        chainHash1.insert(2);
        chainHash1.insert(3);
        chainHash1.insert(5);
        chainHash1.insert(8);
        chainHash1.insert(13);
        chainHash1.insert(21);
        chainHash1.insert(34);
        chainHash1.insert(55);
        chainHash1.insert(89);
        chainHash1.insert(144);
        chainHash1.insert(233);
        chainHash1.insert(377);
        chainHash1.insert(17);
        chainHash1.insert(15);
        chainHash1.insert(111);
        chainHash1.insert(29);
        chainHash1.insert(32);
        chainHash1.insert(57);
        chainHash1.insert(89);
        chainHash1.insert(133);
        chainHash1.insert(251);
        chainHash1.insert(304);
        
        chainHash1.printTable();
        
        System.out.println("");
        System.out.println("Elements removed -");
        System.out.println("");
        
        chainHash1.delete(13);  // demonstrates functionality of delete method
        chainHash1.delete(21);
        chainHash1.delete(34);
        chainHash1.delete(55);
        chainHash1.delete(89);
        System.out.println("");
        System.out.println("Values searched for -");
        System.out.println(chainHash1.search(233)); // demonstrates functionality of search method, 
        System.out.println(chainHash1.search(21));  // the first value is found since it is located int table
        System.out.println(chainHash1.search(777)); // the second is not, being that in line "76" that value was deleted.
        System.out.println(chainHash1.search(39));
        System.out.println(chainHash1.search(304));
        System.out.println("");                     
        
        chainHash1.printTable();
        
        System.out.println("Empty Open Addressed Hash Table -"); // Empty Open Addressed hash table
        System.out.println("");
        System.out.println("");
        openHash1.printTable();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Filled Open Addressed Hash Table: "); // Fills empty open address table,
        System.out.println("");                                   // while demonstrating ability of insertion method
        
        openHash1.insert(0);
        openHash1.insert(1);
        openHash1.insert(1);
        openHash1.insert(2);
        openHash1.insert(3);
        openHash1.insert(5);
        openHash1.insert(8);
        openHash1.insert(13);
        openHash1.insert(21);
        openHash1.insert(34);
        openHash1.insert(55);
        openHash1.insert(89);
        openHash1.insert(144);
        openHash1.insert(233);
        openHash1.insert(377);
        openHash1.insert(17);
        openHash1.insert(15);
        openHash1.insert(111);
        openHash1.insert(29);
        openHash1.insert(32);
        openHash1.insert(57);
        openHash1.insert(89);
        openHash1.insert(133);
        openHash1.insert(251);
        openHash1.insert(304);
        openHash1.insert(251);
        openHash1.insert(304);
        
        openHash1.printTable();
        
        System.out.println("");
        System.out.println("Elements removed -"); // Removes a few elements to show functionality of delete method
        System.out.println("");
        
        openHash1.delete(13);
        openHash1.delete(21);
        openHash1.delete(34);
        openHash1.delete(55);
        openHash1.delete(89);
        
        System.out.println("");
        System.out.println(openHash1.search(777)); // Search method does not work properly
        System.out.println(openHash1.search(133));
        System.out.println("");
        
        openHash1.printTable();
            

        
    }
    
}
