package com.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: XF-DD
 * @Date: 2020/7/29 20:00
 */
public class NumberUtils {

    public static BigDecimal ZERO_VALUE = new BigDecimal("0.00");

    /**
     * @param o          需要转换的对象 o若是double或者BigDecimal,则只取整数部分
     * @param defaultVal 默认值
     * @return 如果obj为空则返回默认，不为空则返回转换后的long结果
     */
    public static Long toLong(Object o, Long defaultVal) {
        if (o == null || "".equals(o.toString())) {
            return defaultVal;
        }
        String s = o.toString();
        // 若是有小数，舍弃小数点后所有
        if (s.indexOf('.') != -1) {
            return Long.parseLong(s.substring(0, s.indexOf('.')));
        }
        return Long.parseLong(o.toString());
    }

    public static Long toLong(Object o) {
        return toLong(o, 0L);
    }

    public static BigDecimal toBigDecimal(Object o) {
        return toBigDecimal(o, new BigDecimal("0.00"), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal toBigDecimal(Object o, int scale) {
        return toBigDecimal(o, new BigDecimal("0.00"), scale, RoundingMode.HALF_UP);
    }

    public static BigDecimal toBigDecimal(Object o, BigDecimal defaultVal, int scale) {
        return toBigDecimal(o, defaultVal, scale, RoundingMode.HALF_UP);
    }

    /**
     * 将对象转成 BigDecimal
     *
     * @param o          源对象
     * @param defaultVal 默认值
     * @param scale      保留几位
     * @param mode       取模类型
     * @return
     */
    public static BigDecimal toBigDecimal(Object o, BigDecimal defaultVal, int scale, RoundingMode mode) {
        if (o == null || "".equals(o.toString())) {
            return defaultVal.setScale(scale, mode);
        }
        return new BigDecimal(o.toString()).setScale(scale, mode);
    }

    /**
     * BigDecimal 的快速除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    保留几位 (默认2位)
     * @param mode     取模类型 （默认HALF_UP）
     * @return
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale, RoundingMode mode) {
        BigDecimal res0 = new BigDecimal("0.00");
        if (dividend == null || dividend.compareTo(res0) == 0 || divisor == null || divisor.compareTo(res0) == 0) {
            return res0.setScale(2, mode);
        }
        return dividend.divide(divisor, scale, mode);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale) {
        return divide(dividend, divisor, scale, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return divide(dividend, divisor, 2, RoundingMode.HALF_UP);
    }

    /**
     * 将对象转成BigDecimal进行运算，轻易别尝试传奇怪的东西！
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    保留几位
     * @return
     */
    public static BigDecimal divideObj(Object dividend, Object divisor, int scale) {
        return divide(toBigDecimal(dividend), toBigDecimal(divisor), scale, RoundingMode.HALF_UP);
    }

    public static BigDecimal divideObj(Object dividend, Object divisor) {
        return divide(toBigDecimal(dividend), toBigDecimal(divisor), 2, RoundingMode.HALF_UP);
    }

    /**
     * 将对象转化为百分比
     *
     * @param o
     */
    public static String formatRate(Object o) {
        if (o == null) {
            return "0%";
        }
        BigDecimal decimal = toBigDecimal(o);
        BigDecimal multiply = decimal.multiply(new BigDecimal("100.00"));
        return toBigDecimal(multiply).toString() + "%";
    }

    /**
     * 比较BigDecimal , 相同返回true
     *
     * @param a
     * @param b
     * @return
     */
    public static Boolean bigDecimalCompare(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 0;
    }

    public static Boolean bigDecimalIsZero(BigDecimal a) {
        return bigDecimalCompare(a, ZERO_VALUE);
    }

    /**
     * 把对象转换成String
     *
     * @param o
     * @param defaultValue
     * @return
     */
    public static String toStr(Object o, String defaultValue) {
        if (o == null) {
            return defaultValue;
        }
        return o.toString();
    }

    public static String toStr(Object o) {
        return toStr(o, "");
    }

    /**
     * 正则表达式：是否含有字母，有返回true
     *
     * @param s
     * @return boolean
     * @author BNMZY
     */
    public static boolean hasStr(String s) {
        String regex1 = ".*[a-zA-z].*";
        return s.matches(regex1);
    }

}
