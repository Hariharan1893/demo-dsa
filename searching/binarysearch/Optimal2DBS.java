package searching.binarysearch;

// optimal way that has O(log m * n)
public class Optimal2DBS {

    // to find the potential row
    static int searchPotentialRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // check the target element lies in which row
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (matrix[mid][0] < target) {
                end = mid - 1;
            } else if (matrix[mid][0] > target) {
                start = mid + 1;
            }
        }
        return -1;
    }

    // to find the target in that row
    static boolean binarysearch(int rowInd, int[][] matrix, int target) {

        int start = 0;
        int end = matrix[rowInd].length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (matrix[rowInd][mid] == target)
                return true;
            else if (matrix[rowInd][mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }

    static boolean searchMatrix(int[][] matrix, int target) {

        int rowInd = searchPotentialRow(matrix, target);

        if (rowInd != -1) {
            return binarysearch(rowInd, matrix, target);
        } else
            return false;

    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        int target = 19;

        System.out.println(searchMatrix(matrix, target) ? "Found" : "Not Found");
    }
}
