package recursion;

public class BasicRecursion {

    static void print(int n) {
        // base condition
        if (n == 3) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }

    // fibonacci series
    // 0 1 1 2 3 5 8 13 21
    static int fibo(int n) {
        // base condition
        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // factorial
    // if (n == 0)
    // return 1;

    // return n * fact(n - 1);
    static int fact(int n) {
        return (n == 0) ? 1 : n * fact(n - 1);
    }

    // binary search using the recursion

    static int binarySearch(int[] arr, int target, int start, int end) {

        // NOTE: if an variable that needed on the further recursion put it as an
        // argument. If not means use it inside the body of the function

        if (start > end) {
            return -1; // target not found;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        }

        return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        // print(1);

        // System.out.println(fibo(7));

        // binary search
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // System.out.println(binarySearch(arr, 4, 0, arr.length - 1));

        System.out.println(fact(5));
    }
}
