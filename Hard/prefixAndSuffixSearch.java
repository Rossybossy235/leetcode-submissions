/*
 * Prefix And Suffix Search - Best to view the LeetCode description, this one is can be confusing.
 * 
 * We used the Trie data structure for this problem. We store strings along with their prefix and
 * suffixes appended to them, and we search through the data structure to find whatever prefix and
 * suffix we're looking for.
 */

class TrieNode {
    TrieNode[] word = new TrieNode[27];
    int end = -1;
    
    public boolean contains(char c) {
        return word[c - 'a'] != null;
    }
    
    public void set(char c) {
        if (c == '#')
            word[26] = new TrieNode();
        else
            word[c - 'a'] = new TrieNode();
    }
    
    public void setEnd(int index) {
        end = index;
    }
    
    public TrieNode get(char c) {
        if (c == '#')
            return word[26];
        else
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
        // System.out.println(s);
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

class WordFilter {
    
    Trie tree;
    int index;

    public WordFilter(String[] words) {
        tree = new Trie();
        
        for (int j = 0; j < words.length; j++) {
            String s = words[j];
            tree.insert("#" + s, j);
            for (int i = s.length() - 1; i >= 0; i--)
                tree.insert(s.substring(i, s.length()) + "#" + s, j);
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode end = tree.find(suffix + "#" + prefix);
        if (end == null)
            return -1;
        
        index = -1;
        dfs(end);
        return index;
    }
    
    public void dfs(TrieNode node) {
        if (node == null)
            return;
        
        if (node.end != -1)
            index = Math.max(index, node.end);
        
        for (int i = 0; i < 26; i++)
            dfs(node.word[i]);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */