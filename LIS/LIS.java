package LIS;

import java.util.Arrays;

public class LIS { // n^2
    public static int lisSize(int[] arr) { // only size - O(nlog(n))
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if(index < 0) index = -index - 1; // fix java's results
            if(index == k) k++;
            lis[index] = arr[i];
        }
        System.out.println(Arrays.toString(lis));
        return k;
    }

    public static int[] lis(int[] arr) { // O(n^2)
        int n = arr.length;
        int[] lis = new int[n];
        int[][] mat = new int[n][n];
        lis[0] = mat[0][0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if(index < 0) index = - index - 1; // fix java's results
            if(index == k) k++;
            lis[index] = mat[index][index] = arr[i];
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index-1][j];
            }
        }
        return Arrays.copyOf(mat[k-1], k);
    }

    public static int[] LIS(int[] arr){
        int size = arr.length;
        int mat [][] = new int[size][size];
        mat [0][0] = arr[0];
        int currentLength = 0;
        for (int i=1; i<size; i++){
            int index = binarySearch(mat, currentLength, arr[i]);
            for(int j=0; j<index; j++){
                mat[index][j]=mat[index-1][j];
            }
            mat[index][index] = arr[i];
            if (index>currentLength)
                currentLength++;
        }
        int[] lis = new int[currentLength+1];
        for(int j = 0; j <= currentLength; j++)
            lis[j]=mat[currentLength][j];
        return lis;
    }
    private static int binarySearch(int a[][], int end, int key) {
        int left = 0;
        int right = end;
        int middle = 0;
        if (key < a[0][0])
            return 0;
        if (key > a[end][end])
            return end + 1;
        while (left < right - 1) {
            middle = (left + right) / 2;
            if (a[middle][middle] < key)
                left = middle;
            else
                right = middle;
        }
        return right;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,3,4,5,4};
        System.out.println(Arrays.toString(lis(arr)));
    }
}
