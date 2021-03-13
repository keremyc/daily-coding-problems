
public class Solution {

    public static int solve(String message) {

        /*
        Moving through the message from left to right, 
        in each step, there are two ways for decoding. 
        So the problem can be solved by recursion in an elegant way. 
        In each step we'll call the function for remaining part except the first charachter,
        and then for remaining part except the fisrt two character.
        */

        // For messages consist of exactly one character there's only one way to decode.
        if (message.length() == 1 || message.length() == 0)
            return 1;
        else {
            
            int x = solve(message.substring(1));

            // If int value of the first two chars is greater than 26, 
            // we shouldn't call the function for this way.
            int val = Integer.parseInt(message.substring(0, 2));
            if (val > 26) 
                return x;

            return x + solve(message.substring(2));
        }
    }

    public static void main(String[] args) {

        System.out.println(solve("111"));

        // hello
        System.out.println(solve("85121215"));

    }
}