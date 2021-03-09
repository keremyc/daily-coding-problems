import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Solution {
    
    public static void solve(String input) {

        HashMap<Character, Integer> lettersNum = new HashMap<>();
        
        for (int i = 0; i < input.length(); i++){

            if (lettersNum.containsKey(input.charAt(i))){
                int val = lettersNum.get(input.charAt(i));
                lettersNum.put(input.charAt(i), val + 1);
            } else {
                lettersNum.put(input.charAt(i), 1);
            }
        }

        Iterator iter = lettersNum.entrySet().iterator();

        int oddNum = 0;
        char oddChar = ' ';
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            if ((int)entry.getValue() % 2 != 0){
                oddChar = (char)entry.getKey();
                oddNum++;
            }
        }

        if (oddNum > 1 || (oddNum == 1 && input.length() % 2 == 0)){
            System.out.println("NO SOLUTION");
            return;
        }

        Iterator iter2 = lettersNum.entrySet().iterator();
        StringBuilder strBuilder = new StringBuilder();

        while (iter2.hasNext()){
            Map.Entry entry = (Map.Entry)iter2.next();

            for (int i = 0; i < (int)entry.getValue() / 2; i++){
                strBuilder.append((char)entry.getKey());
            }
        }

        if (oddNum == 0){
            System.out.println(strBuilder.toString() + 
                                strBuilder.reverse().toString());
        } else {
            System.out.println(strBuilder.toString() + oddChar + 
                                strBuilder.reverse().toString());
        }
       
        
    }    

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        solve(input);
    }

}
