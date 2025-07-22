package leetcode.searching.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// find the starting and ending position of a given target value.

// If target is not found in the array,return[-1,-1].

public class FirstAndLastPositionOfElement {

    static int[] searchRange(int[] nums, int target) {

        int[] ans = { -1, -1 };
        // check for the first occurance if the target first
        int start = binarysearch(nums, target, true);

        int end = binarysearch(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    static int binarysearch(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                // potential answer was found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] num1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        // output [3,4]
        System.out.println(Arrays.toString(searchRange(num1, target1)));

        int[] num2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        // output [-1,-1]
        System.out.println(Arrays.toString(searchRange(num2, target2)));

        int[] num3 = {};
        int target3 = 0;
        // output [-1,-1]
        System.out.println(Arrays.toString(searchRange(num3, target3)));
    }
}
