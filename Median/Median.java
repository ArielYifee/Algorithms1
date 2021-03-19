package Median;

import java.util.Arrays;

public class Median {
    public static int Median(int[] arr){
        int sum = Math.min(64, arr.length/2+1);
        int ans = 0;
        for (int i = 0; i < sum; i++) {
            if (arr[i] > ans){
                ans = arr[i];
            }
        }
        return ans;
    }

    public static void main(String [] args){
        int[] arr = {1,5,40,10,20,32,34,100,122,11,313};
        System.out.println(Median(arr));
    }
}
