package Greedy;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,2,8,0};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quicksort(int[] arr, int l, int r){
        if(l<r){
            int p = partition(arr,l,r);
            quicksort(arr,l,p);
            quicksort(arr,p+1,r);
        }
    }
    public static int partition(int[] arr, int l,int r){
        int pivot = arr[l];
        int i=l,j=r;
        while (i<j) {
            while (i<j && arr[i] <= pivot)
                ++i;
            while (i<=j && arr[j] > pivot)
                --j;
            if (i < j) {
                // swap : i - j :
                swap(arr, i, j);
            }
        }
        // swap : pivot - j :
        swap(arr,l,j);
        return j;
    }
    public static void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
