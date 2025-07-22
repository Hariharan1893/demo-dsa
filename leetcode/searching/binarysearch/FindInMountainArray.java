package leetcode.searching.binarysearch;

// https://leetcode.com/problems/find-in-mountain-array/description/

public class FindInMountainArray {

    // 1. Find the peak element in the mounainArr
    // 2. do binarySearch on the start 0 to peak if target not found
    // 3. do binarySearch on the second half
    static int findInMountain(int[] arr, int target) {

        int peak = peekIndexMountain(arr);
        int firstHalf = binarySearch(arr, target, 0, peak);

        if (firstHalf != -1) {
            return firstHalf;
        }

        // try to search in second half
        return binarySearch(arr, target, peak + 1, arr.length - 1);
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

    static int binarySearch(int[] arr, int target, int start, int end) {
        // int start = 0;
        // int end = arr.length - 1;

        // To: find whether the array is sorted in asc or desc

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {

            // int mid = (start + end) / 2; -> might possible that (start + end) can be
            // exceed the range of integer

            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(findInMountain(arr, target));
    }

}