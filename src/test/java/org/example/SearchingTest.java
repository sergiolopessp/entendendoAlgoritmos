package org.example;

import org.example.model.Graph;
import org.example.model.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingTest {


    @Test
    void achouBuscaLinear() {
        int[] listaBuscar = createListInt();
        Boolean resultado = Searching.linearSearch(listaBuscar, 22);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");

    }

    @Test
    void naoAchouBuscaLinear() {
        int[] listaBuscar = createListInt();
        Boolean resultado = Searching.linearSearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouBuscaBinaria() {
        int[] listaBuscar = createListInt();
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.binarySearch(listaBuscar, 22);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");
    }
    @Test
    void naoAchouBuscaBinaria() {
        int[] listaBuscar = createListInt();
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.binarySearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouBuscaInterpolada() {
        int[] listaBuscar = createListInt();
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.interpolationSearch(listaBuscar, 99);
        assertEquals(true, resultado, "Não Achou o Resultado na Lista");


    }

    @Test
    void naoAchouBuscaInterpolada() {
        int[] listaBuscar = createListInt();
        Sorting.bubbleSort(listaBuscar);
        Boolean resultado = Searching.interpolationSearch(listaBuscar, 91);
        assertEquals(false, resultado, "Encontrou, mas nao deveria encontrar");
    }

    @Test
    void achouInteiroNaArvore() {
        Tree<Integer> root = createTree();

        Boolean resultado = Searching.breadthFirstSearch(4, root);

        assertEquals(true, resultado, "Não conseguiu encontrar um item na arvore");
    }

    @Test
    void naoAchouInteiroNaArvore() {
        Tree<Integer> root = createTree();
        Boolean resultado = Searching.breadthFirstSearch(6, root);

        assertEquals(false, resultado, "Achou um item que não era para achar");
    }

    @Test
    void encontrouNomeNoGrapho() {
        Graph graph = createGraph();
        assertEquals(true, Searching.depthFirstSearch(graph, "Sergio", "Gil"));
    }

    @Test
    void naoEncontrouNomeNoGraph() {
        Graph graph = createGraph();
        assertEquals(false, Searching.depthFirstSearch(graph, "Sergio", "Catarina"));
    }

    int[] createListInt() {
        int[] lista = { 12, 33, 11, 99, 22, 55, 90};
        return lista;
    }

    Tree<Integer> createTree() {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);
        return root;
    }

    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Sergio");
        graph.addVertex("Gil");
        graph.addVertex("Henrique");
        graph.addVertex("Ana");
        graph.addVertex("Vilma");
        graph.addEdge("Sergio", "Gil");
        graph.addEdge("Sergio", "Henrique");
        graph.addEdge("Gil", "Henrique");
        graph.addEdge("Ana", "Henrique");
        graph.addEdge("Gil", "Vilma");
        graph.addEdge("Ana", "Vilma");

        return graph;

    }
}
