package leetcode.sorting;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    static List<Integer> findDuplicate(int[] arr) {

        int i = 0;

        while (i < arr.length) {

            int correctInd = arr[i] - 1;

            if (arr[i] != arr[correctInd]) {
                swap(arr, i, correctInd);
            } else {
                i++;
            }

        }

        List<Integer> duplicates = new ArrayList<>();

        for (int ind = 0; ind < arr.length; ind++) {
            if (arr[ind] != ind + 1) {
                duplicates.add(arr[ind]);
            }
        }
        return duplicates;
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println(findDuplicate(unsorted));

    }
}
