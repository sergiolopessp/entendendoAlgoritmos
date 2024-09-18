package org.example.compactacao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private static Logger logger = LoggerFactory.getLogger(Huffman.class);

    private Huffman() {
        throw new IllegalStateException("Utility class");
    }

    public static Node criarArvoreHuffman(String texto) {

        if (texto == null || texto.isEmpty()) {
            logger.error("Texto nulo");
            throw new IllegalArgumentException("Texto nulo ou Vazio");
        }

        Map<Character, Integer> frequencias = new HashMap<>();

        for (char c : texto.toCharArray()) {
            frequencias.put(c, frequencias.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> fila = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        for (var entry : frequencias.entrySet()) {
            fila.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (fila.size() > 1) {
            Node left = fila.poll();
            Node right = fila.poll();
            int sum = left.freq + right.freq;
            fila.add(new Node(null, sum, left, right));
        }

        return fila.poll();
    }

    public static String codificarString(Node root, String texto) {
        Map<Character, String> codigos = new HashMap<>();
        codificar(root, codigos, "");
        logger.info("Os Codigos Huffman para os caracteres foram: {}", codigos);
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            sb.append(codigos.get(c));
        }

        return sb.toString();
    }

    public static String decodificarString(Node root, String textoCodificado) {

        StringBuilder resultado = new StringBuilder();

        if (isLeaf(root)) {
            while (root.freq-- > 0) {
               resultado.append(String.valueOf(root.c));
            }
        } else {
            int index = -1;
            while (index < textoCodificado.length() -1) {
                index = decodificar(root, index, textoCodificado, resultado);
            }
        }
        return resultado.toString();
    }
    private static int decodificar(Node root, int index, String textoCodifica, StringBuilder resultado) {
        if (root == null) {
            return index;
        }

        if (isLeaf(root)) {
            resultado.append(String.valueOf(root.c));
            return index;
        }

        index++;
        root = textoCodifica.charAt(index) == '0' ? root.left : root.right;
        index = decodificar(root, index, textoCodifica, resultado);
        return index;
    }

    private static void codificar(Node root, Map<Character, String> codigos, String s) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            codigos.put(root.c, !s.isEmpty() ? s : "1");
        }
        codificar(root.left, codigos,s + '0');
        codificar(root.right, codigos, s + '1');

    }

    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

}
