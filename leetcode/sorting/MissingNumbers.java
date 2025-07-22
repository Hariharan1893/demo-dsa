package leetcode.sorting;

// https://leetcode.com/problems/missing-number/description/

public class MissingNumbers {
    static int missingNumber(int[] arr) {

        // cyclic sort
        int i = 0;

        while (i < arr.length) {
            int correctInd = arr[i];

            if (arr[i] < arr.length && arr[i] != arr[correctInd]) {
                swap(arr, i, correctInd);
            } else {
                i++;
            }
        }

        for (int ind = 0; ind < arr.length; ind++) {
            if (arr[ind] != ind) {
                return ind;
            }
        }

        return arr.length;
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 3, 6, 0, 4, 5, 1 };

        System.out.println(missingNumber(unsorted));

    }
}
