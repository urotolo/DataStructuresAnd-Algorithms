package hw8mst;


/**
 * @author - Ulisse Rotolo
 * Professor - Dr.Whitley
 * Class - Data Structures and Algorithms 333
 * Date - 11/20/17
 * Homework - Minimum Spanning tree
 * 
 * Summary - This program has 4 classes. A main MST driver class to test the graph objects.
 * A graph class that has a void method that builds Prim's algorithm. As well as helper methods
 * for that whole process. Another method to print the graph that was originally built in the main class
 * and another to print the Minimum spanning tree value after Prim's method has been run.
 * A edge class that defines the bridge between two vertices that holds infinity if undiscovered else 
 * holds a set value which prim will iterate through choosing the path of least resistance as is fashionable for
 * greedy algorithms. Then a vertex class which defines each vertex that is connected by an edge. Below I have created
 * a 8 by 8 graph that is tested. Runs successfully, the correct minimum value is returned.
 */

public class HW8MST {

    public static void main(String[] args) {
        
        Edge [][] edgeMatrix1 = // Initializes weighted Graph
        {
            {new Edge(), new Edge(12), new Edge(2), new Edge(10), new Edge(), new Edge(13), new Edge(), new Edge()},    
            {new Edge(12), new Edge(), new Edge(), new Edge(), new Edge(7), new Edge(11), new Edge(), new Edge()},    
            {new Edge(2), new Edge(), new Edge(), new Edge(14), new Edge(), new Edge(3), new Edge(), new Edge()},    
            {new Edge(10), new Edge(), new Edge(14), new Edge(), new Edge(), new Edge(6), new Edge(), new Edge(5)},    
            {new Edge(), new Edge(7), new Edge(), new Edge(), new Edge(), new Edge(4), new Edge(8), new Edge(16)},    
            {new Edge(13), new Edge(11), new Edge(3), new Edge(6), new Edge(4), new Edge(), new Edge(), new Edge(15)},    
            {new Edge(), new Edge(), new Edge(), new Edge(), new Edge(8), new Edge(), new Edge(), new Edge(9)},    
            {new Edge(), new Edge(), new Edge(), new Edge(5), new Edge(16), new Edge(15), new Edge(9), new Edge()},    
        };
        
        Graph graphMatrix1 = new Graph(edgeMatrix1); // Creats graph object which will run Prim's algorithm
        System.out.println("");
        System.out.println("Before Prim's algorithmic wrath:");
        System.out.println("");
        graphMatrix1.printGraph();
        System.out.println("");
        graphMatrix1.printMinimumSpanningTreeValue();
        graphMatrix1.primMst();
        System.out.println("");
        System.out.println("After lord Prim cast his algorithmic spell upon graphland: ");
        System.out.println("");
        graphMatrix1.printGraph();
        System.out.println("");
        graphMatrix1.printMinimumSpanningTreeValue();
        System.out.println("");
        
    }
}
