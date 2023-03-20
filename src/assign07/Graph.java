package assign07;

import java.sql.Array;
import java.util.*;

/**
 * Represents a sparse, unweighted, directed graph (a set of vertices and a set of edges). 
 * The graph is not generic and assumes that a string name is stored at each vertex.
 * 
 * @author Erin Parker Jonathan Kerr and Eden Harvey
 * @version March 3, 2022
 */
public class Graph<T> {

	// the graph -- a set of vertices (String name mapped to Vertex instance)
	private HashMap<T, Vertex<T>> vertices;
	private boolean tf;

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
	public boolean DFS(T start,T target){
		tf=false;
		for(Vertex<T> v: vertices.values()){
			v.visited = false;
			v.cameFrom = null;
		}
		DFSUtil(start,target);
		return tf;
	}

	/**
	 * Recursively checks all edges from a vertex, skipping ones that have been visited
	 * @param start start data
	 * @param target target data
	 */
	public void DFSUtil(T start,T target) {

		Vertex<T> startVert =  vertices.get(start);
		Vertex<T> tarVert = vertices.get(target);
		startVert.visited = true;
		Iterator<Edge> itr = startVert.edges();
		if(startVert.getName().equals(tarVert.getName()))
			tf=true;
		while(itr.hasNext()) {
			Vertex<T> n = itr.next().getOtherVertex();
			if(!n.visited){
				  DFSUtil(n.getName(), target);
			}
		}
	}

	/**
	 * Returns a list of T that represents the shortest path between start and target
	 * tries a different path between each line
	 * @param start start data
	 * @param target start data
	 * @return List of T
	 */
	public List<T> BFS(T start,T target){
		Queue<Vertex<T>> nodesToVisit = new LinkedList<>();
		for(Vertex<T> v: vertices.values()) {
			v.visited = false;
			v.cameFrom = null;
		}
		nodesToVisit.offer(vertices.get(start));
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
		throw new IllegalArgumentException();
	}

	/**
	 * Generates a list of T that represents the path from start to target, using the cameFrom field in the
	 * Vertex class
	 * @param start starting data
	 * @param target target data
	 * @return
	 */
	private List<T> reconstructPath(T start, T target){
		Stack<T> path = new Stack<>();
		Vertex<T> startVert = vertices.get(start);
		Vertex<T> tarVert = vertices.get(target);
		for(Vertex<T> node=tarVert;node!=startVert;node=node.cameFrom){
			if(node==null){
				throw new IllegalArgumentException();
			}
			path.push(node.getName());
		}
		path.push(startVert.getName());
		List<T> ret = new ArrayList<>();
		while(!path.isEmpty()){
			ret.add(path.pop());
		}
		return ret;
	}

	/**
	 * Generates a list of Vertices that are in order of inDegree
	 * @return List<T>
	 */
	public List<T> topoSort(){
		Queue<Vertex<T>> doableTasks = new LinkedList<>();
		List<T> output = new ArrayList<>();
		for(Vertex<T> task: vertices.values()){
			if(task.getInDegree()==0)
				doableTasks.offer(task);
		}
		while(!doableTasks.isEmpty()){
			var task = doableTasks.poll();
			output.add(task.getName());
			Iterator<Edge> itr= task.edges();
			while(itr.hasNext()){
				Edge temp = itr.next();
				var neighbor = temp.getOtherVertex();
				neighbor.decrementInDegree();
				if(neighbor.getInDegree()==0) {
					doableTasks.offer(neighbor);
				} else {
					itr=neighbor.edges();
				}
			}
		}
		return output;
	}
	public boolean isCyclic(T start){
		vertices.get(start);
		for (Vertex v: vertices.values()) {
			v.visited=false;
		}
		return cyclicUtil(vertices.get(start));

	}
	private boolean cyclicUtil(Vertex v){
		if(v.visited==true){
			return true;
		} else {
			v.visited=true;
			Iterator itr = v.edges();
			while(itr.hasNext()){
				return cyclicUtil(((Edge)itr.next()).getOtherVertex());
			}
		}
		return false;
	}
}