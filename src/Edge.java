import java.util.Set;


public class Edge extends GraphItem {
    private final Node node1;
    private final Node node2;

    Edge(String name, Node node1, Node node2) {
        super(name);
        this.node1 = node1;
        this.node2 = node2;
    }

    public Set<Node> getNodes(){
        return Set.of(node1, node2);
    }

    public Node other(Node n){
        if(n != node1 && n != node2){
            throw new IllegalArgumentException("Knoten ist nicht teil der Kante");
        }else if(n == node1) {
            return node2;
        }else {
            return node1;
        }
    }

    @Override
    public String toString(){
        return super.getName()+"{"+node1.getName()+","+node2.getName()+"}";
    }

}
