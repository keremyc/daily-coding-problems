public class Solution {
    public static int solve(int n, int[] arr) {

        if(n==0) return 1;
        if(n<0) return 0;
        else {
            int t = 0;
            for(int i: arr){
                t += solve(n - i, arr);
            }
            return t;
        }

    }

    // public static void main(String[] args) {
    //     System.out.println(solve(6, new int[]{1, 2, 3}));
    // }

}