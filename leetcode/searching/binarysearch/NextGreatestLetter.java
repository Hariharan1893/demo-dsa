package leetcode.searching.binarysearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class NextGreatestLetter {

    // Return the smallest character in the array that is larger than the target

    // if no characters in letters that is greater than taget retrun first element

    static char nextGreatest(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[start] || target > letters[letters.length - 1]) {
                return letters[start];
            }

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {

        char[] letters1 = { 'c', 'f', 'j' };
        char target1 = 'a';
        // output c
        System.out.println(nextGreatest(letters1, target1));

        char[] letters2 = { 'c', 'f', 'j' };
        char target2 = 'c';
        // outpur f
        System.out.println(nextGreatest(letters2, target2));

        char[] letters3 = { 'x', 'x', 'y', 'y' };
        char target3 = 'z';
        // output x
        System.out.println(nextGreatest(letters3, target3));
    }
}
