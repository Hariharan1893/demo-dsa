package leetcode.searching.linearsearch;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        
        int[] arr = {12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }

    static int findNumbers(int[] nums) {

        // int count = 0;

        // for (int i = 0; i < nums.length; i++) {
        // if (((int) Math.log10(nums[i]) + 1) % 2 == 0) {
        // count++;
        // }
        // }

        // return count;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (checkEven(nums[i])) {
                count++;
            }
        }

        return count;

    }

    static boolean checkEven(int n) {

        int dig = 0;
        // int temp = n;
        while (n > 0) {
            // temp = n % 10;
            dig++;
            n /= 10;
        }

        if (dig % 2 == 0) {
            return true;
        }

        return false;
    }

}
