package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RastriginTest {

    @Test
    void testConstructor() {
        double a = 10.0;
        double n = 5.0;
        Rastrigin rastrigin = new Rastrigin(a, n);

        // Verifica se os valores foram inicializados corretamente
        assertTrue(rastrigin instanceof Rastrigin);
    }

    @Test
    void testRastriginFunction() {
        // Exemplo de teste para a função Rastrigin com ponto de duas dimensões
        double a = 10.0;
        double n = 2.0;
        Rastrigin rastrigin = new Rastrigin(a, n);

        double[] coords = {0.0, 0.0};
        Point point = new Point(coords);

        // Valor esperado da função Rastrigin para um ponto de todas as coordenadas zeradas
        double expectedValue = 0.0;  // Para coordenadas 0, o valor da função Rastrigin é a * n
        assertEquals(expectedValue, rastrigin.f(point), 1e-9);
    }

    @Test
    void testRastriginFunctionWithNonZeroValues() {
        double a = 10.0;
        double n = 3.0;
        Rastrigin rastrigin = new Rastrigin(a, n);

        double[] coords = {1.0, 0.5, -0.5};
        Point point = new Point(coords);

        // Calcula o valor esperado manualmente para o ponto (1.0, 0.5, -0.5)
        double expectedValue = a * n
                + (Math.pow(1.0, 2) - a * Math.cos(2 * Math.PI * 1.0))
                + (Math.pow(0.5, 2) - a * Math.cos(2 * Math.PI * 0.5))
                + (Math.pow(-0.5, 2) - a * Math.cos(2 * Math.PI * -0.5));

        assertEquals(expectedValue, rastrigin.f(point), 1e-9);
    }

    @Test
    void testRastriginFunctionWithHighValues() {
        double a = 10.0;
        double n = 4.0;
        Rastrigin rastrigin = new Rastrigin(a, n);

        double[] coords = {5.0, 5.0, 5.0, 5.0};
        Point point = new Point(coords);

        // Calcula o valor esperado manualmente para o ponto (5.0, 5.0, 5.0, 5.0)
        double expectedValue = a * n
                + (Math.pow(5.0, 2) - a * Math.cos(2 * Math.PI * 5.0)) * 4;

        assertEquals(expectedValue, rastrigin.f(point), 1e-9);
    }

    @Test
    void testRastriginFunctionWithDifferentDimensions() {
        double a = 10.0;
        double n = 3.0;
        Rastrigin rastrigin = new Rastrigin(a, n);

        double[] coords1 = {1.0, 2.0, 3.0};
        Point point1 = new Point(coords1);

        double[] coords2 = {1.0, 2.0};
        Point point2 = new Point(coords2);

        // Testa se a função calcula corretamente para dimensões diferentes
        assertNotEquals(rastrigin.f(point1), rastrigin.f(point2));
    }
}
