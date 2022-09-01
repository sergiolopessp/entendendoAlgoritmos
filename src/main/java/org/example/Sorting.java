package org.example;


import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {


        System.out.println("---- Testando os algoritmos de Ordenação -----");
        System.out.println("\n");
        // Aqui vai o algoritmo de Bubble Sort
        int[] lista1 = {25, 21, 22, 24, 23, 27, 26};
        System.out.println("Lista desordenada 1: " + Arrays.toString(lista1));
        bubbleSort(lista1);
        System.out.print("Aplicando o algoritmo de BubleSort:" + Arrays.toString(lista1));
        System.out.println("\n");
        // Aqui começa a parte de Insertion
        int[] lista2 = {25, 21, 22, 24, 23, 27, 26};
        System.out.println("Lista desordenada 2: " + Arrays.toString(lista2));
        insertionSort(lista2);
        System.out.println("Aplicando o algoritmo de InsertionSort:" + Arrays.toString(lista2));
        System.out.println("\n");
        // Aqui começa a parte de Merge
        int[] lista3 = {25, 21, 22, 24, 23, 27, 26};
        System.out.println("Lista desordenada 3: " + Arrays.toString(lista3));
        mergeSort(lista3, 0, lista3.length);
        System.out.println("Aplicando o algoritmo de MergeSort: " + Arrays.toString(lista3));
        System.out.println("\n");
        // aqui começa o ShellSort
        int[] lista4 = {25, 21, 22, 24, 23, 27, 26};
        System.out.println("Lista desordenada 4: " + Arrays.toString(lista4));
        shellSort(lista4);
        System.out.println("Aplicando o algoritmo de ShellSort:" + Arrays.toString(lista4));
        System.out.println("\n");
        // aqui começa o Selection
        int[] lista5 = {25, 21, 22, 24, 23, 27, 26};
        System.out.println("Lista desordenada 5: " + Arrays.toString(lista5));
        selectionSort(lista5);
        System.out.println("Aplicando o algoritmo de SelectionSort: " + Arrays.toString(lista5));
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

        int i = start, m = mid, pos = 0;

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
}