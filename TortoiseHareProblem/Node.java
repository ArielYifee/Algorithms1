package TortoiseHareProblem;

public class Node {
    private int data;
    private Node next;

    //constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    //toString
    public String toString() {
        return "" + this.data;
    }

    //****** Getter and Setter *******
    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
