package org.example.kmeans;

import java.util.Map;

public class DistanciaEuclidiana implements Distancia {

    @Override
    public double calcular(Map<String, Double> f1, Map<String, Double> f2) {
        double soma = 0;
        for (Map.Entry<String, Double> entry : f1.entrySet()) {
            Double v1 = entry.getValue();
            Double v2 = f2.get(entry.getKey());
            if (v1 != null && v2 != null) {
                soma += Math.pow(v1 - v2, 2);
            }
        }

        return Math.sqrt(soma);
    }


}
