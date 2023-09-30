package graph.Pathfinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import graph.Edge;
import graph.WeightedGraph;

public class DFS<V, E extends Comparable<E>> {

    public HashMap<V, Integer> distance;
    public HashSet<V> visited = new HashSet<V>();
    public HashMap<V, Boolean> connected;
    public HashMap<V, V> parent;
    public ArrayList<Edge<V>> edges = new ArrayList<Edge<V>>();
    V source;
    WeightedGraph<V, E> graph;
    public int cycles = 0;

    
    public DFS(WeightedGraph<V, E> graph){
        this.graph = graph;
        this.source = graph.getFirstNode();
        this.distance = new HashMap<V, Integer>();
        this.parent = new HashMap<>();
        this.connected = new HashMap<>();
        parent.put(source, null);
        distance.put(source, 0);

        for (V vertex: graph.vertices()){
            connected.put(vertex, false);
        }

        depthFirst(source);

    }

    private void depthFirst(V source){

        visited.add(source);
        connected.put(source, true);
        
        for (Edge<V> adj: graph.adjacentEdges(source)){
            V destination = adj.b;
            if (visited.contains(destination)){
                if (parent.get(source) != destination){
                    cycles ++;
                }
                continue;
            }
            parent.put(destination, source);
            distance.put(destination, distance.get(source) + 1);
            edges.add(adj);
            depthFirst(destination);
        }
    }

    public List<Edge<V>> pathTo(V node){

        Stack<Edge<V>> path = new Stack(); 
        V nodeParent = parent.get(node);
        path.add(new Edge<V>(node, nodeParent));
        
        while (true){
            V temp = nodeParent;
            nodeParent = parent.get(nodeParent);
            if (nodeParent == null){
                break;
            }
            //System.out.println("parent: " + nodeParent);
            path.add(new Edge<V>(temp, nodeParent));
        }


        return path;
    }
}
