package org.example.whale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WhaleOptimizerTest {

    WhaleOptimizer optimizer;

    @BeforeEach
    void setUp() {
        // Criar um otimizador com parâmetros de teste
        optimizer = new WhaleOptimizer(50, 10, 30);
    }

    @Test
    void testConstructorInitialization() {
        // Verifica se o construtor inicializou os parâmetros corretamente
        assertEquals(50, optimizer.iterations);
        assertEquals(10, optimizer.popSize);
        assertEquals(30, optimizer.dimensions);
    }

    @Test
    void testPositionInitializationWithinBounds() {
        // Verificar se as posições foram inicializadas dentro dos limites (lb, ub)
        for (int i = 0; i < optimizer.popSize; i++) {
            for (int j = 0; j < optimizer.dimensions; j++) {
                assertTrue(optimizer.positions[i][j] >= optimizer.lb && optimizer.positions[i][j] <= optimizer.ub,
                        "Posição fora dos limites");
            }
        }
    }

    @Test
    void testFitnessInitialization() {
        // Verificar se o fitness foi inicializado corretamente
        for (int i = 0; i < optimizer.popSize; i++) {
            assertTrue(optimizer.fitness[i] > 0, "Fitness deve ser maior que zero");
        }
    }

    @Test
    void testCreateObject() {
        WhaleOptimizer wo = new WhaleOptimizer(50, 10, 30);
        wo.optimze();

        assertTrue(wo instanceof WhaleOptimizer);
    }





}
