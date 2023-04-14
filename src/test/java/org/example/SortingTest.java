package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class SortingTest {

    int[] listaOrdenada = { 21, 22, 23, 24, 25, 26, 27};


    @Test
    void ordenaUsandoBubble() {
        int[] listaDesordenada = createListInt();
        Sorting.bubbleSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista nao está ordenada");
    }

    @Test
    void ordenaUsandoInsertion() {
        int[] listaDesordenada = createListInt();
        Sorting.insertionSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A Lista não estã ordenada :");
    }

    @Test
    void ordenaUsandoMerge() {
        int[] listaDesordenada = createListInt();
        Sorting.mergeSort(listaDesordenada, 0, listaDesordenada.length);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista estã desordenada");
    }

    @Test
    void ordenaUsandoShellSort() {
        int[] listaDesordenada = createListInt();
        Sorting.shellSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista está desordenada : ");
    }

    @Test
    void ordenaUsandoSelection() {
        int[] listaDesordenada = createListInt();
        Sorting.selectionSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista está desordenada");
    }

    @Test
    void testOrdenaPorComparadorDouble() {

        Map<String, Double> lista = new HashMap<>();
        lista.put("A", 1.0);
        lista.put("B", 2.5);
        lista.put("C", 0.5);

        Map<String, Double> expected = new LinkedHashMap<>();
        expected.put("B", 2.5);
        expected.put("A", 1.0);
        expected.put("C", 0.5);

        assertEquals(expected, Sorting.ordenaPorComparadorDouble(lista));
    }

    int[] createListInt() {
        int[] lista = { 25, 21, 22, 24, 23, 27, 26};
        return lista;
    }

}
