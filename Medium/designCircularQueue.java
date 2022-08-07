/*
 * Design Circular Queue - Implement the given circular queue operations without using a queue.
 * 
 * To keep track of elements, we can use an array list. We use a counter variable for the current
 * number of elements, and a max variable for the maximum number of elements. For add and remove
 * operations, we need to check if the list is full, and if there is an element to remove. For the
 * front and rear operations, we check if there are elements in the list.
 */

class MyCircularQueue {
    List<Integer> v;
    int current = 0;
    int max;
    public MyCircularQueue(int k) {
        v = new ArrayList<>();
        max = k;
    }
    
    public boolean enQueue(int value) {
        if (current < max) {
            v.add(value);
            current++;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        if (current > 0) {
            v.remove(0);
            current--;
            return true;
        }
        
        return false;
    }
    
    public int Front() {
        if (current > 0)
            return v.get(0);
        
        return -1;
    }
    
    public int Rear() {
        if (current > 0)
            return v.get(current - 1);
        
        return -1;
    }
    
    public boolean isEmpty() {
        return v.isEmpty();
    }
    
    public boolean isFull() {
        if (current < max)
            return false;
        
        return true;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */