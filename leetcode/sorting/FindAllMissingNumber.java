package leetcode.sorting;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

public class FindAllMissingNumber {

    static List<Integer> allMissingNumber(int[] arr) {

        // cyclic sort
        int i = 0;

        while (i < arr.length) {
            int correctInd = arr[i] - 1;

            if (arr[i] != arr[correctInd]) {
                swap(arr, i, correctInd);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();

        for (int ind = 0; ind < arr.length; ind++) {
            if (arr[ind] != ind + 1) {
                missingNumbers.add(ind + 1);
            }
        }

        return missingNumbers;
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println(allMissingNumber(unsorted));

    }
}
