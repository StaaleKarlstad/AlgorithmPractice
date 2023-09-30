package Graph.MST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import Graph.Edge;
import Graph.WeightedGraph;

public class Prim<V, E> {
    
    public static <V, E extends Comparable<E>> List<Edge<V>> mst(WeightedGraph<V, E> graph){

        List<Edge<V>> tree = new ArrayList<Edge<V>>();
        Set<V> visited = new HashSet<V>();
        Queue<Edge<V>> toCheck = new PriorityQueue<Edge<V>>(graph);
        
        V first = graph.getFirstNode();
        visited.add(first);

        addNeighbours(graph, toCheck, first);

        while (!toCheck.isEmpty()){
            Edge<V> lightest = toCheck.poll();
            V current = lightest.b;

            if (visited.contains(current)) continue;

            visited.add(current);
            tree.add(lightest);

            addNeighbours(graph, toCheck, current);
        }

        return tree;
    }

    private static <V, E extends Comparable<E>> void addNeighbours(WeightedGraph<V, E> graph, Queue<Edge<V>> toCheck, V node){

        for (V neighbour: graph.getNeighbours(node)){
            toCheck.add(new Edge<V>(node, neighbour));
        }
    }
}
