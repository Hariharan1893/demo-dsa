package leetcode.searching.binarysearch;

// you are given an sorted array find the ceiling of a given number

// ceiling -> smalles element in array greater or equal to target element 
public class CeilingOfANumber {

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

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

        //return binarySearch(arr, ++target);
        return start;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };

        int ceilingNumber = binarySearch(arr, 7);
        System.out.println(ceilingNumber);
    }

}
