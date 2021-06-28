package com.example.algorithm.medium;

import com.example.algorithm.structure.ListNode;

/**
 * @ClassName RemoveNthFromEnd
 * @Description 删除链表的倒数第 N 个结点
 * @Author jianshengfei
 * @Date 2021/6/28 0:17
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {




    }


    /**
     * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *              进阶：你能尝试使用一趟扫描实现吗？
     *              示例1：
     *              输入：head = [1,2,3,4,5], n = 2
     *              输出：[1,2,3,5]
     *              示例2：
     *              输入：head = [1], n = 1
     *              输出：[]
     *              示例3：
     *              输入：head = [1,2], n = 1
     *              输出：[1]
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        // 哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 1; i < n +1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;

        return dummy.next;
    }


}
