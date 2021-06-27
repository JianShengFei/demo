package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;
import org.junit.Test;

/**
 * @ClassName ReversalList
 * @Description 反转链表I
 * @Author jianshengfei
 * @Date 2021/6/27 22:07
 */
public class ReversalListI {

    @Test
    public void test01(){
        // 构建单向链表
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        head.ergodic(head);

        ListNode newHead = reversalList(head);

        head.ergodic(newHead);
    }


    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reversalList(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode current = prev.next;

        // 上来先把头节点的下一个节点设置为 null
        prev.next = null;

        while (current != null) {
            // 1 记录当前节点的下一个节点
            ListNode next = current.next;
            // 2 设置当前节点的下一个节点为上一个节点
            current.next = prev;
            // 3 将上一个节点设置为当前节点
            prev = current;
            // 4 设置当前节点为下一个节点
            current = next;
        }

        return prev;
    }




}
