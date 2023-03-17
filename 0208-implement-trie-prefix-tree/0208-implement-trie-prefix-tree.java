class Node{
    char val;
    boolean isEnd;
    Node[] child = new Node[26];
    
    Node(){}
    Node(char c){
        this.val = c;
        this.isEnd = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        // System.out.println("here");
        root = new Node();
        root.val = '#';
        // root.child = new Trie[26];
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            Node trie = new Node(word.charAt(i));
    
            if(curr.child[index] == null){
                curr.child[index] = trie;
            }
            // curr.child[index] = trie;
            curr = curr.child[index];
        }
        System.out.println(word + " inserted: " + curr.isEnd);
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.child[index] == null) return false;

            curr = curr.child[index];
        }
        System.out.println(word + " searched: " + curr.isEnd);
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        int i;
        for(i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.child[index] == null) return false;

            curr = curr.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */