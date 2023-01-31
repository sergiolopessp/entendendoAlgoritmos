package org.example;

import org.example.model.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingTest {


    @Test
    void achouBuscaLinear() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Boolean resultado = Searching.linearSearch(listaBuscar, 22);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");

    }

    @Test
    void naoAchouBuscaLinear() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Boolean resultado = Searching.linearSearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouBuscaBinaria() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.binarySearch(listaBuscar, 22);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");
    }
    @Test
    void naoAchouBuscaBinaria() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.binarySearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouBuscaInterpolada() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.interpolationSearch(listaBuscar, 99);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");


    }

    @Test
    void naoAchouBuscaInterpolada() {
        int[] listaBuscar = { 12, 33, 11, 99, 22, 55, 90};
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.interpolationSearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouInteiroNaArvore() {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        Boolean resultado = Searching.breadthFirstSearch(4, root);

        assertEquals(true, resultado, "Não conseguiu encontrar um item na arvore");
    }

    @Test
    void naoAchouInteiroNaArvore() {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        Boolean resultado = Searching.breadthFirstSearch(6, root);

        assertEquals(false, resultado, "Achou um item que não era para achar");
    }

}
