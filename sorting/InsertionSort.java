package sorting;

import java.util.Arrays;

public class InsertionSort {

    // sorting the array partially
    static void iSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
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

        iSort(unsorted);

        System.out.println(Arrays.toString(unsorted));

    }
}
