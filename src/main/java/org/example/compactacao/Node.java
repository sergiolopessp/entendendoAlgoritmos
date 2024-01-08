package org.example.compactacao;

import java.util.Objects;

class Node {
    int freq;
    Character c;
    Node left;
    Node right;

    Node(char c, int freq) {
        this.freq = freq;
        this.c = c;
        left = right = null;
    }

    public Node(Character c, int freq, Node left, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return freq == node.freq && Objects.equals(c, node.c) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freq, c, left, right);
    }
}
