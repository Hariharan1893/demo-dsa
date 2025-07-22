package leetcode.searching.linearsearch;

// https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {

    static int maximumWealth(int[][] a) {

        int max = 0;
        for (int i = 0; i < a.length; i++) {

            int sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }

            if (sum > max) {
                max = sum;
            }

        }

        return max;
    }
}
