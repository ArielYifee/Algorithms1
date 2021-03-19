package numberGame;

public class AdaptiveAlgorithm {
    private static int AliceResult;
    private static int BobResult;
    private static int array[];
    private static int start;
    private static int end;
    private static int OddSum;
    private static int EvenSum;

    public AdaptiveAlgorithm() {
        this.AliceResult = 0;
        this.BobResult = 0;
        this.array = buildArray();
        this.start = 0;
        this.end = array.length - 1;
        this.OddSum = 0;
        this.EvenSum = 0;
    }

    public static void gameAdaptive() {
        boolean even = true;
        if (OddSum > EvenSum) {
            even = false;
        }
        int newStart = 0;
        int newEnd = 0;
        int step = 1;
        System.out.println("****************************** THIS IS A GAME ****************");
        printArray();
        System.out.println("**************************************************************");
        while (end > start) {
            System.out.println("********************************");
            System.out.println("********** step # " + step + " ************");
            System.out.println("********************************");
            //***** First player ( Alice ) choice *****
            printArray();
            if (start > 0) {
                newEnd = end - start;
                newStart = 0;
            }
            if ((even && newStart % 2 == 0) || (!even && newStart % 2 != 0)) {
                System.out.println("ALICE: I take the first: " + array[start]);
                AliceResult = AliceResult + array[start++];
            } else {
                System.out.println("ALICE: I take the last: " + array[end]);
                AliceResult = AliceResult + array[end--];
            }
            //***** Second player ( Bob ) choice (greedy)*****
            printArray();
            if (array[start] > array[end]) {
                System.out.println("BOB : I take the first: " + array[start]);
                BobResult += array[start++];
            } else {
                System.out.println("BOB : I take the last: " + array[end]);
                BobResult += array[end--];
            }
            step++;
            System.out.println(" -------------------------");
            System.out.println(" Sum - ALICE: " + AliceResult + ", BOB: " + BobResult);
            System.out.println(" -------------------------");
            System.out.println();
            EvenSum = 0;
            OddSum = 0;
            calculateOddEvenSum();
            even = true;
            if (EvenSum < OddSum)
                even = false;
        }
        System.out.println("Congratulations! ALICE = " + AliceResult + ", BOB = " + BobResult);
    }

    //**************************************************************************
    static public void oddEvenAdaptiveAlgorithm() {
        boolean even = true;
        if (EvenSum < OddSum) {
            even = false;
        }
        int NewEnd = 0;
        int NesStart = 0;
        while (end > start) {
            //***** First player ( Alice ) choice *****
            if (start > 0) {
                NewEnd = end - start;
                NesStart = 0;
            }
            if ((even && NesStart % 2 == 0) || (!even && NesStart % 2 != 0))
                AliceResult = AliceResult + array[start++];
            else {
                AliceResult = AliceResult + array[end--];
            }
            //***** Second player ( Bob ) choice (greedy)*****
            if (array[start] > array[end])
                BobResult = BobResult + array[start++];
            else
                BobResult = BobResult + array[end--];
            EvenSum = 0;
            OddSum = 0;
            calculateOddEvenSum();
            even = true;
            if (EvenSum < OddSum)
                even = false;
        }
    }

    //**************************************************************************
    public static void main(String[] args) {
        System.out.println("\n\n");
        new AdaptiveAlgorithm();
        calculateOddEvenSum();
        gameAdaptive();
        System.out.println("\n\n*********************************************************************");
        new AdaptiveAlgorithm();
        printArray();
        calculateOddEvenSum();
        oddEvenAdaptiveAlgorithm();
        System.out.println("Alice : " + AliceResult + " Bob : " + BobResult);
    }

    //**************************************************************************
    public static void calculateOddEvenSum() {
        for (int i = start; i < end; i = i + 2) {
            EvenSum = EvenSum + array[i];
            OddSum = OddSum + array[i + 1];
        }
    }

    //**************************************************************************
    public static int[] buildArray() {
        int arr[] = {6, 9, 1, 2, 16, 12};
        return arr;
    }

    //**************************************************************************
    public static void printArray() {
        System.out.print(" Array : ");
        for (int i = start; i <= end; i++)
            System.out.print(array[i] + ", ");
        System.out.println();
    }
}
