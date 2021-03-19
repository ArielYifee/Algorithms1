package MergeSort;

public class MergeSort {
    private static void MergeSort(int[] arr) {
        MergeSort(arr,0,arr.length-1);
    }

    private static void MergeSort(int[] arr, int start, int end){
        if(start < end) {
            int middle = (start+end)/2;
            MergeSort(arr,start,middle);
            MergeSort(arr,middle+1,end);
            Merge(arr,start,middle,end);
        }
    }
    // Merge sort
    private static void Merge(int[] arr, int start, int middle, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0; // The Running Pointer
        while( i <= middle && j <= end){
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while( i <= middle)
            temp[k++] = arr[i++];

        while( j <= end)
            temp[k++] = arr[j++];

        // Copy The array
        i = start;
        k = 0;
        while( k < temp.length && i <= end){
            arr[i++] = temp[k++];
        }
    }

}
