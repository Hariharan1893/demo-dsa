package leetcode.searching.binarysearch;

// https://www.geeksforgeeks.org/dsa/find-rotation-count-rotated-sorted-array/

public class CountRotationInRotatedArray {

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

    static int countOfRotation(int[] arr){
        int pivot = pivotIndexInRotatedArray(arr);

        return pivot + 1;
    }

    public static void main(String... args){
        int[] arr = {4,5,6,1,2,3};
        System.out.println(countOfRotation(arr));
    }

}
