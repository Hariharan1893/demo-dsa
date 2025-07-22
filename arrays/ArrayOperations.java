package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayOperations {

  static int min(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }

  static int max(int[] arr) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;

  }

  static int sum(int[] arr) {
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

  static double avg(int[] arr) {

    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum / (double) arr.length;

  }

  static void CountEvenOdd(int[] arr) {
    int oddCount = 0;
    int evenCount = 0;

    for (int n : arr) {
      if (n % 2 == 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }

    System.out.println("Odd count : " + oddCount);
    System.out.println("Even count : " + evenCount);

  }

  static boolean isContain(int[] arr, int target) {

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return true;
      }
    }
    return false;
  }

  static void reverseArray(int[] arr, int left, int right) {

    while (left < right) {
      // Swap elements
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;

      left++;
      right--;
    }
  }

  static void rotateRight(int[] arr, int position) {

    int n = arr.length;

    // handling the cases where if position is greater than array length k > n

    position %= n;

    // To rotate an array to the right by k positions, do this:

    // 1. Reverse the entire array
    reverseArray(arr, 0, n - 1);
    // 2. Reverse the first k element
    reverseArray(arr, 0, position - 1);
    // 3. Reverse the remaining n - k elements
    reverseArray(arr, position, n - 1);
  }

  static void rotateLeft(int[] arr, int position) {

    int n = arr.length;

    // handling the cases where if position is greater than array length k > n

    position %= n;

    // To rotate an array to the left by k positions, do this:

    // 1. Reverse first k elements.
    reverseArray(arr, 0, position - 1);
    // 2. Reverse the remaining n - k element
    reverseArray(arr, position, n - 1);
    // 3. Reverse the entire array
    reverseArray(arr, 0, n - 1);
  }

  static List<List<Integer>> printAllSubarrays(int[] arr) {
    int n = arr.length;

    List<List<Integer>> result = new ArrayList<>();

    for (int start = 0; start < n; start++) {
      for (int end = start; end < n; end++) {

        List<Integer> subArray = new ArrayList<>();

        for (int i = start; i <= end; i++) {
          subArray.add(arr[i]);
        }
        result.add(subArray);
      }
    }
    return result;
  }

  public static void main(String[] args) {

    int[] arr = new int[] { 34, 65, 23, 67, 87, 25, 63 };

    // To: Find the minimum and maximum element of an given array

    System.out.println("Maximum number: " + max(arr));
    System.out.println("Minimum number: " + min(arr));

    // To: Find the sum and average of an given array

    System.out.println("Sum of the array: " + sum(arr));
    System.out.printf("Average of the array: %.2f ", avg(arr));

    System.out.println();

    // To. Find the count of odd and even element in an array
    CountEvenOdd(arr);

    // To. check is array contains a specific value
    System.out.println("Element 87 is : " + (isContain(arr, 87) ? "present" : "not present"));

    // To. reverse an array without using extra space
    int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
    System.out.println("Arrays before reverse: " + Arrays.toString(arr2));
    reverseArray(arr2, 0, arr.length);
    System.out.println("Arrays after reverse: " + Arrays.toString(arr2));

    // To. rotate the array right at k position

    int[] arr3 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int k1 = 2;
    rotateRight(arr3, k1);
    System.out.println("Array after rotated right 3 position: " + Arrays.toString(arr3));

    // To. rotate the array left at k position

    int[] arr4 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int k2 = 2;
    rotateLeft(arr4, k2);
    System.out.println("Array after rotated left 3 position: " + Arrays.toString(arr4));

    // To: print all the sub array
    int[] mainArr = new int[] { 1, 2, 3, 4, 5 };
    List<List<Integer>> subarr = printAllSubarrays(mainArr);

    System.out.println("Subarray: ");
    subarr.forEach(System.out::print);

  }

}
