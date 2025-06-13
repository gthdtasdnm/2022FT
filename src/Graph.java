import java.util.List;
import java.util.ArrayList;

public class Graph {
    private final List<Node> nodes = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();
    public List<Node> getNodes() { return nodes; }
    public List<Edge> getEdges() { return edges; }

    protected Node addNode(String name){
        Node n = new Node(this, name);
        nodes.add(n);
        return n;
    }

    protected Edge addEdge(String name, Node n1, Node n2){
        if(n1 == n2){
            throw new IllegalArgumentException("Schleife");
        }else{
            Edge e = new Edge(name,n1,n2);
            edges.add(e);
            n1.addEdge(e);
            n2.addEdge(e);
            return e;
        }
    }
}
