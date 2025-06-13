import java.util.List;

import java.util.*;

public class Path implements Iterable<GraphItem> {
    private final Node start;
    private final Node end;
    private final List<Edge> edges;

    public Path(Node start, List<Edge> edges) {
        if (start == null || edges == null)
            throw new IllegalArgumentException("Startknoten oder Kantenliste ist null");

        Node cur = start;
        for (Edge e : edges) {
            if (!e.getNodes().contains(cur)) {
                throw new IllegalArgumentException("Ungültiger Pfad: Kante " + e + " ist nicht mit " + cur + " verbunden.");
            }
            cur = e.other(cur);
        }

        this.start = start;
        this.edges = List.copyOf(edges);  // defensive Kopie (optional)
        this.end = cur;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean isEulerPath() {
        return edges.size() == start.getGraph().getEdges().size()
               && Set.copyOf(edges).size() == edges.size();
    }

    public boolean isEulerCircle() {
        return start == end && isEulerPath();
    }

    @Override
    public Iterator<GraphItem> iterator() {
        return new Iterator<>() {
            private Node nextNode = start;
            private boolean useNextNode = true;
            private final Iterator<Edge> edgeIterator = edges.iterator();

            @Override
            public boolean hasNext() {
                return useNextNode || edgeIterator.hasNext();
            }

            @Override
            public GraphItem next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                if (useNextNode) {
                    useNextNode = false;
                    return nextNode;
                }

                Edge e = edgeIterator.next();
                nextNode = e.other(nextNode);
                useNextNode = true;
                return e;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(start.getName());

        Node current = start;
        for (Edge edge : edges) {
            sb.append(" -> ").append(edge.getName());
            current = edge.other(current);
            sb.append(" -> ").append(current.getName());
        }

        return sb.toString();
    }
}


