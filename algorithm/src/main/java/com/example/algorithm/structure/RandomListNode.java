package com.example.algorithm.structure;

/**
 * @ClassName RandomListNode
 * @Description 单向+随机指向 链表节点 对象
 * @Author jianshengfei
 * @Date 2021/6/28 21:50
 */
public class RandomListNode<E> {

    public E val;

    public RandomListNode next;

    public RandomListNode random;

    public RandomListNode(E val) {
        this.val = val;
    }
}
