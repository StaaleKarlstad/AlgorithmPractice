package Graph.MST;

import java.util.HashMap;

public class UnionFind<V, E> {

    public HashMap<V, V> parent = new HashMap<V, V>();
    public HashMap<V, Integer> rank = new HashMap<V, Integer>();

    public UnionFind(Iterable<V> vertices){
        for (V vertex: vertices){
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
            }
        }

        public V find(V vertex){
            if (parent.get(vertex) == vertex){
                return vertex;
            }
            V root = find(parent.get(vertex));
            parent.put(vertex, root);
            return root;
        }

        public void union(V v1, V v2){
            V root1 = parent.get(v1);
            V root2 = parent.get(v2);

            if (root1.equals(root2)) return;

            if (rank.get(root1) < rank.get(root2)){
                parent.put(root1, root2);
            }
            else if (rank.get(root2) < rank.get(root1)){
                parent.put(root2, root1);
            }
            else rank.put(root1, rank.get(root1) + 1);
        }

}
    

