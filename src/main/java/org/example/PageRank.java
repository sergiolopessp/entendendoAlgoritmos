package org.example;

class PageRank {

    private PageRank() {

    }

    static final double DAMPING_FACTOR = 0.85;
    public static double[] calculaRankingPagina(int[][] paginasRankear) {

        int quantidadePaginas = paginasRankear.length;
        double[] resultadoRanking = new double[quantidadePaginas];
        double[] resultadoTemporario = new double[quantidadePaginas];
        final double initialPageRank = ((double) 1) / quantidadePaginas;
        final int qtdTotalIteracoes = quantidadePaginas - 1;
        int iteracoes = 1;

        while (iteracoes <= qtdTotalIteracoes) {
            if (iteracoes == 1) {
                setaRankInicial(quantidadePaginas, resultadoRanking, initialPageRank);
            } else if (iteracoes == qtdTotalIteracoes) {
                calculaDumpingFactor(quantidadePaginas, resultadoRanking);
            } else {
                trocaArrayTemporario(quantidadePaginas, resultadoRanking, resultadoTemporario);
                calculoRankingDinamico(paginasRankear, quantidadePaginas, resultadoRanking, resultadoTemporario);
            }
            iteracoes++;
        }
        return resultadoRanking;
    }

    private static void calculoRankingDinamico(int[][] paginasRankear, int quantidadePaginas, double[] resultadoRanking, double[] resultadoTemporario) {

        for (int coluna = 0; coluna < quantidadePaginas; coluna++) {
            for (int linha = 0; linha < quantidadePaginas; linha++) {
                if (paginasRankear[linha][coluna] == 1) {
                    int linkSaida = getLinkSaida(paginasRankear, quantidadePaginas, linha);
                    calculaPageRankIntermediario(resultadoRanking, resultadoTemporario, coluna, linha, linkSaida);
                }
            }
        }
    }

    private static void calculaPageRankIntermediario(double[] resultadoRanking, double[] resultadoTemporario, int coluna, int linha, int linkSaida) {
            resultadoRanking[coluna] += resultadoTemporario[linha] *  1 / linkSaida;
    }

    private static int getLinkSaida(int[][] paginasRankear, int quantidadePaginas, int linha) {
        int j = 0;
        int linkSaida = 0;
        while (j < quantidadePaginas) {
            if (paginasRankear[linha][j] == 1) {
                linkSaida++;
            }
            j++;
        }
        return linkSaida;
    }

    private static void calculaDumpingFactor(int quantidadePaginas, double[] resultadoRanking) {
        for (int k = 0; k < quantidadePaginas; k++) {
            resultadoRanking[k] = (1 - DAMPING_FACTOR) + DAMPING_FACTOR * resultadoRanking[k];
        }
    }

    private static void trocaArrayTemporario(int quantidadePaginas, double[] resultadoRanking, double[] resultadoTemporario) {
        for (int k = 0; k < quantidadePaginas; k++) {
            resultadoTemporario[k] = resultadoRanking[k];
            resultadoRanking[k] = 0;
        }
    }

    private static void setaRankInicial(int quantidadePaginas, double[] resultadoRanking, double initialPageRank) {
        for (int k = 0; k < quantidadePaginas; k++) {
            resultadoRanking[k] = initialPageRank;
        }
    }
}
