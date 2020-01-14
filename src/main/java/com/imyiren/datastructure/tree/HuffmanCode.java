package com.imyiren.datastructure.tree;

import java.util.*;

/**
 * @author feng
 */
public class HuffmanCode {

    private static void preOrder(HuffmanCodeNode node) {
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

    private static List<HuffmanCodeNode> getNodes(byte[] bytes) {
        List<HuffmanCodeNode> nodes = new ArrayList<>(bytes.length + 1);

        Map<Byte, Integer> counts = new HashMap<>();
        // 统计每个字符出现的次数
        for (Byte value : bytes) {
            // 如果存在，那就相加，如果不存在 就设置为1
            counts.merge(value, 1, Integer::sum);
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanCodeNode left = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);
            // 构建新树
            HuffmanCodeNode parent = new HuffmanCodeNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            // 从list中移出已处理的节点
            nodes.remove(left);
            nodes.remove(right);
            // 然后把新的节点加入到list
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    private static void getHuffmanCodes(Map<Byte, String> huffmanCodes, HuffmanCodeNode node, String code, StringBuilder stringBuilder) {
        StringBuilder temp = new StringBuilder(stringBuilder);
        temp.append(code);
        if (null != node) {
            if (null == node.data) {
                // 递归
                getHuffmanCodes(huffmanCodes, node.left, "0", temp);
                getHuffmanCodes(huffmanCodes, node.right, "1", temp);
            } else {
                huffmanCodes.put(node.data, temp.toString());
            }
        }
    }

    public static Map<Byte, String> getHuffmanCodes(HuffmanCodeNode root) {
        if (null == root) {
            return new HashMap<>();
        }
        Map<Byte, String> huffmanCodes = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        getHuffmanCodes(huffmanCodes, root.left, "0", stringBuilder);
        getHuffmanCodes(huffmanCodes, root.right, "1", stringBuilder);

        return huffmanCodes;
    }

    public static Byte[] zipByHuffmanCode(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder builder = new StringBuilder();
        for (Byte value : bytes) {
            builder.append(huffmanCodes.get(value));
        }

        int len = (builder.length() + 7) / 8;
        Byte[] result = new Byte[len];
        for (int i = 0; i < builder.length(); i += 8) {
            String stringByte = builder.substring(i, Math.min(i + 8, builder.length()));
            // 转成byte数组
            result[i / 8] = (byte) Integer.parseInt((stringByte), 2);
        }
        return result;
    }

    private static Map<Byte, String> huffmanCodes;

    public static Byte[] getHuffmanZipBytes(String content) {
        List<HuffmanCodeNode> nodes = getNodes(content.getBytes());
        HuffmanCodeNode root = createHuffmanTree(nodes);
        huffmanCodes = getHuffmanCodes(root);
        return zipByHuffmanCode(content.getBytes(), huffmanCodes);
    }

    public static String unzipByHuffman(Byte[] huffmanCodeBytes, Map<Byte, String> huffmanCodes) {
        StringBuilder byteBinaryString = new StringBuilder();
        // 先把byte数组转成二进制的字符串
        for (int i = 0; i < huffmanCodeBytes.length; i++) {
            int temp = huffmanCodeBytes[i];
            // 第九位 + 1
            // 如果不是最后一位 就进行补零
            if (i != huffmanCodeBytes.length - 1) {
                temp |= 256;
            }
            // 返回temp对应的二进制补码
            String tempString = Integer.toBinaryString(temp);
            // 如果是最后一位 就不需要补位
            String byteBinaryStringItem = i == huffmanCodeBytes.length - 1 ? tempString : tempString.substring(tempString.length() - 8);
            byteBinaryString.append(byteBinaryStringItem);
        }
        System.out.println(byteBinaryString);

        // 然后再构建解码字符串
        StringBuilder result = new StringBuilder();
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> item : huffmanCodes.entrySet()) {
            map.put(item.getValue(), item.getKey());
        }
        int left = 0, offset = 1;
        while (left < byteBinaryString.length()) {
            String item = byteBinaryString.substring(left, left + offset);
            if (!map.containsKey(item)) {
                offset++;
                continue;
            }
            Byte temp = map.get(item);

            result.append(Character.valueOf((char) temp.intValue()));
            left += offset;
            offset = 1;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        Byte[] result = getHuffmanZipBytes(content);
        System.out.println(Arrays.toString(result));
        String resultString = unzipByHuffman(result, huffmanCodes);
        System.out.println(resultString);
    }

}
