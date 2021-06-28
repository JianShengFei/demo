package com.example.algorithm.util;

import com.example.algorithm.structure.ListNode;

/**
 * @ClassName ListNodeUtil
 * @Description 单向链表工具类
 * @Author jianshengfei
 * @Date 2021/6/28 21:37
 */
public class ListNodeUtil<E> {

    public ListNode arrayToListNode(E[] array) {
        if(array == null) {
            return null;
        }

        ListNode root = new ListNode(array[0]);
        ListNode other = root;
        for (int i = 1; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    /**
     * 遍历节点及节点下所有节点val
     * 方便查看结果
     * @param head
     */
    public void ergodic(ListNode head) {
        if(head == null) {
            return;
        }

        System.out.print(head.val + "  ");
        while (head.next != null) {
            ListNode next = head.next;
            System.out.print(next.val + "  ");
            head = next;
        }
        System.out.println();
    }





}
