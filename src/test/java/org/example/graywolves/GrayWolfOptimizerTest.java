package org.example.graywolves;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




class GrayWolfOptimizerTest {

    private GrayWolfOptimizer optimizer;
    private int iterations = 50;
    private int popSize = 10;
    private int dimensions = 30;

    @BeforeEach
    public void setUp() {
        // Configura a instância de GrayWolfOptimizer
        optimizer = new GrayWolfOptimizer(iterations, popSize, dimensions);
    }

    @Test

    void testConstructorInitializesCorrectly() {
        // Testa se o construtor inicializa corretamente as variáveis
        assertEquals(iterations, optimizer.iterations);
        assertEquals(popSize, optimizer.popSize);
        assertEquals(dimensions, optimizer.dimensions);
        assertNotNull(optimizer.positions);
        assertNotNull(optimizer.fitness);
        assertNotNull(optimizer.alphaPosition);
        assertNotNull(optimizer.betaPosition);
        assertNotNull(optimizer.deltaPosition);

        // Testa se os valores iniciais das posições estão no intervalo correto
        for (int i = 0; i < popSize; i++) {
            for (int j = 0; j < dimensions; j++) {
                assertTrue(optimizer.positions[i][j] >= optimizer.lb && optimizer.positions[i][j] <= optimizer.ub);
            }
        }
    }


    @Test

    void testeObjeto() {
        GrayWolfOptimizer gwo = new GrayWolfOptimizer(50, 10, 30);
        gwo.optimize();

        assertTrue(gwo instanceof GrayWolfOptimizer);

    }
}
