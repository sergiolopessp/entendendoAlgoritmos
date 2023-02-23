package org.example;

import org.example.model.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class VertexTest {

    @Test
    void testaEqualsObjetoVertex() {
        Vertex vertex = new Vertex("Teste");
        Vertex comparador = new Vertex("Teste");

        assertEquals(true, vertex.equals(comparador));

    }
}
