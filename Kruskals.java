package ds;

import java.util.Arrays;

// Sort all the edges
//Pick the smallest edge
//Check if that edge forms a cycle
//if no cycle is formed then include that edge
//Repeat until V-1 edges in the spanning tree
public class Kruskals {
	int V,E;
	Edge edge[];
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		public int compareTo(Edge c) {
			return this.weight-c.weight;
		}
	}
public static void main(String []args) {
	int V=7;
	int E=9;
	Kruskals graph= new Kruskals(V,E);
//		1		2
//	0		6		3
//		5		4
	graph.edge[0].src = 0;
	graph.edge[0].dest =1;
	graph.edge[0].weight=1;
	graph.edge[1].src = 1;
	graph.edge[1].dest =2;
	graph.edge[1].weight=10;
	graph.edge[2].src =2;
	graph.edge[2].dest =3;
	graph.edge[2].weight=3;
	graph.edge[3].src =3;
	graph.edge[3].dest =4;
	graph.edge[3].weight=1;
	graph.edge[4].src =4;
	graph.edge[4].dest =5;
	graph.edge[4].weight=34;
	graph.edge[5].src =5;
	graph.edge[5].dest =6;
	graph.edge[5].weight=1;
	graph.edge[6].src =6;
	graph.edge[6].dest =4;
	graph.edge[6].weight=4;
	graph.edge[7].src =6;
	graph.edge[7].dest =2;
	graph.edge[7].weight=3;
	graph.edge[8].src =5;
	graph.edge[8].dest =0;
	graph.edge[8].weight=2;
	
	graph.mst();
}
Kruskals(int v, int e){
	V= v;
	E= e;
	edge= new Edge[E];
	for(int i=0; i<e;i++) {
		edge[i]= new Edge();
	}
}
class subset{
	int parent, rank;
}
int find(subset subsets[], int i) {
	
	if(subsets[i].parent != i)
		subsets[i].parent = find(subsets, subsets[i].parent);
	return subsets[i].parent;
}
void union(subset subsets[], int x, int y) {
	int xroot= find(subsets, x);
	int yroot= find(subsets, y);
	if(subsets[xroot].rank<subsets[yroot].rank)
		subsets[xroot].parent=yroot;
	else if(subsets[xroot].rank>subsets[yroot].rank)
		subsets[yroot].parent=xroot;
	else {
		subsets[yroot].parent=xroot;
		subsets[xroot].rank++;
	}
}

void mst() {
	int e=0;
	int i=0;
	Edge tree[]= new Edge[V];
	for(i=0;i<V;i++) {
		tree[i]= new Edge();
	}
	Arrays.sort(edge);
	subset subsets[]= new subset[V];
	for(i=0; i<V; i++) {
		subsets[i]= new subset();
	}
	for(int v=0; v<V; v++) {
		subsets[v].parent = v;
		subsets[v].rank=0;
	}
	i=0;
	while(e<V-1) {
		Edge nextEdge= new Edge();
		nextEdge= edge[i++];
		
		int srcRoot=find(subsets, nextEdge.src);
		int destRoot= find(subsets, nextEdge.dest);
		if(srcRoot != destRoot) {
			tree[e++]= nextEdge;
			union(subsets, srcRoot, destRoot);
		}
			
	}
	System.out.println("The minimum spanning is");
	for(i=0; i<e;i++) {
		System.out.println(tree[i].src+" " +tree[i].dest + " "+tree[i].weight);
	}
}
}
