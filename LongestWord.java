package ds;

import java.util.LinkedList;
import java.util.Queue;

public class LongestWord {
	Trie root;
class Trie{
	String word;
	Trie children[];
	
	Trie(){
		children= new Trie[26];
	}

}
void addWord(String word) {
	Trie cur=root;
	for(int i=0;i<word.length();i++) {
		char c=word.charAt(i);
		if(cur.children[c-'a']==null)
		cur.children[c-'a']=new Trie();
		
		cur=cur.children[c-'a'];
	}
	cur.word=word;
}
String longestWord(String[] words) {
	root= new Trie();
	
	for(String word:words)
		addWord(word);
	
	Queue<Trie> q= new LinkedList<Trie>();
	q.add(root);
	Trie node=null;
	while(!q.isEmpty()) {
		node=q.poll();
		Trie[] children=node.children;
		for(int i=25; i>=0; i--) {
			if(children[i]!=null&& children[i].word!=null) {
				q.add(children[i]);
			}
		}
	}
	return node.word;
}
public static void main(String args[]) {
	String[] words= {"a","banana","ap","app","appl","apple","apply"};
	LongestWord t=new LongestWord();
	String longestWord=t.longestWord(words);
	System.out.println(longestWord);
}
}
