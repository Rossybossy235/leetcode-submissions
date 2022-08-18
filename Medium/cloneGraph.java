/*
 * Clone Graph - Given a reference of a node of a connected undirected graph, return a deep copy
 * of the graph, where each node contains a value and a list of its neighbors.
 * 
 * We use a bfs to visit all the nodes, along with a hashmap to keep track of nodes we have visited
 * so that we can edit their neighbor lists. For each node, we check if its neighbors are already in 
 * the hash map. If it isn't, we place it in, and add it to the queue. We add the neighbor to the 
 * current node's list of neighbors.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        Node newNode = new Node(node.val);
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        
        map.put(newNode.val, newNode);
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    q.add(neighbor);
                }
                
                map.get(current.val).neighbors.add(map.get(neighbor.val));
            }
        }
        
        return newNode;
    }
}