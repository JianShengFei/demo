package com.ash.page;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName FieldMappingCondition.java
 * @Description 字段映射条件构造器对象
 * @createTime 2021年06月07日 19:49
 */
@Slf4j
public class FieldMappingCondition<T> {

    /**
     * 是否单例
     * 指在指定场景下，需要使用到同一个容器的时候, 设置的参数
     * boolean 基础类型默认 false, 即为不开启单例模式
     */
    public boolean isSingle;

    public boolean isOpenHump;

    public List<String> ignoreFields;

    protected Class<T> entityClass;

    public Class initGenericParadigm(int index) {
        Type genType = this.getClass().getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            log.warn(this.getClass().getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if ((index >= params.length) || (index < 0)) {
            log.warn("Index: " + index + ", Size of " + this.getClass().getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            log.warn(this.getClass().getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

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
