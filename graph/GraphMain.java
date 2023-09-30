package graph;

import graph.MST.Kruskal;
import graph.MST.Prim;
import graph.Pathfinding.DFS;

public class GraphMain<V, E> {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        GraphInitializer.initialize(graph);

        for (Object vertex: graph.vertices()){

            System.out.println("Vertex: " + vertex);
            System.out.println("Neighbours: " + graph.getNeighbours(vertex));
            System.out.println("Adjacent edges: " + graph.adjacentEdges(vertex));
            for (Object neighbor : graph.getNeighbours(vertex)){
                Integer weight = (Integer) graph.getWeight(vertex, neighbor);

                System.out.println(vertex + " -- " + weight + " -- " + neighbor);

            }
        }


        DFS dfs = new DFS(graph);
        
        System.out.println("Distance: " + dfs.distance);
        System.out.println("Cycles: " + dfs.cycles);
        System.out.println("Connected edges: "+ dfs.edges);
        System.out.println("Path to 75: " + dfs.pathTo(75));
        
    }
}
