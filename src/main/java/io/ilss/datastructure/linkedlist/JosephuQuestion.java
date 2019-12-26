package io.ilss.datastructure.linkedlist;

import java.util.ArrayList;
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

    /**
     * @param first 第一个指正
     * @param k
     * @param m
     * @param n
     * @return
     */
    public static List<SingleNode> josephu(SingleNode first, int k, int m, int n) {
        if (null == first || m < 1 || m > n) {
            System.out.println("参数校验失败");
        }
        List<SingleNode> resultNodes = new ArrayList<>();
        SingleNode temp = new SingleNode(-1);
        temp.next = first;

        // 把temp移动到k-1位置
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        while (true) {
            if (resultNodes.size() == n - 1) {
                break;
            }
            // 指正移动
            for (int i = 0; i < m-1; i++) {
                temp = temp.next;
            }
            // 加到结果集
            resultNodes.add(temp.next);
            // 移除元素
            temp.next = temp.next.next;
        }
        return resultNodes;
    }

    /**
     * 约瑟夫斯问题
     *
     * @param args
     */
    public static void main(String[] args) {
        SingleNode firstNode = initCircleLinkedList(5);
        show(firstNode);
        List<SingleNode> josephuResult = josephu(firstNode, 1, 3, 5);
        for (SingleNode node :
                josephuResult) {
            System.out.println(node.value);
        }
    }
}
