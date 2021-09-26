package com.example.algorithm.structure;

/**
 * @ClassName DoubleLinkedList
 * @Description 双向链表节点对象
 * @Author Ash Jan
 * @Date 2021/6/28 21:42
 */
public class DoublyListNode<E> {

    /**
     * 节点value值
     */
    public E val;

    /**
     * 上一个节点
     */
    public DoublyListNode prev;

    /**
     * 下一个节点
     */
    public DoublyListNode next;

    public DoublyListNode(E val) {
        this.val = val;
    }

}
