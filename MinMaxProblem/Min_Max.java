package MinMaxProblem;

import java.util.ArrayList;
import java.util.Collections;

public class Min_Max {
    public static void main(String[] args) {
        int a[] = BuildArray.buildRandomArray();
        int aInc[] = BuildArray.buildSortIncreasingArray();
        int aDec[] = BuildArray.buildSortDecreasingArray();
        System.out.println("\n********** Pairs comparison Random Array **********");
        int comp1 = Pair(a);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Pairs comparison Increasing Array **********");
        comp1 = Pair(aInc);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Pairs comparison Decreasing Array **********");
        comp1 = Pair(aDec);
        System.out.println("comp1 = " + comp1);
    }

    public static int Pair(int[] arr) {
        int comparisons = 1;
        int max, min;
        int indexMax, indexMin;

        //sets the first min and max
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
            indexMax = 0;
            indexMin = 1;
        } else {
            max = arr[1];
            min = arr[0];
            indexMax = 1;
            indexMin = 0;
        }

        for (int i = 2; i < arr.length - 1; i = i + 2) { //go through the array and compare all the indexes
            comparisons++;
            if (arr[i] < arr[i + 1]) {
                comparisons += 2;// we check the min and max
                if (arr[i] < min) {
                    min = arr[i];
                    indexMin = i;
                }
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                    indexMax = i;
                }
            } else {
                comparisons = +2;
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                    indexMin = i;
                }
                if (arr[i] > max) {
                    max = arr[i];
                    indexMax = i;
                }
            }
        }
        // number of array's elements is odd termination
        if (arr.length % 2 != 0) {
            comparisons++;
            if (arr[arr.length - 1] > max) {
                max = arr[arr.length - 1];
                indexMax = arr.length - 1;
            } else {
                comparisons++;
                if (arr[arr.length - 1] < min) {
                    min = arr[arr.length - 1];
                    indexMin = arr.length - 1;
                }
            }
        }
        System.out.println("max = " + max + " indexMax = " + indexMax + " min = " + min +
                " indexMin = " + indexMin);
        return comparisons;
    }

    public static class BuildArray {
        public static int[] buildRandomArray() {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < 1000000; i++)
                numbers.add(i + 1);
            Collections.shuffle(numbers);

            int[] arr = new int[1000000];
            for (int i = 0; i < 1000000; i++)
                arr[i] = numbers.get(i).intValue();

            return arr;
        }

        //******************************************************
        public static int[] buildSortIncreasingArray() {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < 1000000; i++)
                numbers.add(i + 1);

            int[] arr = new int[1000000];
            for (int i = 0; i < 1000000; i++)
                arr[i] = numbers.get(i).intValue();

            return arr;
        }

        //******************************************************
        public static int[] buildSortDecreasingArray() {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < 1000000; i++)
                numbers.add(1000000 - i);

            int[] arr = new int[1000000];
            for (int i = 0; i < 1000000; i++)
                arr[i] = numbers.get(i).intValue();

            return arr;
        }
    }
}
