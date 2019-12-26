package io.ilss.datastructure.linkedlist;

import java.util.List;

/**
 * @author feng
 */
public class JosephuQuestion {

    public static SingleNode initCircleLinkedList(int n) {
        if (n < 1) {
            return null;
        }
        SingleNode first = new SingleNode(1);
        first.next = first;
        SingleNode cur = first;

        for (int i = 2; i < n + 1; i++) {
            cur.next = new SingleNode(i);
            cur = cur.next;
            cur.next = first;
        }
        return first;
    }

    public static void show(SingleNode first) {
        SingleNode temp = first;
        if (null == first) {
            return;
        }
        do {
            System.out.println("节点" + temp.value);
        } while (first != (temp = temp.next));
    }

    public static List<SingleNode> josephu(SingleNode first, int k, int m) {
        return null;
    }


    /**
     * 约瑟夫斯问题
     *
     * @param args
     */
    public static void main(String[] args) {
        SingleNode firstNode = initCircleLinkedList(3);
        show(firstNode);
        List<SingleNode> josephuResult = josephu(firstNode, 5, 3);
    }
}
