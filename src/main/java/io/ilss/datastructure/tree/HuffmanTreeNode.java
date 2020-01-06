package io.ilss.datastructure.tree;

/**
 * @author feng
 */
public class HuffmanTreeNode {
    public int value;
    public HuffmanTreeNode left;
    public HuffmanTreeNode right;


    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "value=" + value +
                '}';
    }
}
