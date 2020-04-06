package Practical8;

import java.awt.image.AbstractMultiResolutionImage;

public class Trie {
    public static void main(String[] args){
        Trie trie = new Trie();
        String[] keys = {"bank","book","bar","bring","film","filter","simple","silt","silver"};
        for(int i = 0;i<keys.length;i++){
            trie.insert(keys[i]);
        }
         for(int i = 0;i<keys.length;i++){ //Searching for words
             System.out.println("Found" + keys[i] + "? = " + trie.search(keys[i]));
         }
    }
    final int alphabetSize = 26;
    Node root;
    int size = 0;
    class Node{
        char value;
        Node[] children = new Node[alphabetSize];
        public boolean getIsEndOfWord() {
            return isEndOfWord;
        }
        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
        boolean isEndOfWord; //True if node represents end of word (e.g. leaf node)
        Node(){ //Node class constructor
            isEndOfWord = false;
            for(int i = 0;i<alphabetSize;i++){
                children[i] = null;
            }
        }
        char getValue(){
            return value;
        }
        void setValue(char key){
            value = key;
        }
        int nextAvailableChild(){ //Find index of next free child space in array
            int index = -1;
            for(int i = 0;i<alphabetSize;i++){
                if(children[i] != null){
                    index = i;
                }
            }
            return index;
        }
    }
    void insert(String key){ //Inserts word into tree
        Node current = root;
        for(int i = 0;i<key.length();i++){ //Cycles through letters of the key
            for(int j = 0;j<alphabetSize;j++){ //Cycles through children array of node
                if(current.children[j] == null){
                    current.children[j] = current;
                    current.children[j].setValue(key.charAt(i));
                    if(current.children[j].getValue() == key.charAt(key.length())){ //Setting endOfWord variable
                        current.children[j].setEndOfWord(true);
                    }
                    size++;
                    break;
                }
                if(current.children[j].getValue() == key.charAt(i)){ //If loop find child with same character
                    current = current.children[j];
                    break;
                }

            }
        }
    }
    boolean search(String key){
        Node cur = root;
        boolean inTrie = false;
        for(int i = 0;i<key.length();i++){ //Cycles though letters of key
            if(cur.getIsEndOfWord()){ //Checking if character is end of word
                inTrie = true;
            }
            for(int j = 0;j<alphabetSize;j++){ //Cycles through children array
                if(cur.children[j].getValue() == key.charAt(i)){
                    cur = cur.children[j];
                }
                if(cur.children[j] == null){
                    inTrie = false;
                    break;
                }
            }
            if(!inTrie){
                break;
            }
        }
        return inTrie;
    }
}
