package org.example.compactacao;

import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testNodeConstructor() {
        // Create a Node object
        Node node = new Node('a', 5);

        // Check if the values are set correctly
        assertEquals('a', node.c.charValue());
        assertEquals(5, node.freq);
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testNodeConstructorWithChildren() {
        // Create left and right child nodes
        Node leftChild = new Node('b', 3);
        Node rightChild = new Node('c', 7);

        // Create a parent node with left and right children
        Node parentNode = new Node('a', 10, leftChild, rightChild);

        // Check if the values and children are set correctly
        assertEquals('a', parentNode.c.charValue());
        assertEquals(10, parentNode.freq);
        assertSame(leftChild, parentNode.left);
        assertSame(rightChild, parentNode.right);
    }

}
