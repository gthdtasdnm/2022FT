import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    @Test
    public void testEulerCircleValid() {
        Graph g = new Graph();
        Node a = g.addNode("A");
        Node b = g.addNode("B");
        Node c = g.addNode("C");

        Edge e1 = g.addEdge("e1", a, b);
        Edge e2 = g.addEdge("e2", b, c);
        Edge e3 = g.addEdge("e3", c, a);

        Path pfad = new Path(a, List.of(e1, e2, e3));

        assertTrue(pfad.isEulerPath());
        assertTrue(pfad.isEulerCircle());
        assertEquals(a, pfad.getStart());
        assertEquals(a, pfad.getEnd());
        assertEquals(3, pfad.getEdges().size());
    }

    @Test
    public void testNotEulerPath_missingEdge() {
        Graph g = new Graph();
        Node a = g.addNode("A");
        Node b = g.addNode("B");
        Node c = g.addNode("C");

        Edge e1 = g.addEdge("e1", a, b);
        Edge e2 = g.addEdge("e2", b, c);
        g.addEdge("e3", c, a); // nicht verwendet

        Path pfad = new Path(a, List.of(e1, e2));

        assertFalse(pfad.isEulerPath());
        assertFalse(pfad.isEulerCircle());
    }

    @Test
    public void testInvalidPath_wrongEdgeStart() {
        Graph g = new Graph();
        Node a = g.addNode("A");
        Node b = g.addNode("B");
        Node c = g.addNode("C");

        g.addEdge("e1", a, b);
        Edge e2 = g.addEdge("e2", b, c);

        // e2 passt nicht zu Startknoten a → Exception erwartet
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Path(a, List.of(e2));
        });

        assertTrue(exception.getMessage().contains("Ungültiger Pfad"));
    }

    @Test
    public void testIteratorSequence() {
        Graph g = new Graph();
        Node a = g.addNode("A");
        Node b = g.addNode("B");
        Node c = g.addNode("C");

        Edge e1 = g.addEdge("e1", a, b);
        Edge e2 = g.addEdge("e2", b, c);

        Path pfad = new Path(a, List.of(e1, e2));

        StringBuilder result = new StringBuilder();
        for (GraphItem item : pfad) {
            result.append(item.getName()).append(" ");
        }

        assertEquals("A e1 B e2 C ", result.toString());
    }
}
