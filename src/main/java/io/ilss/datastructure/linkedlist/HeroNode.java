package io.ilss.datastructure.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author feng
 */
@Setter
@Getter
public class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
