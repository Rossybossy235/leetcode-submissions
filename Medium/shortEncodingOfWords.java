/*
 * Short Encoding Of Words - Given a list of strings, return the length of the shortest valid
 * encoding of the list of strings. A valid encoding consists of the strings contatenated together
 * with a # between them, skipping over strings that are contained within one or more of the other
 * strings.
 * 
 * We use the trie data structure to store words. We store the words backwards such that strings
 * contained within other strings can be placed in the same branch as the larger strings. We then
 * traverse the tree, checking if the current node we are looking at is the end of a word. If it is,
 * we can add the length of the string to the resulting length, plus one extra for the #.
 */

class TrieNode {
    TrieNode[] word = new TrieNode[26];
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
    int size;
    
    public int minimumLengthEncoding(String[] words) {
        
        tree = new Trie();
        size = 0;
        
        for (int j = 0; j < words.length; j++) {
            tree.insert(new StringBuilder(words[j]).reverse().toString(), j);
        }
        
        dfs(tree.root, words);
        
        return size;
    }
    
    public void dfs(TrieNode node, String[] words) {
        if (node == null)
            return;
        
        boolean isLeaf = true;
        
        for (int i = 0; i < 26; i++) {
            if (node.word[i] != null)
                isLeaf = false;
        
            dfs(node.word[i], words);
        }
        
        if (isLeaf)
            size += words[node.end].length() + 1;
    }
}