import java.util.Scanner;

public class Solution {
    
    public static int solve(String dna) {

        int max = 0;
        int cur = 1;
        for (int i = 1; i < dna.length(); i++) {
            
            if (dna.charAt(i) == dna.charAt(i - 1)) {
                cur++;
            } else {
                max = Math.max(cur, max);
                cur = 1;
            }
        }
  
        if (cur > max)
            max = cur;

        return max;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String dna = sc.nextLine();
        sc.close();

        System.out.println(solve(dna));
    }
}
