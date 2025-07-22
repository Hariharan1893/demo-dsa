package sorting;

import java.util.Arrays;

public class SelectionSort {

    // select an element and put into the right position
    static void sSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // find the maximum item in the remaining array and swap with the correct index

            int last = arr.length - i - 1;

            int maxInd = getMaxIndex(arr, 0, last);

            swap(arr, maxInd, last);

        }
    }

    static int getMaxIndex(int[] arr, int start, int last) {

        int max = start;

        for (int i = start; i <= last; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 34, 65, 123, 67, 45, 12 };

        sSort(unsorted);

        System.out.println(Arrays.toString(unsorted));

    }

}
