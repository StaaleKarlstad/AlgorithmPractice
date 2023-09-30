import java.util.ArrayList;

/* Et binært søketre er en datastruktur bygget opp av noder, der hver node kan ha to barn.
 * Det venstre barnet er alltid mindre enn forelderen, mens det høyre alltid er større.
 * Input-rekkefølgen dikterer hvordan treet blir strukturert.
 * Søking starter på root og tar stort sett log(n) tid, med mindre treet blir bygget opp av en sortert mengde
 * Eks [1,2,3,4,5,6]
 * 
 * - Her vil 1 ta rollen som root
 * - 2 blir det høyre barnet til root
 * - 3 blir det høyre barnet til 2
 * - 4 blir det høyre barnet til 3
 * - 5 blir det høyre barnet til 4
 * - 6 blir det høyre barnet til 5
 * 
 * Søking etter det største elementet vil derfor ta O(n) tid
*/

public class BinarySearchTree<T> {   
    Node root;

//================WHILE-LOOP=======================================
    
    public void addNode(String name, int key){
        Node newNode = new Node(name, key);       
        if (root == null){
            root = newNode;
            return;
        }                      
        Node focusNode = root;            
        
        while (true){
            if (key < focusNode.key){
                if (focusNode.leftChild == null){
                    focusNode.leftChild = newNode;
                    return;
                }
                focusNode = focusNode.leftChild;               
            }           
            else {
                if (focusNode.rightChild == null){
                    focusNode.rightChild = newNode;
                    return;
                }
                focusNode = focusNode.rightChild;                
            }
        }
        }

//==========================RECURSIVE==============================================

        public void addNodeRecursive(String name, int key){
            Node newNode = new Node(name, key);
            root = addNodeRecursive(root, newNode);
        }

        public Node addNodeRecursive(Node current, Node newNode){
            if (current == null){
                return newNode;}
            if (newNode.key < current.key){
                current.leftChild = addNodeRecursive(current.leftChild, newNode);
            }
            else if (newNode.key >= current.key){
                current.rightChild = addNodeRecursive(current.rightChild, newNode);
            }
            return current;
        }

//======================================================================================        
        
    public ArrayList<Node> inOrderTraverse(Node focusNode, ArrayList<Node> nodes){            
            if (focusNode != null){
                inOrderTraverse(focusNode.leftChild, nodes);
                nodes.add(focusNode);
                inOrderTraverse(focusNode.rightChild, nodes);
            }
            return nodes;            
        }

        public Node smallest(){
            Node currentNode = root;
            while (true){
                if (currentNode.leftChild == null){
                    return currentNode;
                }
                currentNode = currentNode.leftChild;   
            }
        }
           
        public class Node{
        String name;
        int key;
        Node leftChild;
        Node rightChild;

        public Node(String name, int key){
            this.name = name;
            this.key = key;
        }
        public String toString(){
            return "Name: " + name + " - Value: " + key;
        }
    }
}

    

