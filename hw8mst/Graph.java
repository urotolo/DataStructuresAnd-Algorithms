/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw8mst;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 
 */

public class Graph {

    // ----- Data Fields -----
    private int n; // Number of verticies in the graph
    private Edge [][] edgeArray; // A 2D array of Edge with size n-by-n, to store an adjacency matrix of Edge objects
    private Vertex[] vertices; // DO NOT rename me without Refactor --> Rename, or you'll break decreaseKey.
    // You need to declare the other data fields, too!
    // You need to define all the constructor(s) and other class methods, too!

    /**
     * 
     * @param edgeMatrix - Constructor for graph class, this parameter takes in
     * a two dimensional array of edge type, does a soft copy to the instance variable
     * edgeArray.
     * Instantiates the vertices array so all undiscovered(In this case all since none have been discovered yet)
     * weights are set too infinity.
     */
    Graph(Edge[][] edgeMatrix) 
    {
        
        edgeArray = edgeMatrix;
        n = edgeMatrix.length;
        vertices = new Vertex[n];
        for(int i = 0; i < n; ++i)
        {
            vertices[i] = new Vertex(i, Edge.INFINITE_WEIGHT); // label plus intial vertex vertex weight before state of
        }                                                      // adjacency and later state of discovery.
        
    }
    
    

    /**
     * 
     * @return - The size of the vertices in graph 
     */
    public int getN()
    {
        return n;
    }
    
    
    /**
     * 
     * @param i - Chosen vertex to search for
     * @return - Returns that chosen vertex
     */
    public Vertex getCurrentVertex(int i) 
    {
        return vertices[i]; // Public getter for specified vertex in within vertex array
    }

    
    /**
     * Since the Edges are stored in a two D array, you find values
     * with coordinates as you would in say a calculus class.
     * @param x - Row coordinate
     * @param y - Column coordinate
     * @return - Returns chosen edge.
     */
    public Edge[][] getCurrentEdge(int x, int y)
    {
        return edgeArray;
    }
    
    
    /**
     * Simply prints the graph in table format.
     */
    public void printGraph() 
    {
        System.out.println(Arrays.deepToString(edgeArray).replace("], ", "]\n"));
    }
     
     /**
      * Prints vertices in vertex array and adds up the key values
      * while in the process, the added up values equal the minimum weight for the tree.
      * It is important the method primMst is ran before using this method else the value
      * given by count will not be the MST value.
      */
     public void printMinimumSpanningTreeValue()
     {
         int count=0;
         for(int i = 0; i < vertices.length; ++i)
         {
             System.out.println(vertices[i]+" ");
             count = count + vertices[i].getKey();
         }
         System.out.println("");
         System.out.println("Minimun Spanning tree value: " + count); // May print a negative number, which means infinity
     }
    
     
    /**
     * Starts with arbitrary source value, source equals vertices[0], then runs a for loop that
     * sets the key value for each vertex to Infinity and each parent value too null.
     * Instantiates a priorityQueue data structure of vertex type to run Prim.
     * Runs a while loop while Q is not empty, checks if label exist and is still in Q
     * and makes sure weight is the next smallest keyed vertex.
     * The result is the vertices array stores the correct MST sequence, this sequence
     * is then printed in the main and the values are added up equaling the MST value.
     */
    public void primMst()
    {
        Vertex source = vertices[0]; // The source vertex
        
        for(int i =0; i < vertices.length; ++i)
        {
            vertices[i].setKey(Edge.INFINITE_WEIGHT);
            vertices[i].setParent(null);
        }
        
        source.setKey(0);
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        
        Q.addAll(Arrays.asList(vertices));  // Adds vertices to the Q
        
        while(!Q.isEmpty())
        {
            source = Q.poll();
            for(int i = 0; i < vertices.length; ++i)
            {
              while(edgeArray[source.getLabel()][i].getExists() && isStillInQ(Q,vertices[i].getLabel()) && edgeArray[source.getLabel()][i].getWeight() < vertices[i].getKey())
              {
                  vertices[i].setParent(source);
                  decreaseKey(Q, vertices[i].getLabel(), edgeArray[source.getLabel()][i].getWeight());
              }
            }
        }
    }
    
        // ----- Private Helper Methods -----
    /**
     * Tells you whether a Vertex with the provided label is still in the queue
     * q. This is needed because, since the PriorityQueue is keyed on key not
     * label, it will tell you whether a given key is still in it, but not
     * whether a given label is still in it.
     *
     * @param q a PriorityQueue<Vertex>
     * @param label The Vertex label to check for.
     * @return Returns true if a Vertex with matching label is in q. Returns
     * false if no Vertex with matching label is in q.
     */
    private boolean isStillInQ(PriorityQueue<Vertex> q, int label) {

        Vertex[] array = q.toArray(new Vertex[0]); // dump out an array of the elements

        // traverse the array of elements, searching for a matching label
        for (int i = 0; i < array.length; i++) {
            if ((array[i]).getLabel() == label) {
                return true;
            }
        }

        return false; // no matching label found

    }

    /**
     * Takes the Vertex with matching label in queue q, and reduces its key to
     * newKey. Will return false if Vertex is not in the queue, or newKey is
     * larger than old key. Will return true if it successfully reduced the key.
     *
     * @param q The priority queue of Vertex
     * @param label The label of the Vertex whose key you want to decrease
     * @param newKey
     * @return Returns false if the Vertex with the given label is not in the
     * queue. Returns false if the newKey is larger than the old key of Vertex
     * with given label. Returns true otherwise; the vertex with the given label
     * had its key changed to newKey.
     */
    private boolean decreaseKey(PriorityQueue<Vertex> q, int label, int newKey) {
        // PAY NO ATTENTION TO THE CODE BEHIND THAT CURTAIN! ;)
        // Don't worry about the code in this method body. Read the Javadoc above.

        int indexOfVertex = -1;
        Vertex[] array = q.toArray(new Vertex[0]);

        // check to see if Vertex with the given label is in the Priority queue.
        for (int i = 0; i < array.length; i++) {
            if ((array[i]).getLabel() == label) {
                indexOfVertex = i;
            }
        }

        // if Vertex with the given label is not in the queue, do nothing and return false
        // also returns false if the new key is larger than the old key.
        if (indexOfVertex == -1 || newKey > array[indexOfVertex].getKey()) {
            return false;
        }

        // Without decreaseKey already in the PriorityQueue class,
        // I must remove the vertex and add it again with a different key. 
        // Actually, I'm emptying the queue, then I am inserting all the other
        // vertices back in, except the one being decreased. Then I am reinserting
        // the decreased vertex, with the newKey key value.
        // I had to resort to this because technically you can't remove 
        // an element from a PriorityQueue by its label, since it is keyed on something else.
        Vertex vertexToDecrease = array[indexOfVertex];
        vertexToDecrease.setKey(newKey);

        // clear and rebuild the priority queue
        q.clear();
        for (int i = 0; i < array.length; i++) { // add everything else
            if (i != indexOfVertex) { // not including the old vertex to be reduced
                q.add(array[i]);
            }
        }
        q.add(vertexToDecrease); // insert the decreased vertex back in

        return true; // queue is now effectively identical to before, but with one Vertex's key reduced to newKey
    }
}
