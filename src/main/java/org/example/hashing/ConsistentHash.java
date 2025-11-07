package org.example.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {

    // Utilizaremos um TreeMap para representar o anel hash,
    // garantindo chaves (hashes) ordenadas.
    private final SortedMap<Integer, T> ring = new TreeMap<>();
    private final int numberOfReplicas; // Número de Virtual Nodes por nó físico

    public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {  
            addNode(node);
        }
    }

    // Adiciona um nó físico (e seus v-nodes) ao anel
    public void addNode(T node) {
        // Utilizamos o nome do nó + o índice para gerar hashes distintos e espalhados
        for (int i = 0; i < numberOfReplicas; i++) {
            // Utilizamos o nome do nó + o índice para gerar hashes distintos e espalhados
            String hashKey = node.toString() + "-" + i;
            ring.put(hash(hashKey), node);
        }
    }


    // Remove um nó físico (e seus v-nodes) do anel
    public void removeNode(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String hashKey = node.toString() + "-" + i;
            ring.remove(hash(hashKey));
        }
    }


    // Retorna o nó (servidor) responsável por uma determinada chave (key)
    public T getNode(Object key) {
        if (ring.isEmpty()) {
            return null;
        }
        int hash = hash(key.toString());

        // Busca a primeira entrada no mapa com uma chave (hash) maior ou igual
        // à chave do item. Isso simula o movimento no sentido horário.
        SortedMap<Integer, T> tailMap = ring.tailMap(hash);
        
        // Se a tailMap estiver vazia, significa que a chave caiu após o último nó
        // no anel, então ela "dá a volta" e é atribuída ao primeiro nó (wrap around).
        if (tailMap.isEmpty()) {
            hash = ring.firstKey();    
        } else {
            hash = tailMap.firstKey();
        }
        
        return ring.get(hash);
    }

    // Função de Hash robusta: Usando MD5 para garantir distribuição uniforme.
    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());

            byte[] digest = md.digest();

            // Converte os primeiros 4 bytes do hash MD5 (32 bits) para um inteiro.
            // O uso de hash robusto (como MurmurHash3, ou SHA-256 encurtado) 
            // é fundamental para sistemas em produção.
            int h = 0;
            for (int i = 0; i < 4; i++) {
                h = (h << 8) | (digest[i] & 0xFF);
            }
            return h;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 não suportado, problema de ambiente.", e);
        }
    }   
}

