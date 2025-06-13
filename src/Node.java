import java.util.List;

public class Node extends GraphItem{

    private List<Edge> edges;
    private Graph graph;

    protected Node(String name) {
        super(name);
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public Graph getGraph(){
        return graph;
    }

    public int degree(){
        return 0;
    }

    protected void addEdge(Edge e){
        this.edges.add(e);
    }

}
