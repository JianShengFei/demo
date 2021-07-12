package com.example.algorithm;

import com.example.algorithm.easy.FindTheDifference;
import org.junit.Test;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName BitOperationTest.java
 * @Description 位运算 test
 * @createTime 2021年07月05日 15:24
 */
public class BitOperationTest {


    @Test
    public void test01(){

        int a = 3;
        int b = 4;
        System.out.println(a & a);
        System.out.println(b & b);
        System.out.println(a & b);

        System.out.println(a | a);
        System.out.println(b | b);
        System.out.println(a | b);


        System.out.println(5 | 9);

    }

    @Test
    public void test02(){

        String a = "ABABDCUDCU";
        FindTheDifference difference = new FindTheDifference();
        Character theDifference = difference.findTheDifference(a, "");
        System.out.println(theDifference);

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            System.out.println(c);
        }

    }

    /**
     * 交换两个变量的值
     */
    @Test
    public void test03(){

        /*
            利用 异或 的特性
            a ^ b = c   b = a ^ c   c = a ^ b
         */

        int a = 3;
        int b = 5;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

//        a = a + b;
//        b = a - b;
//        a = a - b;

        System.out.println(a);
        System.out.println(b);

        String a1 = "简";
        String b1 = "简";

        System.out.println(a1.hashCode());
        System.out.println(b1.hashCode());

    }


}
