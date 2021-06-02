package com.example.algorithm.easy;

/**
 * @author Jianshengfei
 * @Description
 * @create 2020-12-18 12:48
 */
public class findTheDifference {

    public static void main(String[] args) {

        char a = 'a';
        char b = 'b';
        System.out.println(a ^ b);

        int num1 = 3;
        int num2 = 5;
        System.out.println(num1 ^ num2);

        char c = findTheDifference(null, "abcde");
        System.out.println(c);

    }

    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     *
     * 例1：
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     *
     * 例2：
     * 输入：s = "", t = "y"
     * 输出："y"
     * 2020年12月15日  jianshengfei
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            System.out.println(s.charAt(i) + "s.charAt(i):   " + Integer.toBinaryString(s.charAt(i)));
            System.out.println("        ret:   " + Integer.toBinaryString(ret));
            ret ^= s.charAt(i);
            System.out.println("result  ret:   " + Integer.toBinaryString(ret));
            System.out.println("_______________________________________________");
        }
        System.out.println(ret);
        for (int i = 0; i < t.length(); ++i) {
            System.out.println(t.charAt(i) + "s.charAt(i):" + Integer.toBinaryString(t.charAt(i)));
            System.out.println("        ret:   " + Integer.toBinaryString(ret));
            ret ^= t.charAt(i);
            System.out.println("result  ret:   " + Integer.toBinaryString(ret));
            System.out.println("_______________________________________________");
        }
        return (char) ret;
    }

}
