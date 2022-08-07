/*
 * Implement Queue Using Stacks - Implement the given queue operations usnig only stack operations.
 * 
 * Similar to Implement Stack Using Queues, when inserting into our queue, we reverse the elements in
 * our stack. To do this, we need to use two stacks, one to place values into, and one to reverse
 * values into. Then, the other operations become easier to implement.
 */

class MyQueue {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while (!s2.isEmpty()) {
            int val = s2.pop();
            s1.push(val);
        }
        
        s1.push(x);
        int size = s1.size();
        
        for (int i = 0; i < size; i++) {
            int top = s1.pop();
            s2.push(top);
        }
    }
    
    public int pop() {
        return s2.pop();
    }
    
    public int peek() {
        return s2.peek();
    }
    
    public boolean empty() {
        return s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */