package searching.binarysearch;

import java.util.Arrays;

public class BinarySearch2D {

    // n*n matrix fully sorted matrix
    static int[] binarySearchN(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {

            // Mid Point calculation for flat sorted array
            int mid = start + (end - start) / 2;

            // convert mid into 2d matrix indices
            rows = mid / cols;
            cols = mid % cols;
            int midValue = matrix[rows][cols];

            if (midValue == target) {
                return new int[] { rows, cols };
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }

    // m*n matrix
    // Row wise sorted and column wise sorted
    static int[] binarySearchMN(int[][] matrix, int target) {

        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] { row, col };
            }

            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }

        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][] {
                { 10, 20, 30 },
                { 12, 25, 33 },
                { 14, 28, 37 }
        };

        System.out.println(Arrays.toString(binarySearchMN(matrix1, 25)));

        int[][] matrix2 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(Arrays.toString(binarySearchN(matrix2, 4)));
    }
}
