package searching.linearsearch;

import java.util.Arrays;

public class LinearSearchDemo {

  public static void main(String[] args) {

    int[] arr = { 11, 435, 56, 32, 768, 123, 987, 23, 54, 12 };

    int target1 = 123;
    int target2 = 31;

    System.out.println("The element " + target1 + " is found at: " + linearSearch(arr, target1));

    System.out.println("The element " + target2 + " is not found so: " + linearSearch(arr, target2));

    System.out.println();

    String name = "Java is a nice language";
    char chTarget1 = 'v';
    char chTarget2 = 't';

    System.out.println("Target 1 is : " + chTarget1 + (isCharPresent(name, chTarget1) ? " found." : " not found"));

    System.out.println("Target 2 is : " + chTarget2 + (isCharPresent(name, chTarget2) ? " found." : " not found"));

    System.out.println();

    int[][] arr2D = {
        { 23, 65, 12, 86, 23 },
        { 345, 87, 34, 13 },
        { 76, 90, 21 }
    };

    int arrTarget1 = 34;

    int[] res = linearSearch2D(arr2D, arrTarget1);
    System.out.println("The target value: " + arrTarget1 + " is found at :" + Arrays.toString(res));
  }

  // linear search method
  // if element found -- returns the index value
  // if not found -- it returns -1
  static int linearSearch(int[] arr, int target) {
    if (arr.length == 0)
      return -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  // search a character in a string
  // if the character is found it returns true or it returns false
  static boolean isCharPresent(String str, char target) {
    if (str.isEmpty())
      return false;

    for (char ch : str.toCharArray()) {
      if (ch == target) {
        return true;
      }
    }
    return false;
  }

  // search 2D array and return the result as [row, col] of the position found
  // else [-1, -1]
  static int[] linearSearch2D(int[][] arr, int target) {

    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        if (arr[row][col] == target)
          return new int[] { row, col };
      }
    }
    return new int[] { -1, -1 };
  }

}
