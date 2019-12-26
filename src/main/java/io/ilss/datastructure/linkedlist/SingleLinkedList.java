package io.ilss.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author feng
 */
public class SingleLinkedList {
    // 头结点不动 不存放具体数据
    HeroNode head = new HeroNode(0, "", "");

    // 当不考虑编号顺序时，找到当前链表最后节点，next 指向最新节点
    public void add(HeroNode node) {
        // head 节点不能动，我们使用temp来辅助遍历链表节点
        HeroNode temp = this.head;
        // 遍历找到最后节点
        while (null != temp.getNext()) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void addByOrder(HeroNode node) {
        HeroNode temp = this.head;
        // 遍历找到最后节点
        while (true) {
            if (temp.getNo() == node.getNo()) {
                System.out.println("编号 " + node.getNo() + "已存在！");
                break;
            }
            if (null == temp.getNext() || temp.getNext().getNo() > node.getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 根据编号修改
     */
    public void update(HeroNode newNode) {
        if (null == this.head.getNext()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = this.head.getNext();

        // 遍历找到最后节点
        while (true) {
            if (null == temp) {
                System.out.println("没有找到该节点！" + newNode.getNo());
                break;
            }
            if (temp.getNo() == newNode.getNo()) {
                temp.setName(newNode.getName());
                temp.setNickname(newNode.getNickname());
                break;
            }
            temp = temp.getNext();
        }
    }

    public void delete(int no) {
        if (null == this.head.getNext()) {
            System.out.println("链表节点为空");
            return;
        }
        HeroNode temp = this.head;
        while (true) {
            if (null == temp.getNext()) {
                System.out.println("没有找到链表节点");
                break;
            }
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    public int getLength(HeroNode head) {
        if (null == head.getNext()) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.getNext();

        while (null != cur) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    public void reverseList(HeroNode head) {
        if (null == head.getNext() || null == head.getNext().getNext()) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");

        // 临时变量记录head
        while (true) {
            HeroNode cur = head.getNext();
            if (null == cur) {
                break;
            }
            head.setNext(head.getNext().getNext());
            // 把当前节点挪到reverseHead上
            cur.setNext(reverseHead.getNext());
            reverseHead.setNext(cur);
        }
        head.setNext(reverseHead.getNext());
    }

    public HeroNode findLastIndexNode(HeroNode head, int index) {
        // 没有找到
        if (null == head.getNext()) {
            return null;
        }
        // 第一个遍历得到链表的长度
        int size = this.getLength(head);
        // 遍历到size-index 就是我们找的位置
        if (index <= 0 || index > size) {
            return null;
        }
        // 设定当前为第一个开始，然后循环size-index
        HeroNode current = head.getNext();
        for (int i = 0; i < size - index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void list() {
        if (null == head.getNext()) {
            return;
        }
        HeroNode temp = this.head.getNext();
        do {
            System.out.println(temp);
        } while (null != (temp = temp.getNext()));
    }

    public void reversePrint(HeroNode head) {
        if (null == head.getNext()) {
            System.out.println("链表为空");
        }
        Stack<HeroNode> nodes = new Stack<>();
        HeroNode temp = head.getNext();
        while (null != temp) {
            nodes.push(temp);
            temp = temp.getNext();
        }
        while (!nodes.empty()) {
            System.out.println(nodes.pop());
        }
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode songHero = new HeroNode(1, "松江", "及时雨");
        HeroNode luHero = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode wuHero = new HeroNode(3, "吴用", "智多星");
        HeroNode linHero = new HeroNode(4, "林冲", "豹子头");
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

        linkedList.update(new HeroNode(2, "马聪聪", "mc聪"));
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
