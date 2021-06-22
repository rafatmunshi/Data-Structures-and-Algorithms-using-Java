package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class TopologicalSort {
	int V; 
    List<Integer> adj[]; 
    public TopologicalSort(int V) 
    { 
        this.V = V; 
        adj = new ArrayList[V]; 
        for (int i = 0; i < V; i++) 
            adj[i] = new ArrayList<Integer>(); 
    } 

    public void addEdge(int u, int v) 
    { 
        adj[u].add(v); 
    } 
public void topologicalSort() {
	int indegree[]=new int[V];
	for(int i=0;i<V;i++) {
		ArrayList<Integer> temp=(ArrayList<Integer>) adj[i];
		for(int dest:temp) {
			indegree[dest]++;
		}
	}
	Queue<Integer> q=new LinkedList<Integer>();
	for(int i=0;i<V;i++) {
		if(indegree[i]==0)
			q.add(i);
	}
	int order[]=new int[V];
	int i=0;
	while(!q.isEmpty()) {
		int u=q.poll();
		order[i++]=u;
		for(int dest:adj[u]) {
			indegree[dest]--;
			if(indegree[dest]==0)
				q.add(dest);
		}
	}
	if(order.length!=V) {
		System.out.println("There exists a cycle in the graph");
		return;
	}
	for(int j:order) {
		System.out.println(j);
	}
}

 
    public static void main(String args[]) 
    { 
    	TopologicalSort g = new TopologicalSort(9); 
        g.addEdge(0, 1); 
        g.addEdge(0, 4); 
        g.addEdge(1, 2); 
        g.addEdge(1, 6); 
        g.addEdge(3, 5); 
        g.addEdge(3, 4); 
        g.addEdge(3, 8); 
        g.addEdge(4, 8); 
        g.addEdge(4, 7); 
        g.addEdge(5, 6); 
        System.out.println("Topological Sort"); 
        g.topologicalSort(); 
    } 
}
