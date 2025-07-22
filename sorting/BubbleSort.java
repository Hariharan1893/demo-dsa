package sorting;

import java.util.Arrays;

public class BubbleSort {

    static void bSort(int[] arr) {

        // run the step n - 1 times
        for (int i = 0; i < arr.length; i++) {

            // for each step max item will come at the last respective index

            for (int j = 1; j < arr.length - i; j++) {

                // swap if the item is smaller that the previous item
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);

                }

            }
        }

    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 34, 65, 123, 67, 45, 12 };

        bSort(unsorted);

        System.out.println(Arrays.toString(unsorted));

    }
}
