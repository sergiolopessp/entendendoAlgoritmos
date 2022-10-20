package org.example;

class Searching {

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
}
