package Divide_and_Conquer;

import java.util.ArrayList;
import java.util.Arrays;

public class Max_Min {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 8, 9, 1, 1, 3};
        System.out.println("Array : " + Arrays.toString(arr));
        int l = 0;
        int r = arr.length - 1;
        int[] result = merge(arr, l, r);
        System.out.println("Max: " + result[0] + " Min: " + result[1]);
    }

    public static int[] merge(int[] arr, int l, int r) {
        int[] result = new int[2];
        // result[0] = max;
        // result[1] = min;
        if (l == r) {
            result[0] = arr[l];
            result[1] = arr[r];
        } else if (l == r - 1) {
            if (arr[l] < arr[r]) {
                result[0] = arr[r];
                result[1] = arr[l];
            } else {
                result[0] = arr[l];
                result[1] = arr[r];
            }
        } else {
            int mid = (l + r) / 2;
            int[] leftResult = merge(arr, l, mid);
            int[] rightResult = merge(arr, mid + 1, r);
            result[0] = Math.max(leftResult[0], rightResult[0]);
            result[1] = Math.min(leftResult[1], rightResult[1]);
        }
        return result;
    }
}
