package com.example.algorithm.basics;

/**
 * @author Ash Jan
 * @Description
 * @create 2020-12-18 13:06
 */
public class BitOperation {

    /**
     * --> 计算编码规则
     * 理解有符号数和无符号数 - 博客园
     * https://www.cnblogs.com/lazycoding/archive/2011/03/21/unsigned-signed.html
     *
     */
    public static void main(String[] args) {
        //  & 与
        and(3, 5);
        System.out.println("-----------------------------");
        or(3, 5);
        System.out.println("-----------------------------");
        exclusiveOr(3, 5);
        System.out.println("-----------------------------");

        System.out.println( 1 + 4);

        System.out.println(add(9, 14));


        int a1 = 2147483647;
        System.out.println(Integer.toBinaryString(a1));
        System.out.println(Integer.toBinaryString(a1).length());

    }

    /**
     * 位运算  四则运算  加法
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b){
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }


    public static void and(int a, int b){
        /* 与 运算，将两个数转为 二进制，按位进行 比较
                3: 0  1  1
                5: 1  0  1
             =  3: 0  0  1
         */
        System.out.println("与运算-> " + a + "&" + b +" 结果："+ (a & b));
    }

    public static void or(int a, int b){
        /*
            或 运算，将两个数转为 二进制，按位进行 比较
                3: 0 1 1
                5: 1 0 1
               =7: 1 1 1
         */
        System.out.println("或运算-> " + a + "|" + b +" 结果："+ (a | b));
    }

    public static void exclusiveOr(int a, int b){
        /*
            异或 运算，将两个数转为 二进制，按位进行 比较, 相同 = 0， 不相同 = 1
                3: 0 1 1
                5: 1 0 1
               =7: 1 1 0
         */
        System.out.println("异或运算-> " + a + "^" + b +" 结果："+ (a ^ b));
    }



}
