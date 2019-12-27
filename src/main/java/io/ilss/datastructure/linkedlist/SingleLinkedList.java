package io.ilss.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author feng
 */
public class SingleLinkedList {
    // 头结点不动 不存放具体数据
    SingleNode head = new SingleNode(0);

    // 当不考虑编号顺序时，找到当前链表最后节点，next 指向最新节点
    public void add(SingleNode node) {
        // head 节点不能动，我们使用temp来辅助遍历链表节点
        SingleNode temp = this.head;
        // 遍历找到最后节点
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(SingleNode node) {
        SingleNode temp = this.head;
        // 遍历找到最后节点
        while (true) {
            if (temp.value == node.value) {
                System.out.println("编号 " + node.value + "已存在！");
                break;
            }
            if (null == temp.next || temp.next.value > node.value) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 根据编号修改
     */
    public void update(SingleNode newNode) {
        if (null == this.head.next) {
            System.out.println("链表为空");
            return;
        }
        SingleNode temp = this.head.next;

        // 遍历找到最后节点
        while (true) {
            if (null == temp) {
                System.out.println("没有找到该节点！" + newNode.value);
                break;
            }
            if (temp.value == newNode.value) {
                System.out.println("修改了某些值， 节点：" + temp.value);
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int no) {
        if (null == this.head.next) {
            System.out.println("链表节点为空");
            return;
        }
        SingleNode temp = this.head;
        while (true) {
            if (null == temp.next) {
                System.out.println("没有找到链表节点");
                break;
            }
            if (temp.next.value == no) {
                temp.next  = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public int getLength(SingleNode head) {
        if (null == head.next) {
            return 0;
        }
        int length = 0;
        SingleNode cur = head.next;

        while (null != cur) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public void reverseList(SingleNode head) {
        if (null == head.next || null == head.next.next) {
            return;
        }
        SingleNode reverseHead = new SingleNode(0);

        // 临时变量记录head
        while (true) {
            SingleNode cur = head.next;
            if (null == cur) {
                break;
            }
            head.next  = head.next.next;
            // 把当前节点挪到reverseHead上
            cur.next  = reverseHead.next;
            reverseHead.next = cur;
        }
        head.next  = reverseHead.next;
    }

    public SingleNode findLastIndexNode(SingleNode head, int index) {
        // 没有找到
        if (null == head.next) {
            return null;
        }
        // 第一个遍历得到链表的长度
        int size = this.getLength(head);
        // 遍历到size-index 就是我们找的位置
        if (index <= 0 || index > size) {
            return null;
        }
        // 设定当前为第一个开始，然后循环size-index
        SingleNode current = head.next;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }

    public void list() {
        if (null == head.next) {
            return;
        }
        SingleNode temp = this.head.next;
        do {
            System.out.println(temp);
        } while (null != (temp = temp.next));
    }

    public void reversePrint(SingleNode head) {
        if (null == head.next) {
            System.out.println("链表为空");
        }
        Stack<SingleNode> nodes = new Stack<>();
        SingleNode temp = head.next;
        while (null != temp) {
            nodes.push(temp);
            temp = temp.next;
        }
        while (!nodes.empty()) {
            System.out.println(nodes.pop());
        }
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        SingleNode songHero = new SingleNode(1);
        SingleNode luHero = new SingleNode(2);
        SingleNode wuHero = new SingleNode(3);
        SingleNode linHero = new SingleNode(4);
        // linkedList.add(songHero);
        // linkedList.add(luHero);
        // linkedList.add(wuHero);
        // linkedList.add(linHero);


        linkedList.addByOrder(luHero);
        linkedList.addByOrder(songHero);
        linkedList.addByOrder(linHero);
        linkedList.addByOrder(wuHero);
        linkedList.addByOrder(linHero);

        System.out.println("逆序打印");
        linkedList.reversePrint(linkedList.head);

        System.out.println("寻找倒数的节点： "+linkedList.findLastIndexNode(linkedList.head, 2));

        linkedList.list();

        linkedList.update(new SingleNode(2));
        System.out.println("=====》 修改后");
        linkedList.list();
        linkedList.delete(1);
        System.out.println("=====》 删除后");
        linkedList.list();
        linkedList.delete(4);
        System.out.println("=====》 删除后");
        linkedList.list();
        System.out.println("length : " + linkedList.getLength(linkedList.head));
        linkedList.reverseList(linkedList.head);
        System.out.println("====> 反转后");
        linkedList.list();
    }

}
