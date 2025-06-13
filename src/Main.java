public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

          Graph graph = new Graph();
//        Node A = new Node("A");
//        Node B = new Node("B");
//        Node C = new Node("C");
//        Node D = new Node("D");
//
//        Edge a = new Edge("a",A,B);
//        Edge b = new Edge("b",A,B);
//        Edge c = new Edge("c",A,C);
//        Edge d = new Edge("d",A,C);
//        Edge e = new Edge("e",A,D);
//        Edge f = new Edge("f",B,D);
//        Edge g = new Edge("g",C,D);

        Node A = graph.addNode("A");
        Node B = graph.addNode("B");

        graph.addEdge("a",A,B);


    }
}