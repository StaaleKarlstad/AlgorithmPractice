package graph;

import java.util.ArrayList;
import java.util.Random;

public class GraphInitializer {    

    static void initialize(WeightedGraph graph){
        for (int i = 0; i < 100; i += 5){
            graph.addVertex((Integer) i);
        }
        
        ArrayList<Object> arr = new ArrayList<Object>();
        for (Object vertex: graph.vertices()){
            arr.add(vertex);
        }

        for (Object vertex: graph.vertices()){
            Random rand = new Random();
            int randomNum = rand.nextInt(3);
            for (int i = 0; i <= randomNum; i++){
                int randomIndex = rand.nextInt(arr.size());
                int randomWeight = rand.nextInt(20);
                
                if (arr.get(randomIndex).equals(vertex)) 
                    continue;
                
                else if (graph.getNeighbours(vertex).contains(arr.get(randomIndex))) 
                    continue;
                
                graph.addEdge(vertex, arr.get(randomIndex), randomWeight);}

        }
    }
}
