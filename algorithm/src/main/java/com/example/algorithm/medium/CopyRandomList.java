package com.example.algorithm.medium;

import com.example.algorithm.structure.RandomListNode;

import java.util.HashMap;
import java.util.Random;


/**
 * @ClassName CopyRandomList
 * @Description Random 链表 深克隆
 * @Author Ash Jan
 * @Date 2021/6/28 21:50
 */
public class CopyRandomList {

    public static void main(String[] args) {

        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode san = new RandomListNode(3);
        one.next = two;
        two.next = san;
        one.random = san;


        RandomListNode randomListNode1 = copyRandomNodeByMap(one);
        iterationRandomList(randomListNode1);

        System.out.println("-------------------------------------------");

        RandomListNode randomListNode2 = copyRandomList(one);
        iterationRandomList(randomListNode2);
    }

    /**
     * 遍历打印 random 链表
     * @param head
     */
    public static void iterationRandomList(RandomListNode head){
        while (head != null) {
            System.out.print("node: " + head.val + "   ");
            if(head.random != null) {
                System.out.print("random: " + head.random.val + "   ");
            }
            System.out.println();
            head = head.next;
        }
    }


    /**
     * 通过构建重复节点后 拆分链表 复制链表
     *
     * [1, 2, 3]  =>  [1, 1`, 2, 2`, 3, 3`]  =>  [1`, 2`, 3`]
     *
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }

    /**
     * copy 节点
     * @param head
     */
    private static void copy(RandomListNode head) {
        if(head == null) {
            return;
        }

        RandomListNode newHead = head;
        while (newHead != null) {
            RandomListNode next = newHead.next;
            RandomListNode copyNode = new RandomListNode(newHead.val);
            newHead.next = copyNode;
            copyNode.next = next;
            newHead = next;
        }
    }

    /**
     * copy random 节点
     * @param head
     */
    private static void copyRandom(RandomListNode head) {
        RandomListNode newHead = head;
        // 当前节点和节点的复制节点不为空时 继续
        while (newHead != null && newHead.next != null) {
            if(newHead.random != null) {
                RandomListNode copyRandom = new RandomListNode(newHead.random.val);
                newHead.next.random = copyRandom;
            }
            newHead = newHead.next.next;
        }
    }

    /**
     * 分隔 random 链表
     * @param head
     * @return
     */
    private static RandomListNode split(RandomListNode head) {
        RandomListNode result = head.next;
        RandomListNode move = head.next;

        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
            if(move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }


    /**
     * 使用 hashMap 映射 实现，链表复制
     * @param head
     * @return
     */
    public static RandomListNode copyRandomNodeByMap(RandomListNode head){
        if(head == null) {
            return null;
        }

        // 定义一个节点映射
        HashMap<RandomListNode, RandomListNode> map = new HashMap(10);

        RandomListNode newHead = head;
        while (newHead != null) {
            if(!map.containsKey(newHead)) {
                RandomListNode copyNode = new RandomListNode(newHead.val);
                map.put(newHead, copyNode);
            }
            if(newHead.random != null) {
                RandomListNode random = newHead.random;
                if(!map.containsKey(random)) {
                    RandomListNode<Object> copyRandom = new RandomListNode<>(random.val);
                    map.put(random, copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }

        newHead = head;

        while (newHead != null) {
            RandomListNode next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }
        return map.get(head);
    }


}
