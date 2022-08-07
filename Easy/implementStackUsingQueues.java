/*
 * Implement Stack Using Queues - Implement the given operations of a stack only using queue operations.
 * 
 * We create a new queue to hold values. When we push a new value, we reverse the queue, such that
 * the top of the stack is now at the front of the queue. The rest of the operations can now be done
 * easily.
 */

class MyStack {

    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        
        for (int i = 0; i < q.size() - 1; i++) {
            int front = q.poll();
            q.add(front);
        }
    }
    
    public int pop() {
        int front = q.poll();
        return front;
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */