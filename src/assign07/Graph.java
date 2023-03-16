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
	public Graph(List<T> sources,List<T> destinations) {
		vertices = new HashMap<T, Vertex<T>>();
		for(int i=0;i<sources.size();i++){
			addEdge(sources.get(i),destinations.get(i));
		}
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
		if(vertices.containsKey(name1)) {
			vertex1 = vertices.get(name1);
		}
		// else, create a new object and add to graph
		else {
			vertex1 = new Vertex<T>(name1);
			vertices.put(name1, vertex1);
		}

		Vertex<T> vertex2;
		if(vertices.containsKey(name2)) {
			vertex2 = vertices.get(name2);
			vertex2.inDegree++;
		}
		else {
			vertex2 = new Vertex<T>(name2);
			vertex2.inDegree++;
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

	public boolean DFS(T start,T target) {
		for(Vertex<T> v: vertices.values()){
			v.visited = false;
			v.cameFrom = null;
		}
		Vertex<T> startVert =  vertices.get(start);
		Vertex<T> tarVert = vertices.get(target);
		startVert.visited = true;
		if(startVert.getName().equals(tarVert.getName()))
			return true;
		while(startVert.edges().hasNext()) {
			if (!((Edge) startVert.edges().next()).getOtherVertex().visited) {
				  return DFS((T)((Edge) startVert.edges().next()).getOtherVertex().getName(), target);

			}
		}
		return false;
	}
	public List<T> BFS(T start,T target){
		Queue<Vertex<T>> nodesToVisit = new LinkedList<>();
		for(Vertex<T> v: vertices.values()) {
			v.visited = false;
			v.cameFrom = null;
			nodesToVisit.offer(v);

		}
		Vertex<T> n;
		while(!nodesToVisit.isEmpty()){
			n=nodesToVisit.poll();
			n.visited=true;
			Iterator<Edge> itr = n.edges();
			if(n.equals(vertices.get(target))){
				return reconstructPath(start,target);
			}
			while(itr.hasNext()){
				Edge<T> temp = itr.next();
				Vertex<T> neighbor=temp.getOtherVertex();
				if(!neighbor.visited){
					neighbor.cameFrom=n;
					neighbor.visited=true;
					nodesToVisit.offer(neighbor);
				}
			}
		}
		return null;
	}
	private List<T> reconstructPath(T start, T target){
		Stack<T> path = new Stack<>();
		Vertex<T> startVert = vertices.get(start);
		Vertex<T> tarVert = vertices.get(target);
		for(Vertex<T> node=tarVert;node!=startVert;node=node.cameFrom){
			path.push(node.getName());
		}
		path.push(startVert.getName());
		List<T> ret = new ArrayList<>();
		while(!path.isEmpty()){
			ret.add(path.pop());
		}
		return ret;
	}

	public List<Vertex<T>> topoSort(){
		Queue<Vertex<T>> doableTasks = new LinkedList<>();
		List<Vertex<T>> output = new ArrayList<>();
		for(Vertex<T> task: vertices.values()){
			if(task.getInDegree()==0)
				doableTasks.offer(task);
		}
		while(!doableTasks.isEmpty()){
			var task = doableTasks.poll();
			output.add(task);
			Iterator<Edge> itr= task.edges();
			while(itr.hasNext()){
				Edge temp = itr.next();
				var neighbor = temp.getOtherVertex();
				neighbor.decrementInDegree();
				if(neighbor.getInDegree()==0)
					doableTasks.offer(neighbor);
			}
		}
		return output;
	}
}