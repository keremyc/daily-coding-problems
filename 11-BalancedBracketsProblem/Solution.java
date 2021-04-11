import java.util.Stack;

public class Solution {

    public static boolean solve(String str) {
        /*
         * In this problem, we'll use the Stack data structure.
         * In stack, we hold the openning brackets and when we encounter a closing bracket,
         * we check whether or not the unbalanced former openning bracket matches the closing bracket.
         */


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
           char c = str.charAt(i);


           switch (c) {
               case ')':
                   /*
                   if stack is empty or stack's last element is not balanced with c value, then return false.
                    */
                   if (stack.isEmpty() || stack.peek().charValue() != '(')
                       return false;
                   stack.pop();
                   break;
               case '}':
                   if (stack.isEmpty() || stack.peek().charValue() != '{')
                       return false;
                   stack.pop();
                   break;
               case ']':
                   if (stack.isEmpty() || stack.peek().charValue() != '[')
                       return false;
                  stack.pop();
                   break;
               default:
                   /*
                   For openning brackets, just push them to the top of the stack.
                    */
                   stack.push(c);
           }

        }

        if (stack.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println(solve("([])[]({})"));
        System.out.println(solve("([)]"));
        System.out.println(solve("(({{{[[]]}}}))"));
    }
}