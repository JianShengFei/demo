package com.ash.util.time.enums;

/**
 * @author Ash Jan
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

}
