package com.example.algorithm.medium;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.util.ListNodeUtil;

/**
 * @ClassName ReversalListII
 * @Description 反转链表II
 * @Author jianshengfei
 * @Date 2021/6/27 22:11
 */
public class ReversalListTwo {

    private static ListNodeUtil listNodeUtil = new ListNodeUtil();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        listNodeUtil.ergodic(head);

        ListNode node = reversalBetween(head, 2, 4);

        listNodeUtil.ergodic(node);
    }

    /**
     * 反转链表II
     * 给一个单向链表，按传入的两个数，将对应的链表节点反转
     *
     * 案列：
     * 输入：[1, 2, 3, 4, 5, 6, 7], 2, 4
     * 输出：[1, 5, 4, 3, 2, 6, 7]
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reversalBetween(ListNode head, int left, int right){

        if(head == null || left >= right) {
            return head;
        }

        // 哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        // 找到m节点
        for (int i = 1; i < left; i++) {
            head = head.next;
        }

        ListNode prevM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        for (int i = left; i < right; i++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
    }




}
