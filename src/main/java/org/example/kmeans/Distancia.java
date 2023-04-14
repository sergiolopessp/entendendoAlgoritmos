package org.example.kmeans;

import java.util.Map;

public interface Distancia {
    double calcular(Map<String, Double> f1, Map<String, Double> f2);
}
