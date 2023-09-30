package graph.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import graph.Edge;
import graph.WeightedGraph;

public class Kruskal<V, E> {
   
    public <V, E extends Comparable<E>> List<Edge<V>> mst(WeightedGraph<V, E> graph){
        
        ArrayList<Edge<V>> mst = new ArrayList<Edge<V>>();
        ArrayList<Edge<V>> edges = new ArrayList<Edge<V>>();

        for (Edge<V> edge: graph.edges()){
            //System.out.println(edge);
            edges.add(edge);
        }
           
        Collections.sort(edges, graph);        
        UnionFind uf = new UnionFind(graph.vertices());

        for (Edge<V> edge: edges){
            
            V vertex1 = edge.a;
            V vertex2 = edge.b;

            if (uf.find(vertex1) != (uf.find(vertex2))){
                mst.add(edge);
                uf.union(vertex1, vertex2);
                
            }
        }        
        return mst;
    }    
}
