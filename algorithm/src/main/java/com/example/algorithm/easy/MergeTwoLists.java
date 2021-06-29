package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.util.ListNodeUtil;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName MergeTwoLists.java
 * @Description 合并两个有序链表
 * @createTime 2021年06月29日 15:55
 */
public class MergeTwoLists {

    private static ListNodeUtil listNodeUtil = new ListNodeUtil();

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 4};
        ListNode listNode1 = listNodeUtil.arrayToListNode(array);
        array = new Integer[]{1, 3, 4};
        ListNode listNode2 = listNodeUtil.arrayToListNode(array);

        ListNode listNode = mergeTwoListsRecursion(listNode1, listNode2);
        listNodeUtil.ergodic(listNode);

    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     *
     * 案列：
     * 输入: l1: [1, 2, 4]  l2: [1, 3, 4]
     * 输出: [1, 1, 2, 3, 4, 4]
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsRecursion(ListNode<Integer> l1, ListNode<Integer> l2) {
        /*  递归 无限套娃
                    l1     l2
            第一次:   1      1
            第二次:   1      3
            第三次:   2      3
            第四次:   4      3
            第五次:   4      4
            第六次:   4

            [1  1  2  3  4  4]
         */
        System.out.println();
        if(l1 != null && l1.val != null) {
            System.out.print("l1 val :" + l1.val);
        }
        System.out.print("      ");
        if(l2 != null && l2.val != null) {
            System.out.print("l2 val :" + l2.val);
        }
        System.out.print("      ");

        if(l1 == null) {
            System.out.print("choose l2");
            return l2;
        }else if(l2 == null) {
            System.out.print("choose l1");
            return l1;
        }else if(l1.val.intValue() < l2.val.intValue()) {
            System.out.print("choose l1");
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        }else{
            System.out.print("choose l2");
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoListsIteration(ListNode<Integer> l1, ListNode<Integer> l2) {

        // 迭代

        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }





        return null;
    }



}
