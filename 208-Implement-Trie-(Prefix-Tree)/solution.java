class TrieNode {
    // Initialize your data structure here.
    TrieNode[] childs;
    boolean[] exist;
    boolean end;
    public TrieNode() {
        childs = new TrieNode[26];
        exist = new boolean[26];
        end = false;
    }

    public void insert(String word){
        if (word.length() > 0) {
            if (exist[word.charAt(0)-'a'])
                childs[word.charAt(0)-'a'].insert(word.substring(1));
            else {
                exist[word.charAt(0) - 'a'] = true;
                childs[word.charAt(0) - 'a'] = new TrieNode();
                childs[word.charAt(0) - 'a'].insert(word.substring(1));
            }
        }
        else {
            end = true;
        }
    }

    public int search(String word){
        if (word.length() == 0)
            return end? 2: 1;
        if (exist[word.charAt(0)-'a'])
            return childs[word.charAt(0)-'a'].search(word.substring(1));
        else
            return 0;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word) == 2;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix) != 0;
    }
}

//class Solution{
//    public static void main(String[] args) {
//        Trie t = new Trie();
//        t.insert("ab");
//        System.out.println(t.search("a"));
//    }
//}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");