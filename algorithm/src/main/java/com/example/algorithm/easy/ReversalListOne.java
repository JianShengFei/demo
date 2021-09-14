package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.util.ListNodeUtil;


/**
 * @ClassName ReversalList
 * @Description 反转链表I
 * @Author Ash Jan
 * @Date 2021/6/27 22:07
 */
public class ReversalListOne {

    private static ListNodeUtil listNodeUtil = new ListNodeUtil();

    public static void main(String[] args) {
        // 构建单向链表
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        listNodeUtil.ergodic(head);

        ListNode newHead = reversalList(head);

        listNodeUtil.ergodic(newHead);
    }


    /**
     * 链表反转
     * 案列：
     * 输入：[1, 2, 3, 4, 5]
     * 输出：[5, 4, 3, 2, 1]
     *
     * @param head
     * @return
     */
    public static ListNode reversalList(ListNode head) {

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
