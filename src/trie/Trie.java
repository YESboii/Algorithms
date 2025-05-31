package trie;
//https://leetcode.com/problems/implement-trie-prefix-tree/
//https://www.naukri.com/code360/problems/implement-trie_1387095
//https://www.naukri.com/code360/problems/complete-string_2687860
//https://leetcode.com/problems/longest-word-in-dictionary/description/
//above is same complete string
//If we need a faster search + prefix search then we need to incorporate hashmap at a cost of space
public class Trie {

     public static class TrieNode{
         private final TrieNode[] children;
         private boolean terminal;

         public TrieNode(){
             children = new TrieNode[26];
             terminal = false;
         }
         public boolean containsChild(char ch){
             return children[ch - 'a'] != null;
         }
         public void addChild(char ch){
             children[ch - 'a'] = new TrieNode();
         }
         public TrieNode getChild(char ch){
             return children[ch - 'a'];
         }
         public boolean isTerminal(){
             return terminal;
         }
         public void setTerminal(){
             terminal = true;
         }
     }
     private final TrieNode root;

    public Trie() {
       root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode itr = root;
        for (char ch : word.toCharArray()){
            if (!itr.containsChild(ch)){
                itr.addChild(ch);
            }
            itr = itr.getChild(ch);
        }
        itr.setTerminal();
    }

    public boolean search(String word) {
        TrieNode itr = root;
        for (char ch : word.toCharArray()){
            if (!itr.containsChild(ch)){
                return false;
            }
            itr = itr.getChild(ch);
        }
        return itr.isTerminal();
    }

    public boolean startsWith(String prefix) {
        TrieNode itr = root;
        for (char ch : prefix.toCharArray()){
            if (!itr.containsChild(ch)){
                return false;
            }
            itr = itr.getChild(ch);
        }
        return true;
    }
}
class test{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apples");
        trie.insert("apps");
        trie.insert("bat");
        System.out.println(trie.search("app")); // F
        System.out.println(trie.search("zebra")); //F
        System.out.println(trie.startsWith("app")); // T
        System.out.println(trie.search("apple"));
    }
}