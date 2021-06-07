package com.ash.page;

import lombok.*;

import java.util.List;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName FieldMappingCondition.java
 * @Description 字段映射条件构造器对象
 * @createTime 2021年06月07日 19:49
 */
public class FieldMappingCondition {

    /**
     * 是否单例
     * 指在指定场景下，需要使用到同一个容器的时候, 设置的参数
     * boolean 基础类型默认 false, 即为不开启单例模式
     */
    public boolean isSingle;

    public boolean isOpenHump;

    public List<String> ignoreFields;


//    public FieldMappingCondition() {
//        this(null);
//    }
//
//    public FieldMappingCondition() {
//        this(null);
//    }



    public FieldMappingCondition setSingle(boolean single) {
        isSingle = single;
        return this;
    }

    public FieldMappingCondition setOpenHump(boolean openHump) {
        isOpenHump = openHump;
        return this;
    }

    public FieldMappingCondition setIgnoreFields(List<String> ignoreFields) {
        this.ignoreFields = ignoreFields;
        return this;
    }


    public boolean isSingle() {
        return isSingle;
    }

    public boolean isOpenHump() {
        return isOpenHump;
    }

    public List<String> getIgnoreFields() {
        return ignoreFields;
    }

}
