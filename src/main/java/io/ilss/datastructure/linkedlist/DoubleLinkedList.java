package io.ilss.datastructure.linkedlist;

/**
 * @author feng
 */
public class DoubleLinkedList {

    DoubleNode head = new DoubleNode(0);

    // 遍历双向链表 同单链表
    public void list() {
        if (null == head.next) {
            return;
        }
        DoubleNode temp = this.head.next;
        do {
            System.out.println(temp);
        } while (null != (temp = temp.next));
    }

    // 添加到双向链表尾部
    // 当不考虑编号顺序时，找到当前链表最后节点，next 指向最新节点
    public void add(DoubleNode node) {
        // head 节点不能动，我们使用temp来辅助遍历链表节点
        DoubleNode temp = this.head;
        // 遍历找到最后节点
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    // 修改节点
    public void update(DoubleNode newNode) {
        if (null == this.head.next) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = this.head.next;
        // 遍历找到最后节点
        while (true) {
            if (null == temp) {
                System.out.println("没有找到该节点！" + newNode.toString());
                break;
            }
            if (temp.value == newNode.value) {
                System.out.println("修改节点" + newNode.toString() + "某些信息..");
                break;
            }
            temp = temp.next;
        }
    }

    // 删除某个节点
    public void delete(int value) {
        if (null == this.head.next) {
            System.out.println("链表节点为空");
            return;
        }
        DoubleNode temp = this.head.next;
        while (true) {
            if (null == temp) {
                System.out.println("没有找到链表节点");
                break;
            }
            if (temp.value == value) {
                System.out.println("删除节点: " + value);
                temp.pre.next = temp.next;
                // 注意空指针异常
                if (null != temp.next) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void addByOrder(DoubleNode node) {
        DoubleNode temp = this.head;
        // 遍历找到最后节点
        while (true) {
            if (temp.value == node.value) {
                System.out.println("编号 " + node.value + "已存在！");
                break;
            }
            if (null == temp.next || temp.next.value > node.value) {
                node.next = temp.next;
                node.pre = temp;
                if (null != temp.next) {
                    temp.next.pre = node;
                }
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        DoubleNode nodeOne = new DoubleNode(1);
        DoubleNode nodeTwo = new DoubleNode(2);
        DoubleNode nodeThree = new DoubleNode(3);
        DoubleNode nodeFour = new DoubleNode(4);
        DoubleNode nodeFive = new DoubleNode(5);

        linkedList.add(nodeOne);
        linkedList.add(nodeTwo);
        linkedList.add(nodeThree);
        linkedList.add(nodeFour);
        linkedList.add(nodeFive);

        System.out.println("=====> 初始化显示数据");
        linkedList.list();
        System.out.println("=====> 修改某节点数据");
        linkedList.update(new DoubleNode(3));
        System.out.println("=====> 删除数据数据");
        linkedList.delete(3);
        linkedList.list();
        System.out.println("=====> 顺序插入数据");
        linkedList.addByOrder(new DoubleNode(3));
        linkedList.list();
        System.out.println("=====> 约瑟夫斯问题");

    }
}
