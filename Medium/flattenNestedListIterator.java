/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    public NestedIterator(List<NestedInteger> nestedList) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        Iterator iter = nestedList.iterator();
        
        while (iter.hasNext()) {
            iterate(iter.next(), res);
        }
    }
    
    public void iterate(NestedInteger nested, ArrayList<Integer> result) {
        if (nested.isInteger()) {
            result.add(nested.getInteger());
            return;
        }
        else if (!nested.isInteger()) {
            Iterator nestedIter = nested.getList().iterator();
            
            while(nestedIter.hasNext()) {
                iterate(nestedIter.next(), result);
            }
        }
    }

    @Override
    public Integer next() {
        
    }

    @Override
    public boolean hasNext() {
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */