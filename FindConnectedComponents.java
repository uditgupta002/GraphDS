import java.util.LinkedList;

/*
 * This program finds and optionally prints all the connected components in a given graph.
 * Time Complexity : O(V + E) as the graph starts from all the possible vertices and traverses all the edges atleast once. 
 * 
 * 
 * */


public class FindConnectedComponents {

    public static void main(String[] args) {

	Graph g = new Graph(5);
	g.addEdge(1, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 4);

	System.out.println("Number of connected components : " + connectedComponents(g,true));
    }

    public static int connectedComponents(Graph graph,boolean printPaths) {

	int count = 0;
	boolean[] visited = new boolean[graph.vertices];
	for (int i = 0; i < graph.vertices; i++) {
	    if (!visited[i]) {
		count++;
		performDFS(graph, i, visited,printPaths);
		System.out.println();
	    }
	}
	return count;
    }

    public static void performDFS(Graph graph, int currentNode, boolean[] visited,boolean  printPaths) {

	if (visited[currentNode])
	    return;

	visited[currentNode] = true;
	if(printPaths)
	    System.out.print(currentNode + " ");
	
	for (Integer neighbourNode : graph.edges[currentNode]) {
	    performDFS(graph, neighbourNode, visited,printPaths);
	}
    }

    private static class Graph {

	int vertices;
	LinkedList<Integer>[] edges;

	public Graph(int vertices) {
	    this.vertices = vertices;
	    this.edges = new LinkedList[this.vertices];
	}

	public void addEdge(int source, int destination) {

	    if (this.edges[source] == null)
		this.edges[source] = new LinkedList<>();

	    if (this.edges[destination] == null)
		this.edges[destination] = new LinkedList<>();

	    this.edges[source].add(destination);
	    this.edges[destination].add(source);
	}

	public void removeEdge(int source, int destination) {

	    if (this.edges[source] == null || this.edges[destination] == null)
		return;

	    this.edges[source].remove(destination);
	    this.edges[destination].remove(source);

	}
    }
}
