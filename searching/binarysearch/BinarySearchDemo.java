package searching.binarysearch;

// Binary Search

// find the middle element of an array

// binary searching done on the sorted array
// if the target > mid -> search in the right side else search in left side of an array
// when the target == mid then return the value

public class BinarySearchDemo {

    // The below binarySearch code will Order Agnostics -> it will search on both
    // ascending and descending sorted arrays

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

        return -1;
    }

    public static void main(String... args) {

        // Ascending array
        int[] arrAsc = new int[] { -34, -21, -5, 1, 34, 66, 87, 98 };
        int target1 = -22;

        int res1 = binarySearch(arrAsc, target1);

        System.out.println("The target element is " + ((res1 != -1) ? " found at " +
                res1 : "not found"));

        // Descending array
        int[] arrDsc = new int[] { 98, 87, 66, 34, 1, -5, -21, -34 };
        int target2 = -5;
        int res2 = binarySearch(arrDsc, target2);

        System.out.println("The target element is " + ((res2 != -1) ? " found at " +
                res2 : "not found"));
    }
}
