package org.example.compactacao;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

class HuffmanTest {

    @Test
    void codificadoComSucesso() {

        String resultadoEsperado = "01111000001101110010101001101110101110";

        String texto = "sergiolopessp";
        Node raiz = Huffman.criarArvoreHuffman(texto);
        String codigo = Huffman.codificarString(raiz, texto);
        boolean resultado = resultadoEsperado.equals(codigo);

        assertEquals(true, resultado);

    }

    @Test
    void decodificadoComSucesso() {
        String texto = "sergiolopessp";
        Node raiz = Huffman.criarArvoreHuffman(texto);
        String codificado = "01111000001101110010101001101110101110";
        String decodificado = Huffman.decodificarString(raiz, codificado);

        boolean resultado = texto.equals(decodificado);

        assertEquals(true, resultado);
    }



    private static Node huffmanTree;

    @BeforeAll
    static void setUp() {
        // Exemplo simples para gerar a árvore de Huffman com o texto "abbcccdddd"
        String texto = "abbcccdddd";
        huffmanTree = Huffman.criarArvoreHuffman(texto);
    }



    @Test
    void testCriarArvoreHuffmanTextoVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Huffman.criarArvoreHuffman("");
        });
        assertEquals("Texto nulo ou Vazio", exception.getMessage());
    }

    @Test
    void testCodificarString() {
        String texto = "abbcccdddd";
        String textoCodificado = Huffman.codificarString(huffmanTree, texto);

        assertNotNull(textoCodificado, "O texto codificado não deve ser nulo");
        assertTrue(textoCodificado.length() > 0, "O texto codificado deve conter dados");
    }


    @Test
    void testCodificarStringTextoNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Huffman.criarArvoreHuffman(null);
        });
        assertEquals("Texto nulo ou Vazio", exception.getMessage());
    }
}
