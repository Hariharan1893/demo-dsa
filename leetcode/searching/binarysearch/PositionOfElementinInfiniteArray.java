package leetcode.searching.binarysearch;

// https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/

// suppose you jave a sorted array of infinite numbers, how would you search an element in an array

public class PositionOfElementinInfiniteArray {

    static int findIndex(int[] arr, int target) {

        // initially the window size will be 2
        int start = 0;
        int end = 1;

        while (arr[end] < target) {
            start = end;
            end *= 2;
        }

        return binarysearch(arr, target, start, end);
    }

    static int binarysearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        System.out.println(findIndex(arr, 12));
    }

}
