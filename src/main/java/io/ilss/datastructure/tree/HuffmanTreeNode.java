package io.ilss.datastructure.tree;

/**
 * @author feng
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
    public int value;
    public HuffmanTreeNode left;
    public HuffmanTreeNode right;

    public HuffmanTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        // 从小到大
        return this.value - o.value;
    }
}
