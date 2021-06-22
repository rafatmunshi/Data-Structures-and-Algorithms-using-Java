package ds;

public class Dijkstras {
	static final int V = 10; 
	void shortestPath(int graph[][], int src) {
		int dist[]= new int[V];
		Boolean sptSet[] = new Boolean[V];
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		dist[src]=0;
		for(int i=0; i<V-1;i++) {
			int u= minDistance(dist, sptSet);
			sptSet[u]=true;
			for(int v=0; v<V; v++) {
				if(!sptSet[v] && graph[u][v] !=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
					dist[v]= dist[u]+graph[u][v];
			}
			
		}
		System.out.println("Shortest path distances for all vertices-");
		for(int v=0; v<V; v++) {
			System.out.println(v +" "+ dist[v]);
		}
	}
int minDistance(int dist[], Boolean sptSet[]) {
	int min= Integer.MAX_VALUE, vertexIndex= -1;
	for(int i=0; i<V;i++) {
		if(sptSet[i]==false && dist[i]<=min) {
			min= dist[i];
			vertexIndex=i;
		}
	}
	return vertexIndex;
}
    public static void main(String[] args) 
    { 

        int graph[][] = new int[][] { { 0, 85, 217, 0, 173, 0, 0, 0, 0, 0 }, 
                                      { 85, 0, 0, 0, 0, 80, 0, 0, 0, 0 }, 
                                      { 217, 0, 0, 0, 0, 0, 186, 103, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 0, 0, 183, 0, 0 }, 
                                      { 173, 0, 0, 0, 0, 0, 0, 0, 0, 502 }, 
                                      { 0, 80, 0, 0, 0, 0, 0, 0, 250, 0 }, 
                                      { 186, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                                      { 0, 0, 103, 183, 0, 0, 0, 0, 0, 167 }, 
                                      { 0, 0, 0, 0, 0, 250, 0, 0, 0, 84 },
                                      { 0, 0, 0, 0, 502, 0, 0, 167, 84, 0 }}; 
        Dijkstras t = new Dijkstras(); 
        t.shortestPath(graph, 0); 
    } 
}
