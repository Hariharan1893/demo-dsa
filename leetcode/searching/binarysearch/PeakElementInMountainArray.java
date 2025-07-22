package leetcode.searching.binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

// https://leetcode.com/problems/find-peak-element/

public class PeakElementInMountainArray {

    public static void main(String[] args) {
        int[] arr = { 0, 10, 1, 2 };
        System.out.println(peekIndexMountain(arr));
    }

    static int peekIndexMountain(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // decreasing part of array
                // may be the answer.. but check the left

                end = mid;
            } else {
                // increasing part of array
                // check the right
                start = mid + 1;
            }
        }

        // at the end of the loop both the start and end points to the same element
        // which is maximum

        return start;
    }
}
