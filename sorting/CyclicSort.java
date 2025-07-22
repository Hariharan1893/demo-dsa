package sorting;

import java.util.Arrays;

// Cycle sort is an in place unstable algorithm
// when given no. from range 1 to n -> use cycle sort
// Time Complexity - O(n)
// worst case it took n - 1 swaps
public class CyclicSort {

    static void cSort(int[] arr) {

        int i = 0;

        while (i < arr.length) {
            int correctInd = arr[i] - 1;

            if (arr[i] != arr[correctInd]) {
                swap(arr, i, correctInd);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 3, 6, 2, 4, 5, 1 };

        cSort(unsorted);

        System.out.println(Arrays.toString(unsorted));

    }
}
