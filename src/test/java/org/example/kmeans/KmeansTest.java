package org.example.kmeans;

import org.example.kmeans.DistanciaEuclidiana;
import org.example.kmeans.Kmeans;
import org.example.model.Artista;
import org.example.model.Centro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class KmeansTest {

    @Test
    void testKmeans() {
        Artista[] artistas = new Artista[]{
                new Artista("artista1", Map.of("feature1", 1.0, "feature2", 2.0)),
                new Artista("artista2", Map.of("feature1", 2.0, "feature2", 3.0)),
                new Artista("artista3", Map.of("feature1", 3.0, "feature2", 4.0)),
                new Artista("artista4", Map.of("feature1", 4.0, "feature2", 5.0))
        };
        List<Artista> listaArtistas = List.of(artistas);
        Map<Centro, List<Artista>> clusters = Kmeans.ajustar(listaArtistas, 2, new DistanciaEuclidiana(), 1000);

        Centro centro1 = new Centro(Map.of("feature1", 1.5, "feature2", 2.5));
        Centro centro2 = new Centro(Map.of("feature1", 3.5, "feature2", 4.5));
        List<Artista> cluster1 = List.of(artistas[0], artistas[1]);
        List<Artista> cluster2 = List.of(artistas[2], artistas[3]);

        Assertions.assertEquals(cluster1, clusters.get(centro1));
        Assertions.assertEquals(cluster2, clusters.get(centro2));
    }
}
