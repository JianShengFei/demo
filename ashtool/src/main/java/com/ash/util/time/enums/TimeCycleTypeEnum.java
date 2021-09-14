package com.ash.util.time.enums;

import cn.hutool.core.util.EnumUtil;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName TimeCycleTypeEnum.java
 * @Description 周期时间类型定义
 * @createTime 2021年09月13日 13:59
 */
public enum TimeCycleTypeEnum {

    /**
     * 日
     */
    DAYS("日"),
    /**
     * 周
     */
    WEEKS("周"),
    /**
     * 月
     */
    MONTHS("月")
    ;

    private String name;

    public String getName() {
        return name;
    }

    TimeCycleTypeEnum(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        boolean contains = EnumUtil.contains(TimeCycleTypeEnum.class, "日");
        System.out.println(contains);

    }

}
