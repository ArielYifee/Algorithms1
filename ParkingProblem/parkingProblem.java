package ParkingProblem;

public class parkingProblem {
    private static DoubleCycleLinkedList parking = new DoubleCycleLinkedList();
    private static PNode currPNode;
    private static boolean flag;
    private static int counter;
    private static char oldSing, newSing;
    private static int steps;

    //constructor
    public parkingProblem() {
        parking = parking.buildLinkedList();
        currPNode = parking.getHead().getNext();
        flag = true;
        counter = 1;
        oldSing = 'V';
        newSing = 'W';
    }

    public static int calcCars() {
        while (flag) { // main loop start
            if (currPNode.getData() != oldSing) { // check if the current node has the same data as the head
                currPNode = currPNode.getNext();
                counter++;
            } else {
                currPNode.setData(newSing); // change nodes data
                steps = counter;
                while (steps > 0) { // go back to the head
                    currPNode = currPNode.getPerv();
                    steps--;
                }
                if (currPNode.getData() == newSing) { // if head's data is newSing its mean that we done a complete cycle
                    flag = false;
                } else { // start the loop again
                    counter = 1;
                    currPNode = parking.getHead().getNext();
                }
            }
        } // main loop end
        return counter;
    }

    public static int calcCarsPointers() {
        int result = 1;
        PNode PNodeForward = parking.getHead().getNext();
        PNode headPNode = parking.getHead();
        while (PNodeForward != headPNode) {
            PNodeForward = PNodeForward.getNext();
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        new parkingProblem();
        System.out.println("number of cars = " +
                parkingProblem.calcCars());
        System.out.println("DCLL : " +
                parkingProblem.parking.toString());
//**************************************************
        System.out.println();
        System.out.println("number of cars = " +
                parkingProblem.calcCarsPointers());
    }
}