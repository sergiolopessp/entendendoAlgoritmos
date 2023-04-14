package org.example;

import java.util.*;
import java.util.Map.Entry;

public class Sorting {

    private Sorting() {

    }
    public static void bubbleSort(int[] listaOrdenar) {

        for (int i = 0; i < listaOrdenar.length-1; i++) {
            for (int j = 0; j < listaOrdenar.length - i - 1; j++) {
                    if (listaOrdenar[j] > listaOrdenar[j+1]) {
                        int troca = listaOrdenar[j];
                        listaOrdenar[j] = listaOrdenar[j+1];
                        listaOrdenar[j+1] = troca;
                    }
            }
        }

    }

    public static void insertionSort(int[] listaOrdenar) {

        for (int i = 1; i < listaOrdenar.length; ++i) {
            int j = i-1;
            int proximoElemento = listaOrdenar[i];

            while (j >= 0 && listaOrdenar[j] > proximoElemento) {
                listaOrdenar[j+1] = listaOrdenar[j];
                j = j - 1;

            }
            listaOrdenar[j+1] = proximoElemento;
        }

    }

    public static void mergeSort(int[] listaOrdenar, int start, int end) {

        if (start < end - 1) {

            int mid = (start+end) / 2;
            mergeSort(listaOrdenar, start, mid);
            mergeSort(listaOrdenar, mid, end);

            merge(listaOrdenar, start, mid, end);
        }
    }

    public static void merge (int[] listaOrdenar, int start, int mid, int end) {

       int[] novaLista = new int[end - start];

        int i = start;
        int m = mid;
        int pos = 0;

        while (i < mid && m < end) {
            if (listaOrdenar[i] <= listaOrdenar[m]) {
                novaLista[pos++] = listaOrdenar[i++];
            } else {
                novaLista[pos++] = listaOrdenar[m++];
            }
        }

        while (i < mid) {
            novaLista[pos++] = listaOrdenar[i++];
        }

        while ( m < end) {
            novaLista[pos++] = listaOrdenar[m++];
        }

        for (pos = 0, i = start; i < end; i++, pos++) {
            listaOrdenar[i] = novaLista[pos];
        }
    }

    public static void shellSort (int[] listaOrdenar) {
        int tamanho = listaOrdenar.length;

        for (int distancia = tamanho/2; distancia > 0; distancia /= 2) {
            for (int i = distancia; i < tamanho; i++) {
                int temp = listaOrdenar[i];
                int j = i;
                while (j >= distancia && listaOrdenar[j - distancia] > temp) {
                    listaOrdenar[j] = listaOrdenar[j - distancia];
                    j -= distancia;
                }
                listaOrdenar[j] = temp;
            }
        }
    }

    public static void selectionSort(int[] listaOrdenar) {
        for (int i = 0; i < listaOrdenar.length; i++) {
            int indice = i;
            for (int j = i + 1; j < listaOrdenar.length; j++) {
                if (listaOrdenar[j] < listaOrdenar[indice]) {
                    indice = j;
                }
            }
            int menorNumero = listaOrdenar[indice];
            listaOrdenar[indice] = listaOrdenar[i];
            listaOrdenar[i] = menorNumero;
        }
    }

    public static Map<String, Double> ordenaPorComparadorDouble(final Map<String, Double> listaOrdenar) {
        List<Entry<String, Double>> mapArr = new LinkedList<>(
                listaOrdenar.entrySet());

        Collections.sort(mapArr, (v1, v2) -> v2.getValue().compareTo(v1.getValue()));
        LinkedHashMap<String, Double> sortedByComparator = new LinkedHashMap<>();
        for (Entry<String, Double> e : mapArr) {
            sortedByComparator.put(e.getKey(), e.getValue());
        }
        return sortedByComparator;
    }
}