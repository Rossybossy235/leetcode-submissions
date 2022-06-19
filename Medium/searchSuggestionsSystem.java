/*
 * Search Suggestions System - Given an array of products and a search word, return a list of 
 * suggested products that share a prefix with the search word as each character is typed
 * out. Limit to 3 suggestions per prefix.
 * 
 * We use the trie data structure to store words in a dictionary. Then, for each prefix of the search
 * word, we search the dictionary for the first 3 suggestions in alphabetical order.
 */

class TrieNode {
    TrieNode[] word = new TrieNode[27];
    int end = -1;
    
    public boolean contains(char c) {
        return word[c - 'a'] != null;
    }
    
    public void set(char c) {
        word[c - 'a'] = new TrieNode();
    }
    
    public void setEnd(int index) {
        end = index;
    }
    
    public TrieNode get(char c) {
        return word[c - 'a'];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s, int index) {
        TrieNode temp = root;
        
        for (char c : s.toCharArray()) {
            if (temp.get(c) == null)
                temp.set(c);
            temp = temp.get(c);
        }
        temp.setEnd(index);
    }
    
    public TrieNode find(String s) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (temp.get(c) == null)
                return null;
            temp = temp.get(c);
        }
        return temp;
    }
}

class Solution {
    Trie tree;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        tree = new Trie();
        
        for (int j = 0; j < products.length; j++) {
            tree.insert(products[j], j);
        }
        
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> newList = new ArrayList<String>();
            
            TrieNode end = tree.find(searchWord.substring(0, i));
            
            dfs(end, newList, products);
            res.add(newList);
        }
        
        return res;
    }
    
    public void dfs(TrieNode node, List<String> current, String[] products) {
        if (node == null)
            return;
        if (current.size() == 3)
            return;
        
        if (node.end != -1)
            current.add(products[node.end]);
        
        for (int i = 0; i < 26; i++)
            dfs(node.word[i], current, products);
    }
}