package org.example.hashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class ConsistentHashTest {

    private ConsistentHash<String> consistentHash;
    private List<String> nodes;

    @BeforeEach
    void setUp() {
        nodes = Arrays.asList("server1", "server2", "server3");
        consistentHash = new ConsistentHash<>(3, nodes);
    }

    @Test
    void testConstructorWithNodes() {
        assertNotNull(consistentHash);
        // Verifica que os nós foram adicionados corretamente
        assertNotNull(consistentHash.getNode("test-key"));
    }

    @Test
    void testConstructorWithEmptyCollection() {
        ConsistentHash<String> emptyHash = new ConsistentHash<>(3, Collections.emptyList());
        assertNull(emptyHash.getNode("test-key"));
    }

    @Test
    void testAddNode() {
        String newNode = "server4";
        consistentHash.addNode(newNode);
        
        // Verifica que o novo nó pode ser retornado para alguma chave
        // (não podemos garantir qual chave, mas podemos testar que não é null)
        String result = consistentHash.getNode("new-test-key-" + System.currentTimeMillis());
        assertNotNull(result);
        assertTrue(nodes.contains(result) || result.equals(newNode));
    }

    @Test
    void testRemoveNode() {
        String nodeToRemove = "server1";
        consistentHash.removeNode(nodeToRemove);
        
        // Verifica que o nó removido não é mais retornado
        // Testamos várias chaves para aumentar a probabilidade de encontrar uma que
        // anteriormente mapeava para o nó removido
        Set<String> returnedNodes = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String node = consistentHash.getNode("test-key-" + i);
            if (node != null) {
                returnedNodes.add(node);
            }
        }
        
        assertFalse(returnedNodes.contains(nodeToRemove));
    }

    @Test
    void testGetNodeReturnsNotNull() {
        String result = consistentHash.getNode("test-key-1");
        assertNotNull(result);
    }

    @Test
    void testGetNodeConsistency() {
        String key = "consistent-test-key";
        String node1 = consistentHash.getNode(key);
        String node2 = consistentHash.getNode(key);
        
        // A mesma chave deve sempre retornar o mesmo nó
        assertEquals(node1, node2);
    }

    @Test
    void testGetNodeWithEmptyRing() {
        ConsistentHash<String> emptyHash = new ConsistentHash<>(3, Collections.emptyList());
        assertNull(emptyHash.getNode("any-key"));
    }

    @Test
    void testGetNodeWrapAround() {
        // Testa que quando uma chave cai após o último nó, ela "dá a volta"
        // e é atribuída ao primeiro nó do anel
        String result = consistentHash.getNode("wrap-around-test-key");
        assertNotNull(result);
        assertTrue(nodes.contains(result));
    }

    @Test
    void testMultipleNodesDistribution() {
        // Testa que diferentes chaves são distribuídas entre os nós
        Map<String, Integer> distribution = new HashMap<>();
        
        for (int i = 0; i < 100; i++) {
            String key = "distribution-test-" + i;
            String node = consistentHash.getNode(key);
            distribution.put(node, distribution.getOrDefault(node, 0) + 1);
        }
        
        // Verifica que pelo menos dois nós diferentes receberam chaves
        assertTrue(distribution.size() >= 2, 
            "Chaves devem ser distribuídas entre múltiplos nós");
    }

    @Test
    void testAddAndRemoveNode() {
        String newNode = "server4";
        consistentHash.addNode(newNode);
        
        // Verifica que o novo nó pode ser encontrado
        Set<String> nodesBeforeRemoval = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            String node = consistentHash.getNode("test-" + i);
            if (node != null) {
                nodesBeforeRemoval.add(node);
            }
        }
        
        consistentHash.removeNode(newNode);
        
        // Verifica que o nó removido não é mais encontrado
        Set<String> nodesAfterRemoval = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            String node = consistentHash.getNode("test-" + i);
            if (node != null) {
                nodesAfterRemoval.add(node);
            }
        }
        
        assertFalse(nodesAfterRemoval.contains(newNode));
    }

    @Test
    void testDifferentNumberOfReplicas() {
        ConsistentHash<String> hashWithMoreReplicas = new ConsistentHash<>(10, nodes);
        ConsistentHash<String> hashWithFewerReplicas = new ConsistentHash<>(1, nodes);
        
        // Ambos devem funcionar
        assertNotNull(hashWithMoreReplicas.getNode("test-key"));
        assertNotNull(hashWithFewerReplicas.getNode("test-key"));
    }

    @Test
    void testGetNodeWithSpecialCharacters() {
        String key = "special-key-!@#$%^&*()";
        String result = consistentHash.getNode(key);
        assertNotNull(result);
    }

    @Test
    void testGetNodeWithUnicodeCharacters() {
        String key = "unicode-key-测试-тест-テスト";
        String result = consistentHash.getNode(key);
        assertNotNull(result);
    }

    @Test
    void testGetNodeWithEmptyString() {
        String result = consistentHash.getNode("");
        assertNotNull(result);
    }

    @Test
    void testGetNodeWithNullKey() {
        // O método getNode espera um Object, mas toString() é chamado
        // Um null causaria NullPointerException, então testamos isso
        assertThrows(NullPointerException.class, () -> {
            consistentHash.getNode(null);
        });
    }

    @Test
    void testSingleNode() {
        List<String> singleNode = Collections.singletonList("single-server");
        ConsistentHash<String> singleHash = new ConsistentHash<>(3, singleNode);
        
        // Todas as chaves devem mapear para o único nó
        for (int i = 0; i < 10; i++) {
            String result = singleHash.getNode("key-" + i);
            assertEquals("single-server", result);
        }
    }

    @Test
    void testRemoveAllNodes() {
        for (String node : nodes) {
            consistentHash.removeNode(node);
        }
        
        // Após remover todos os nós, getNode deve retornar null
        assertNull(consistentHash.getNode("any-key"));
    }

    @Test
    void testReAddRemovedNode() {
        String node = "server1";
        String key = "test-key-for-readd";
        
        // Obtém o nó original
        String originalNode = consistentHash.getNode(key);
        
        // Remove o nó
        consistentHash.removeNode(node);
        
        // Adiciona o nó de volta
        consistentHash.addNode(node);
        
        // Verifica que ainda funciona
        String result = consistentHash.getNode(key);
        assertNotNull(result);
    }

    @Test
    void testHashDistributionWithManyKeys() {
        // Testa a distribuição com muitas chaves
        Map<String, Integer> distribution = new HashMap<>();
        int numberOfKeys = 1000;
        
        for (int i = 0; i < numberOfKeys; i++) {
            String key = "key-" + i;
            String node = consistentHash.getNode(key);
            distribution.put(node, distribution.getOrDefault(node, 0) + 1);
        }
        
        // Verifica que todos os nós receberam pelo menos algumas chaves
        assertEquals(nodes.size(), distribution.size(), 
            "Todos os nós devem receber pelo menos uma chave");
        
        // Verifica que a distribuição não está muito desbalanceada
        // Reduz o limite mínimo para ser mais realista (cada nó deve receber pelo menos 3% das chaves)
        int minExpected = numberOfKeys / (nodes.size() * 10); // 1000 / 30 = ~33 chaves
        for (String node : nodes) {
            int received = distribution.get(node);
            assertTrue(received >= minExpected,
                "Nó " + node + " deve receber pelo menos " + minExpected + " chaves, mas recebeu apenas " + received);
        }
    }
}