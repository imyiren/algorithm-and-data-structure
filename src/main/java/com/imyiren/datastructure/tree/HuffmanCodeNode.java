package com.imyiren.datastructure.tree;

/**
 * @author yiren
 */
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    public Byte data;
    public Integer weight;
    public HuffmanCodeNode left;
    public HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
