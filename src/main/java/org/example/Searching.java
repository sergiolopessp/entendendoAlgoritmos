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
}
