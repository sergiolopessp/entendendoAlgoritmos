package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingTest {

    int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};

    @Test
    void achouBuscaLinear() {
        Boolean resultado = Searching.linearSearch(listaBuscar, 22);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");

    }

    @Test
    void naoAchouBuscaLinear() {
        Boolean resultado = Searching.linearSearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }
}
