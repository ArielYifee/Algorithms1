package TortoiseHareProblem;

public class CircleLinkedList {
    private  Node head;
    private Node tail;
    private  int size;

    //constructor
    public CircleLinkedList() {
        this.head = null;
        this.tail = null;
        size =0;
    }

    public Node getHead() {
        return this.head;
    }

    public void add(int n){
        if (this.head == null){
            this.head = new Node(n);
            this.tail = this.head;
        }else {
            Node oldTail = this.tail;
            Node r = head.getNext();
            this.tail = new Node(n);
            oldTail.setNext(this.tail);
            Node s = oldTail.getNext();
        }
        this.size++;
    }

    public void addLoop(int index){
        Node current = this.head;
        while (current.getData() != index){
            if(current.getNext() == null)
                return;
            current = current.getNext();
        }
        this.tail.setNext(current);
    }
    public String toString() {
        Node current = this.head;
        String result =
                "";
        int count = 0;
        while(current != null) {
            result += "[" + current.getData() + "]";
            current = current.getNext();
            count++;
            if (count % 10 == 0 || count % 16 == 0)
                result = result + " ";
            if (count == 20) // maybe linked list has a loop
                break;
        }
        return result;
    }
    public int getSize(){
        return this.size;
    }

}
