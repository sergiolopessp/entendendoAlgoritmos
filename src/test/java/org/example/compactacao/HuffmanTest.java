package org.example.compactacao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HuffmanTest {

    @Test
    public void codificadoComSucesso() {

        String resultadoEsperado = "01111000001101110010101001101110101110";

        String texto = "sergiolopessp";
        Node raiz = Huffman.criarArvoreHuffman(texto);
        String codigo = Huffman.codificarString(raiz, texto);
        boolean resultado = resultadoEsperado.equals(codigo);

        assertEquals(true, resultado);

    }

    @Test
    public void decodificadoComSucesso() {
        String texto = "sergiolopessp";
        Node raiz = Huffman.criarArvoreHuffman(texto);
        String codificado = "01111000001101110010101001101110101110";
        String decodificado = Huffman.decodificarString(raiz, codificado);

        boolean resultado = texto.equals(decodificado);

        assertEquals(true, resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Node raiz = Huffman.criarArvoreHuffman(null);

    }

}
