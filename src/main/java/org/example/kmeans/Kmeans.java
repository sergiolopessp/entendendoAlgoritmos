package org.example.kmeans;

import org.example.model.Artista;
import org.example.model.Centro;
import java.security.SecureRandom;
import java.util.*;

import static java.util.stream.Collectors.toSet;

public class Kmeans {

    private Kmeans() {
        throw new IllegalStateException("Classe Utilitária, não Instanciar");
    }

    private static final SecureRandom random = new SecureRandom();
    public static Map<Centro, List<Artista>> ajustar(List<Artista> artistas, int k, Distancia distancia, int maxIteracoes) {
        List<Centro> centros = centrosRandomicos(artistas, k);
        Map<Centro, List<Artista>> clusters = new HashMap<>();
        Map<Centro, List<Artista>> ultimaPosicao = new HashMap<>();
        for (int i = 0; i < maxIteracoes; i++) {
            boolean ehUltimaIteracao = i == maxIteracoes - 1;
            for (Artista artista : artistas) {
                Centro centro = centroProximo(artista, centros, distancia);
                clusterDesignado(clusters, artista, centro);
            }
            boolean deveriaEncerrar = ehUltimaIteracao || clusters.equals(ultimaPosicao);
            ultimaPosicao = clusters;
            if (deveriaEncerrar) {
                break;
            }
            centros = centrosRealocados(clusters);
            clusters = new HashMap<>();
        }
        return ultimaPosicao;
    }
    private static List<Centro> centrosRealocados(Map<Centro, List<Artista>> clusters) {
        return clusters.entrySet().stream().map(e -> media(e.getKey(), e.getValue())).toList();
    }
    private static Centro media(Centro centro, List<Artista> artistas) {
        if (artistas == null || artistas.isEmpty()) {
            return centro;
        }
        Map<String, Double> media = centro.getCoordenadas();
        artistas.stream().flatMap(e -> e.getFeatures().keySet().stream())
                .forEach(k -> media.put(k, 0.0));
        for (Artista artista : artistas) {
            artista.getFeatures().forEach(
                    (k, v) -> media.compute(k, (k1, valorAtual) -> v + valorAtual)
            );
        }
        media.forEach((k, v) -> media.put(k, v / artistas.size()));
        return new Centro(media);
    }
    private static void clusterDesignado(Map<Centro, List<Artista>> clusters, Artista artista, Centro centro) {
        clusters.compute(centro, (key, list) -> {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(artista);
            return list;
        });
    }
    private static Centro centroProximo(Artista artista, List<Centro> centros, Distancia distancia) {
        double distanciaMinima = Double.MAX_VALUE;
        Centro proximo = null;
        for (Centro centro : centros) {
            double distanciaAtual = distancia.calcular(artista.getFeatures(), centro.getCoordenadas());
            if (distanciaAtual < distanciaMinima) {
                distanciaMinima = distanciaAtual;
                proximo = centro;
            }
        }
        return proximo;
    }
    private static List<Centro> centrosRandomicos(List<Artista> artistas, int k) {
        List<Centro> centros = new ArrayList<>();
        Map<String, Double> maximos = new HashMap<>();
        Map<String, Double> minimos = new HashMap<>();
        for (Artista artista : artistas) {
            artista.getFeatures().forEach((key, value) -> {
                maximos.compute(key, (k1, max) -> max == null || value > max ? value : max);
                minimos.compute(key, (k1, min) -> min == null || value < min ? value : min);
            });
        }
        Set<String> atributos = artistas.stream()
                .flatMap(e -> e.getFeatures().keySet().stream())
                .collect(toSet());
        for (int i = 0; i < k; i++) {
            Map<String, Double> coordenadas = new HashMap<>();
            for (String atributo : atributos) {
                double maximo = maximos.get(atributo);
                double minimo = minimos.get(atributo);
                coordenadas.put(atributo, random.nextDouble() * (maximo - minimo) + minimo);
            }
            centros.add(new Centro(coordenadas));
        }
        return centros;
    }

}
