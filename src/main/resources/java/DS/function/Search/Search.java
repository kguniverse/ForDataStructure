package DS.function.Search;

import DS.common.Edge;
import DS.common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    private Trie trie;

    public Search() {
        trie = new Trie();
    }

    public Search(HashMap<Integer, Node> nodes) {
        trie = new Trie();
        for(int index : nodes.keySet()) {
            Node node = nodes.get(index);
            if(isContainChinese(node.getName())) trie.insert(node.getName(), index);
        }
    }

    private static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        return m.find();
    }




}
class Treenode {
    private int index;
    public HashMap<Character, Treenode> next;

    public Treenode() {
        index = -1;
        next = new HashMap<>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Treenode getNext(char key) {
        return this.next.get(key);
    }

    public void addNext(char key, Treenode value) {
        this.next.put(key, value);
    }

    public boolean contain(char key) {
        return next.containsKey(key);
    }

}
class Trie{
    private Treenode root;
    public Trie() {
        root = new Treenode();
    }
    public void insert(String word, int index){
        Treenode node = root;
        for(int i = 0; i < word.length(); i++){
            Treenode next = node.getNext(word.charAt(i));
            if(next == null) {
                node.addNext(word.charAt(i), new Treenode());
            }
            node = next;
        }
        node.setIndex(index);
    }
    public ArrayList<String> get_key(String pre, Treenode prenode) {
        ArrayList<String> result = new ArrayList<>();
        if(prenode.getIndex() != -1) result.add(pre);
        for(Character p : prenode.next.keySet()){
            result.addAll(get_key(pre + p, prenode.getNext(p)));
        }
        return result;
    }
    public ArrayList<String> get_start(String word){
        ArrayList<String> result = new ArrayList<>();
        Treenode node = root;
        for(int i = 0; i < word.length(); i++){
            char p = word.charAt(i);
            if(!node.contain(p)) return result;
            node = node.getNext(p);
        }
        return get_key(word, node);
    }
}
