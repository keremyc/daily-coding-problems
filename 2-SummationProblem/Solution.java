import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // T(N) = O(n^2)
    public static boolean solve1(int n, int[] arr) {
        for(int num1 = 0; num1 < arr.length ; num1++) {
            for(int num2 = 0; num2 < arr.length ; num2++) {
                if((arr[num1] + arr[num2] == n) && (num1 != num2)) return true;
            }
        }
        return false;
    }

    // T(N) = O(n) - only for unique values
    public static boolean solve2(int n, int[] arr) {
        HashMap<Integer,Integer> hash= new HashMap<>();
        for (int i=0; i<arr.length;i++){
            hash.put(i,arr[i]);
        }

        int dif;
        for (int i=0; i<arr.length;i++){
            dif=n-arr[i];
            if (hash.containsValue(dif) && hash.get(i)!=dif){
              return true;    
            }
        }    
        return false;
    }

    // T(n) = 0(n*logn)
    public static boolean solve3(int n, int[] arr) {
        Arrays.sort(arr);
        int first = 0;
        int last = arr.length - 1; 
        while(first < last) { 
            if(arr[first] + arr[last] == n) {
                return true;
            }
            else if (arr[first] + arr[last] > n) {
                last--;
            }
            else {
                first++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        System.out.println(solve1(20, arr));
        System.out.println(solve2(20, arr));
        System.out.println(solve3(20, arr));
    }
}