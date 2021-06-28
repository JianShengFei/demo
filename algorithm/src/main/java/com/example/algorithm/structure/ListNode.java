package com.example.algorithm.structure;

/**
 * @ClassName ListNode
 * @Description 单项链表节点对象
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

}
