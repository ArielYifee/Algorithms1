package ParkingProblem;

public class DoubleCycleLinkedList {
    private PNode head, tail;
    private int size;

    //constructor
    public DoubleCycleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // add node
    public void add(char data) {
        if (head == null) {
            head = new PNode(data, null, null);
            tail = head;
            head.setNext(tail);
            head.setPerv(tail);
        } else {
            PNode node = new PNode(data, tail, head);
            tail.setNext(node);
            tail = node;
            head.setPerv(tail);
        }
        size++;
    }

    public PNode getHead() {
        return this.head;
    }

    public PNode getNext(PNode n) {
        return n.getNext();
    }

    public String toString() {
        String s = "[";
        if (head != null) {
            s = s + head.toString() + ", ";
            for (PNode n = head.getNext(); n != head; n = n.getNext()) {
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length() - 2);
        }
        return s + "]";
    }

    public DoubleCycleLinkedList buildLinkedList() {
        DoubleCycleLinkedList DCLL = new DoubleCycleLinkedList();
        DCLL.add('V');
        DCLL.add('B');
        DCLL.add('M');
        DCLL.add('V');
        DCLL.add('S');
        DCLL.add('A');
        DCLL.add('X');
        DCLL.add('P');
        DCLL.add('V');
        DCLL.add('T');
        System.out.println("DCLL : " + DCLL.toString());
        return DCLL;
    }
}
