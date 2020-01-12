package io.ilss.datastructure.tree;

import java.util.*;

/**
 * @author feng
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTreeNode root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static HuffmanTreeNode createHuffmanTree(int[] arr) {
        List<HuffmanTreeNode> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new HuffmanTreeNode(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanTreeNode left = nodes.get(0);
            HuffmanTreeNode right = nodes.get(1);
            // 构建新树
            HuffmanTreeNode parent = new HuffmanTreeNode(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    public static void preOrder(HuffmanTreeNode node) {
        if (null == node) {
            return;
        }
        System.out.println(node);
        if (null != node.left) {
            preOrder(node.left);
        }
        if (null != node.right) {
            preOrder(node.right);
        }

    }
}
