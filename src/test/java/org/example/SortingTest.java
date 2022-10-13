package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SortingTest {

    int[] listaOrdenada = { 21, 22, 23, 24, 25, 26, 27};


    @Test
    void ordenaUsandoBubble() {
        int[] listaDesordenada = {25, 21, 22, 24, 23, 27, 26};
        Sorting.bubbleSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista nao está ordenada");
    }

    @Test
    void ordenaUsandoInsertion() {
        int[] listaDesordenada = {25, 21, 22, 24, 23, 27, 26};
        Sorting.insertionSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A Lista não estã ordenada :");
    }

    @Test
    void ordenaUsandoMerge() {
        int[] listaDesordenada = {25, 21, 22, 24, 23, 27, 26};
        Sorting.mergeSort(listaDesordenada, 0, listaDesordenada.length);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista estã desordenada");
    }

    @Test
    void ordenaUsandoShellSort() {
        int[] listaDesordenada = {25, 21, 22, 24, 23, 27, 26};
        Sorting.shellSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista está desordenada : ");
    }

    @Test
    void ordenaUsandoSelection() {
        int[] listaDesordenada = {25, 21, 22, 24, 23, 27, 26};
        Sorting.selectionSort(listaDesordenada);
        assertArrayEquals(listaOrdenada, listaDesordenada, "A lista está desordenada");
    }

}
