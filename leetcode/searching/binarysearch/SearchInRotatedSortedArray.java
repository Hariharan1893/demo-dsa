package leetcode.searching.binarysearch;
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArray {

    // approch 1
    // 1. find the pivot
    // which is the point where your next numbers are ascending order
    // 2. search in first half 0 to pivot ortherwise
    // 3. search inthe second half

    static int findInRoatedArray(int[] arr, int target) {

        int pivot = pivotIndexInRotatedArray(arr);

        // if no pivot -> array is not rotated
        if (pivot == -1) {
            // normal binary search
            return binarySearch(arr, target, 0, arr.length);
        }

        // if pivot found -> we have two sorted arra

        if (arr[pivot] == target)
            return pivot;

        if (target >= arr[0])
            return binarySearch(arr, target, 0, pivot - 1);

        return binarySearch(arr, target, pivot + 1, arr.length);

    }

    static int pivotIndexInRotatedArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // 3,4,5,6,7,1,2

            // mid should always less than end
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // there should be only one decresing order in an array
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        // int start = 0;
        // int end = arr.length - 1;

        while (start <= end) {

            // int mid = (start + end) / 2; -> might possible that (start + end) can be
            // exceed the range of integer

            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(findInRoatedArray(arr, 6));

    }
}
