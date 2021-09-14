package com.example.algorithm.medium;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.util.ListNodeUtil;

/**
 * @ClassName AddTwoNumbers
 * @Description 链表相加
 * @Author Ash Jan
 * @Date 2021/7/4 14:23
 */
public class AddTwoNumbers {

    private static ListNodeUtil listNodeUtil = new ListNodeUtil();

    public static void main(String[] args) {

        Integer[] array1 = new Integer[]{2, 3, 6};
        Integer[] array2 = new Integer[]{4, 7, 1};
        ListNode l1 = listNodeUtil.arrayToListNode(array1);
        ListNode l2 = listNodeUtil.arrayToListNode(array2);

        ListNode node = addTwoNumbers(l1, l2); // 6, 0, 8

        listNodeUtil.ergodic(node);

    }


    /**
     * 给定两个链表 各位按10进制相加
     *
     * 案列:
     * INPUT: [2, 3, 6] [4, 7, 1]
     * OUTPUT: [6, 0, 8]
     *
     * 描述：相当于 632 + 147 = 806
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            // 两个数相加 并且算上进位的值
            int number = val1 + val2 + carry;
            // 计算进位
            carry = number / 10;
            ListNode next = new ListNode(number % 10);
            pre.next = next;
            pre = pre.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }

        return dummy.next;
    }


}
