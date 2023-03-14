package assign07;

import java.sql.Array;
import java.util.*;

/**
 * Represents a sparse, unweighted, directed graph (a set of vertices and a set of edges). 
 * The graph is not generic and assumes that a string name is stored at each vertex.
 * 
 * @author Erin Parker
 * @version March 3, 2022
 */
public class Graph<T> {

	// the graph -- a set of vertices (String name mapped to Vertex instance)
	private HashMap<T, Vertex<T>> vertices;

	/**
	 * Constructs an empty graph.
	 */
	public Graph() {
		vertices = new HashMap<T, Vertex<T>>();
	}

	/**
	 * Adds to the graph a directed edge from the vertex with name "name1" 
	 * to the vertex with name "name2".  (If either vertex does not already 
	 * exist in the graph, it is added.)
	 * 
	 * @param name1 - string name for source vertex
	 * @param name2 - string name for destination vertex
	 */
	public void addEdge(T name1, T name2) {
		Vertex<T> vertex1;
		// if vertex already exists in graph, get its object
		if(vertices.containsKey(name1))
			vertex1 = vertices.get(name1);
		// else, create a new object and add to graph
		else {
			vertex1 = new Vertex<T>(name1);
			vertices.put(name1, vertex1);
		}

		Vertex<T> vertex2;
		if(vertices.containsKey(name2))
			vertex2 = vertices.get(name2);
		else {
			vertex2 = new Vertex<T>(name2);
			vertices.put(name2, vertex2);
		}

		// add new directed edge from vertex1 to vertex2
		vertex1.addEdge(vertex2);
	}
	
	/**
	 * Generates the DOT encoding of this graph as string, which can be 
	 * pasted into http://www.webgraphviz.com to produce a visualization.
	 */
	public String generateDot() {
		StringBuilder dot = new StringBuilder("digraph d {\n");
		
		// for every vertex 
		for(Vertex<T> v : vertices.values()) {
			// for every edge
			Iterator<Edge> edges = v.edges();
			while(edges.hasNext()) 
				dot.append("\t\"" + v.getName() + "\" -> \"" + edges.next() + "\"\n");
			
		}
		
		return dot.toString() + "}";
	}
	
	/**
	 * Generates a simple textual representation of this graph.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for(Vertex<T> v : vertices.values())
			result.append(v + "\n");
		
		return result.toString();
	}

	public static boolean DFS(List<Vertex> nodes,List<Edge> edges,Vertex start,Vertex target) {
		start.visited = true;
		if(start.getName().equals(target.getName()))
			return true;
		while(start.edges().hasNext()) {
			if (!((Edge) start.edges().next()).getOtherVertex().visited) {
				  return DFS(nodes, edges,((Edge) start.edges().next()).getOtherVertex() , target);

			}
		}
		return false;
	}
	public static List<Vertex> BFS(List<Vertex> nodes,List<Edge> edges,Vertex start,Vertex target){
		Queue<Vertex> nodesToVisit = new LinkedList();
		for(Vertex v:nodes){
			v.visited=false;
			v.cameFrom=null;
			nodesToVisit.offer(v);
		}
		Vertex n;
		while(!nodesToVisit.isEmpty()){
			n=nodesToVisit.poll();
			n.visited=true;
			if(n.equals(target)){
				return reconstructPath(start,target);
			}
			while(n.edges().hasNext()){
				Vertex neighbor=((Edge)n.edges().next()).getOtherVertex();
				if(neighbor.visited=false){
					neighbor.cameFrom=n;
					neighbor.visited=true;
					nodesToVisit.offer(neighbor);

				}
			}
		}
		return null;
	}
	private static List<Vertex> reconstructPath(Vertex start, Vertex target){
		Stack path = new Stack();
		for(Vertex node=target;node!=start;node=node.cameFrom){
			path.push(node);
		}
		path.add(start);
		ArrayList ret = new ArrayList();
		while(!path.isEmpty()){
			ret.add(path.pop());
		}
		return ret;
	}
}