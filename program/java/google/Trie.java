public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur.children[index].count++;
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null) {
                System.out.println("No way");
                return false;
            }
            cur = cur.children[index];
        }
        System.out.println("Depends on cur is word");
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
    public int count(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null) {
                return 0;
            }
            cur = cur.children[index];
        }
        return cur.count;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("coward");
        trie.insert("cower");
        trie.insert("coco");
        System.out.println(trie.count("co"));
        System.out.println(trie.count("cow"));
        System.out.println(trie.startsWith("co"));
        System.out.println(trie.search("co"));
    }
}

class TrieNode {
    TrieNode[] children;
    int count;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}
