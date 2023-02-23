package org.example;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Graph;
import org.example.model.Tree;
import org.example.model.Vertex;

import java.util.*;

class Searching {

    private static final Logger LOGGER = LogManager.getLogger(Searching.class);
    private Searching() {

    }


    public static Boolean linearSearch(int[] listaBuscar, int item) {
            int indice = 0;
            Boolean encontrou = false;

            while ((indice < listaBuscar.length) && !(Boolean.TRUE.equals(encontrou))) {
                if (listaBuscar[indice] == item) {
                    encontrou = true;
                } else {
                    indice++;
                }
            }

            return encontrou;
    }

    public static Boolean binarySearch(int[] listaBuscar, int item) {
        int inicio = 0;
        int fim = listaBuscar.length;
        Boolean encontrou = false;

        while ((inicio <= fim) && !(Boolean.TRUE.equals(encontrou))) {
            int metade = (inicio + fim) / 2;
            if (listaBuscar[metade] == item) {
                encontrou = true;
            } else {
                if (item < listaBuscar[metade]) {
                    fim = metade - 1;
                } else {
                    inicio = metade + 1;
                }
            }
        }
        return encontrou;
    }

    public static Boolean interpolationSearch(int[] listaBuscar, int item) {
        int indice0 = 0;
        int indiceN = (listaBuscar.length - 1);
        Boolean encontrou = false;

        while (item >= listaBuscar[indice0] && !(Boolean.TRUE.equals(encontrou))) {
            int probe = indice0 + (indiceN - indice0) * (item - listaBuscar[indice0]) / (listaBuscar[indiceN] - listaBuscar[indice0]);

            if (listaBuscar[probe] == item) {
              encontrou = true;
            }

            if (listaBuscar[probe] < item) {
                indice0 = probe + 1;
            }
        }
        return  encontrou;
    }

    public static <T> Boolean breadthFirstSearch(T value, Tree<T> root) {

        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            LOGGER.info("Visitando o no com valor: {}", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return true;
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return false;
    }

    public static Boolean depthFirstSearch(Graph graph, String root, String buscar) {
        Set<String> visited = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.getLabel());
                }
            }
        }

        return visited.contains(buscar);

    }

}


