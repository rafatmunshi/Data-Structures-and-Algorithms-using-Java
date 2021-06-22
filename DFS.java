package ds;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    private int V;

    private LinkedList<Integer> adj[]; 

    DFS(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 

    void addEdge(int v, int w) 
    { 
        adj[v].add(w);
    } 

    public static void main(String args[]) 
    { 
        DFS g = new DFS(10); 
  
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(2, 3); 
        g.addEdge(0, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6); 
        g.addEdge(4, 7); 
        g.addEdge(0, 8);  
        g.addEdge(8, 9); 
        System.out.println("DFS-"); 
  
        g.DFSearch(0); 
    } 
    void DFSearch(int v) {
    	boolean visited[]= new boolean[V];
    	DFSstack(v, visited);
    }
    void DFSstack(int v, boolean visited[]) {
    	visited[v]=true;
    	System.out.print(v+" ");
    	Iterator<Integer> i=adj[v].listIterator();
    	while(i.hasNext()) {
    		int n=i.next();
    		if(!visited[n]) {
    			DFSstack(n, visited);
    		}
    	}
    }
}
