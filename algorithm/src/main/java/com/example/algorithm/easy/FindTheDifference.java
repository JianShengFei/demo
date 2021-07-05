package com.example.algorithm.easy;

/**
 * @author jianshengfei
 * @Description 字符串找不同
 * @create 2020-12-18 12:48
 */
public class FindTheDifference {

    public static void main(String[] args) {
        char c = findTheDifference("abcd", "abcde");
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
     * @return Character
     */
    public static Character findTheDifference(String s, String t) {

        if(s == null || t == null) {
            return null;
        }

        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            System.out.println(s.charAt(i) + ", s.charAt(i):   " + Integer.toBinaryString(s.charAt(i)));
            System.out.println("        ret:   " + Integer.toBinaryString(ret));
            ret ^= s.charAt(i);
            System.out.println("result  ret:   " + Integer.toBinaryString(ret));
            System.out.println("________________________");
        }

        System.out.println("_______________________________________________");
        System.out.println(ret);
        System.out.println("_______________________________________________");

        for (int i = 0; i < t.length(); ++i) {
            System.out.println(t.charAt(i) + ", t.charAt(i):" + Integer.toBinaryString(t.charAt(i)));
            System.out.println("        ret:   " + Integer.toBinaryString(ret));
            ret ^= t.charAt(i);
            System.out.println("result  ret:   " + Integer.toBinaryString(ret));
            System.out.println("_________________________");
        }
        return (char) ret;
    }

}
