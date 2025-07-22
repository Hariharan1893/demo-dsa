package leetcode.sorting;

// 1 3 4 2 2
// 0 1 2 3 4

public class FindDuplicateNumbers {

    static int findDuplicate(int[] arr) {

        int i = 0;

        while (i < arr.length) {

            int correctInd = arr[i] - 1;

            if (arr[i] != arr[correctInd]) {
                swap(arr, i, correctInd);
            } else {
                i++;
            }

        }

        for (int ind = 0; ind < arr.length; ind++) {
            if (arr[ind] != ind + 1) {
                return arr[ind];
            }
        }
        return -1;
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 1, 3, 4, 2, 2 };

        System.out.println(findDuplicate(unsorted));

    }
}
