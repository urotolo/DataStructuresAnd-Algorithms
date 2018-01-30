package hw8mst;

/**
 *
 * @author Adam Whitley Nov 16 2014 CSCI 333 HW 10 Vertex class, provided to
 * students.
 */
public class Vertex implements Comparable<Vertex>, java.util.Comparator<Vertex> {

    // ----- Data Fields -----
    private final int label; // immutable data field for the label or "name" of the vertex
    private int key; // the Prim's MST key of this vertex
    private Vertex parent; // handle to the parent Vertex

    // ----- Class Methods -----
    public Vertex(int label, int key) {
        parent = null;
        this.label = label;
        this.key = key;
    }

    // ----- Interface Methods -----
    // Don't even worry about these. They're necessary for the PriorityQueue
    // machinery in the Java Standard Library to work property with Vertex.
    // Have a look at toString if you want, to see what a Vertex would
    // "look like" when converted to a String for printing.
    @Override
    public int compareTo(Vertex other) {
        return Integer.compare(this.key, other.key); // compare their keys
    }

    @Override
    public int compare(Vertex o1, Vertex o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Vertex && ((Vertex) obj).key == this.key);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.key;
        return hash;
    }

    /* This toString method allows you to print a Vertex object directly.
     * It will generate an informative string for the print statement you use it in.
     * For example, if you had a Vertex object named f, you could simply say:
     * System.out.println(f);
     * and you can expect a nicely formatted output of the status of the Vertex f.
     */
    @Override
    public String toString() {
        String s = "";
        s += "Vertex " + label + ".";
        s += " Key: " + key + ".";

        s += " Parent's label: ";
        if (parent == null) {
            s += "null.";
        } else {
            s += "" + parent.label + ".";
        }

        return s;
    }

    // ----- Getter Methods -----
    /**
     *
     * @return Key of this vertex, according to Prim's MST algorithm.
     */
    public int getKey() {
        return key;
    }

    /**
     *
     * @return Parent of this vertex in the tree.
     */
    public Vertex getParent() { // may return null, beware!
        return parent;
    }

    /**
     *
     * @return Label (the immutable name) of this vertex.
     */
    public int getLabel() {
        return label;
    }

    /**
     *
     * @param parent Vertex handle to desired parent Vertex for this Vertex. You
     * may provide a null Vertex handle, indicating this vertex has no parent.
     */
    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    /**
     *
     * @param key Desired int value key for this vertex, in Prim's MST
     * algorithm. Replaces the old key.
     */
    public void setKey(int key) {
        this.key = key;
    }

}
