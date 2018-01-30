package hw8mst;

/**
 *
 * @author Adam Whitley Nov 16 2014 CSCI 333 HW 10 Edge class, provided to
 * students.
 */
public class Edge {

    // ----- Defined Public Constants -----
    /**
     * Edge.INFINITE_WEIGHT Represents infinite edge weight. Equal in value to
     * Integer.MAX_VALUE.
     */
    public static final int INFINITE_WEIGHT = Integer.MAX_VALUE;

    // ----- Data Fields -----
    private boolean exists; // false if this edge is not part of the graph. true if it is part of the graph
    private int weight; // edge weight/cost/length as in Prim's MST algorithm

    // ----- Constructors -----
    /**
     * Constructs a new Edge of infinite weight that does not exist as part of
     * the graph. weight is set to Edge.INFINITE_WEIGHT, exists is set to false.
     */
    public Edge() {
        this.weight = INFINITE_WEIGHT;
        this.exists = false;
    }

    /**
     * Constructs an edge that exists as part of the graph, with the specified
     * weight. exists is set to true.
     *
     * @param weight The weight of the edge.
     */
    public Edge(int weight) {
        this.weight = weight;
        this.exists = true;
    }

    /**
     * Constructs a new Edge, with the specified existence boolean and specified
     * weight.
     *
     * @param exists Provide argument true if this edge should be part of the
     * graph. Provide false if not.
     * @param weight The desired edge weight for this edge
     */
    public Edge(boolean exists, int weight) {
        this.exists = exists;
        this.weight = weight;
    }

    // ----- Class Methods -----
    /* This method allows you to print an Edge object directly.
     * If the edge does not exist in the graph, it produces the string "NA".
     * If the edge exists, it produces a string of its edge weight.
     */
    @Override
    public String toString() {
        String s = "";
        if (exists) {
            s += weight;
        } else {
            s += "NA";
        }
        return s;
    }
    // ----- Getter Methods -----

    /**
     *
     * @return Returns true if this edge exists as part of the graph, and false
     * if it does not.
     */
    public boolean getExists() {
        return exists;
    }

    /**
     *
     * @return The weight of this edge.
     */
    public int getWeight() {
        return weight;
    }

    // ----- Setter Methods -----
    /**
     *
     * @param exists The boolean value for whether this edge should exist as
     * part of the graph. true for existent, false for nonexistent. Replaces the
     * old value.
     */
    public void setExists(boolean exists) {
        this.exists = exists;
    }

    /**
     *
     * @param weight The desired weight for this edge. Replaces the old weight
     * value.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
