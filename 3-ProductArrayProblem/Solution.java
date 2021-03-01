
public class Solution {
    
    public static int[] solve2(int[] arr) {

        // to hold the result production array
        int[] result = new int[arr.length];

        // Each ith value represents
        // the multiplication of elements before ith element in arr  
        int[] left = new int[arr.length];

        // Each ith value represents
        // the multiplication of elements after ith element in arr  
        int[] right = new int[arr.length];

        // assign 1 to the first element in left array
        left[0] = 1;

        // assign 1 to the last element in right array
        right[arr.length - 1] = 1;

        // populate left array
        for(int num1 = 1; num1 < arr.length; num1++) {
            left[num1] = arr[num1 - 1] * left[num1 - 1];
        }

        // populate right array
        for(int num2 = arr.length - 2; num2 >= 0; num2--){
            right[num2] = arr[num2 + 1] * right[num2 + 1];
        }

        // Each ith value in resutl array represents the multiplication 
        // of all elements in arr array except the ith element.
        for(int i = 0; i < arr.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = solve2(new int[]{1, 2, 3, 4, 5});
        
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
