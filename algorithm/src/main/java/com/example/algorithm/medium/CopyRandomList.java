package com.example.algorithm.medium;

import com.example.algorithm.structure.RandomListNode;


/**
 * @ClassName CopyRandomList
 * @Description Random 链表 深克隆
 * @Author jianshengfei
 * @Date 2021/6/28 21:50
 */
public class CopyRandomList {


    public RandomListNode copyRandomList(RandomListNode head){

        if(head == null) {
            return null;
        }

        copy(head);

        copyRandom(head);

        return split(head);
    }

    private void copy(RandomListNode head) {
        // TODO 克隆node
        if(head == null) {
            return;
        }

        while (head != null) {

        }

    }

    private void copyRandom(RandomListNode head) {
        // TODO 克隆random node
    }

    private RandomListNode split(RandomListNode head) {
        // TODO 拆分linked list
        return null;
    }


}
