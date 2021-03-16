public class Solution {

    public static int solve(int[] arr) {

        /*
        When moving through array from left to right, 
        if we know the largest sum of non-adjacent elements including previous element and
        the largest sum of non-adjacent elements excluding previous element,
        then we can easily compute the largest sum of non-adjacent elements until the current element.
        */

        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = exclude;
            exclude = Math.max(include, exclude);
            include = temp + arr[i];
        }

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{8, 3, 1, 9, 7, 5}));
    }
}