package com.example.algorithm.structure;

/**
 * @ClassName ListNode
 * @Description 单项链表对象
 * @Author jianshengfei
 * @Date 2021/6/28 0:27
 */
public class ListNode<E> {

    public E val;
    public ListNode next;

    public ListNode() {}

    public ListNode(E val) {
        this.val = val;
    }

    public ListNode(E val, ListNode next) {
        this.val = val; this.next = next;
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
