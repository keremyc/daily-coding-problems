
public class Solution {

    public static int solve(int[] arr){

        /*
        For an array of size N, the missing number should be in interval [1, N+1]
        If the missing number is greater than N+1, the originial array should contain all positive 
        integers from 1 to N+1. However, the array size is N. 
        So, the missing number should be in interval [1, N+1]
        and we can ignore all elements that are outside of this interval.
        */

        int len = arr.length;

        // Reshuffle the array to bring numbers in interval [1, N+1] to front.
        int j = 0, i;
        for (i = 0; i < arr.length; i++){
            if (arr[i] <= len + 1 && arr[i] >= 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        // In this step, we use the array itself as a hashmap
        // To mark the presence of an element, we use that value as an index(say, i)
        // and flip the sign of the value in the index ith to negative.
        // In this case, the first non-negative element's index is the answer.
        for (i = 0; i < j; i++){
            int index = Math.abs(arr[i]) - 1; 
            arr[index] = -arr[index];
        }

        // find the first pozitive value and return the index.
        for (i = 0; i < j; i++){
            if (arr[i] > 0)
                return i + 1;
        }

        // 0 indicates that the array is complete.
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 4, -1, 1}));
    }
}
