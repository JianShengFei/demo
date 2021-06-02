package com.example.algorithm.easy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Jianshengfei
 * @Description
 * @create 2020-12-21 18:30
 */
public class LinkedNodeClone {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.2223");
        BigDecimal b = new BigDecimal("333.2223");

        double a1 = a.doubleValue();
        double b1 = b.doubleValue();

        BigDecimal result = new BigDecimal((b1 - a1)/b1);
        BigDecimal bigDecimal = result.setScale(2, RoundingMode.HALF_UP);

        System.out.println(bigDecimal);

    }

    private static class LinkedNode{

        private LinkedNode next;

        private LinkedNode random;

        public LinkedNode() {

        }

        public LinkedNode(LinkedNode next, LinkedNode random) {
            this.next = next;
            this.random = random;
        }
    }

    public static LinkedNode linkedNodeClone(LinkedNode linkedNode){

        if (linkedNode == null) return null;

        while (linkedNode != null){
            LinkedNode newNode = new LinkedNode();
            newNode.next = linkedNode.next;
            linkedNode.next = newNode;
            linkedNode = newNode.next;
        }

        return null;
    }

}
