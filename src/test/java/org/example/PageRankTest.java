package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PageRankTest {

    int[][] paginas = {
            { 0,1,0,0,0 },
            { 0,0,0,0,1 },
            { 1,1,0,1,1 },
            { 0,0,1,0,1 },
            { 0,0,0,1,0 }
    };

    double[] resultadoEsperado = {0.17125, 0.21375000000000002, 0.25625000000000003, 0.46875, 0.49000000000000005};

    @Test
    void calculoPageRank() {

        double[] resultado = PageRank.calculaRankingPagina(paginas);
        assertArrayEquals(resultadoEsperado, resultado, "Não calculou o Ranking Corretamente");

    }
}
