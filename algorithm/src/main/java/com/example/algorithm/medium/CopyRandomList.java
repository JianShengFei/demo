package com.example.algorithm.medium;

import com.example.algorithm.structure.RandomListNode;

import java.util.HashMap;
import java.util.Random;


/**
 * @ClassName CopyRandomList
 * @Description Random 链表 深克隆
 * @Author jianshengfei
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


        RandomListNode randomListNode = copyRandomNodeByMap(one);

        while (randomListNode != null) {
            System.out.println(randomListNode.val);
            if(randomListNode.random != null) {
                System.out.println(randomListNode.random.val);
            }
            System.out.println("-----------------------------");
            randomListNode = randomListNode.next;
        }

    }


    public static RandomListNode copyRandomList(RandomListNode head){

        if(head == null) {
            return null;
        }

        copy(head);

        copyRandom(head);

        return split(head);
    }

    private static void copy(RandomListNode head) {
        // TODO 克隆node
        if(head == null) {
            return;
        }

        while (head != null) {

        }

    }

    private static void copyRandom(RandomListNode head) {
        // TODO 克隆random node
    }

    private static RandomListNode split(RandomListNode head) {
        // TODO 拆分linked list
        return null;
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
