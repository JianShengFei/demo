package com.ash.util.reflect;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description public class Demo1<T1, T2 extends Integer, T3 extends Demo1I1 & Demo1I2>
 * @createTime 2021年07月15日 13:55
 */
public class Demo1<T1, T2 extends Integer, T3 extends Demo1T1> {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo1 demo11 = new Demo1();
        Integer i = new Integer(3);
        Demo111 demo111 = new Demo111();

        Demo1T1 s = demo1.m1(demo11, i, demo111, "S");
        System.out.println(s);
    }

    public static class Demo111 extends Demo1T1{

    }

    public <T1, T2 extends Integer, T3 extends Demo1T1> T3 m1(T1 t1, T2 t2, T3 t3, String s) {
        return t3;
    }


    public void test01() {

    }


}
