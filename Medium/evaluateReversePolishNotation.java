/*
 * Evaluate Reverse Polish Notation - Given a string of characters representing operations in 
 * reverse polish notation, return the final evaluation of all the operations.
 * 
 * We use a stack to push numbers to. When we encounter an operator, we pop the two most recent numbers
 * from the stack, perform the operation, and push the result to the stack, and continue. The end
 * result will be at the top of the stack once all operations are finished.
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for (String str : tokens) {
            if (str.length() > 1 || str.charAt(0) - '0' >= 0) {
                s.push(Integer.valueOf(str));
            }
            else {
                int a = s.pop();
                int b = s.pop();
                
                switch(str.charAt(0)) {
                    case '+':
                        s.push(b + a);
                        break;
                    case '-': 
                        s.push(b - a);
                        break;
                    case '*':
                        s.push(b * a);
                        break;
                    case '/':
                        s.push(b / a);
                        break;
                }
            }
        }
        
        return s.peek();
    }
}