package org.example.kmeans;

import org.example.kmeans.DistanciaEuclidiana;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class DistanciaEuclidianaTest {
    private Map<String, Double> f1;
    private Map<String, Double> f2;
    private DistanciaEuclidiana distancia = new DistanciaEuclidiana();

    @Test
    void calcularDistancia() {
        f1 = new HashMap<>();
        f1.put("x", 1.0);
        f1.put("y", 2.0);

        f2 = new HashMap<>();
        f2.put("x", 2.0);
        f2.put("y", 3.0);

        double resultado = distancia.calcular(f1, f2);
        assertEquals( 1.4142135623730951, resultado, 0.01);
    }

}
