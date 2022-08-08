/*
 * Min Stack - Implement a min stack. The difference is that you need to be able to retrieve the 
 * current smallest value from the stack.
 * 
 * When pushing to the stack, we check if we need to update the current min. If we do, we push the old
 * min to the stack, change our min, then push the new min to the stack. This way, the min will be at
 * the top of the stack, and the previous min will be right before the new one. Then, when popping from
 * the stack, we check if we are popping the min value. If we are, we pop both the min value and the
 * previous min value from the stack to preserve the stack order.
 */

class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (val <= min) {
            s.push(min);
            min = val;
        }
        
        s.push(val);
    }
    
    public void pop() {
        int val = s.pop();
        
        if (val == min)
            min = s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */