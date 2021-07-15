package com.ash.page;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @Description 自定义排序字段映射工具类
 * @ClassName OrderByFieldUtil.java
 * @createTime 2021年04月13日 13:02
 */
public class OrderByFieldUtil {

    /**
     * 字段映射容器
     */
    private volatile Map<String, String> fmc;

    /**
     * 条件构造器, 主要用于构造不同场景需要的变量参数
     */
    private volatile FieldMappingCondition condition;

    public OrderByFieldUtil() {}

    /**
     * 返回字段映射容器, 提供一个获取容器的方法
     * @return
     */
    public Map<String, String> fmc() {
        return this.fmc;
    }

    private void init(FieldMappingCondition condition){
        this.condition = condition;
        if(this.condition.isSingle) {
            // 单列模式下, 容器为空  初始化一个默认16长度的 cMap
            if(CollectionUtil.isEmpty(fmc)) {
                fmc = new ConcurrentHashMap<>(16);
            }
        }else {
            fmc = new HashMap<>(condition.entityClass.getDeclaredFields().length);
        }
        if(this.condition.entityClass == null) {
            this.condition.entityClass = condition.initGenericParadigm(0);
        }
    }

    /**
     * 动态获取对应实体对象 @TableField 注解的字段，用于排序获取对应数据库
     * 当没有此注解时, isOpenHump = true, 否则导致映射容器为空, 从而报错
     * <p><font color = #e60039>适用此方法时，请注意返回的实体对象 和 instance 一致, 避免前端传错</font></p>
     *
     * <p><font color = #e60039>使用到反射，请勿滥用</font></p>
     *
     * @param condition 条件构造器
     * @return
     * @throws NoSuchFieldException
     */
    public Map<String, String> getOrderByFieldsMap(FieldMappingCondition condition) {
        if(condition == null) {
            throw new NullPointerException("condition bean is be not null");
        }

        init(condition);



        if(this.condition.entityClass == null) {
            throw new NullPointerException("The entityClass is null");
        }

        Field[] fields = this.condition.entityClass.getDeclaredFields();
        if(fields.length == 0 && !this.condition.isOpenHump) {
            throw new NullPointerException("The number of object fields is 0");
        }

        // 单例模式, 无需考虑线程安全, 直接使用普通的 hashMap
        fmc = condition.isSingle() ? fmc : new HashMap(fields.length);
        boolean ignoreIsNull = CollectionUtil.isEmpty(this.condition.getIgnoreFields());

        for (int i = 0; i < fields.length; i++) {
            if(ignoreIsNull) {
                putOrIgnoreByTableField(fmc, fields[i], this.condition.isOpenHump);
            }else{
                // 除过fieldMap中的属性，其他属性都获取
                if(!this.condition.getIgnoreFields().contains(fields[i].getName())) {
                    putOrIgnoreByTableField(fmc, fields[i], this.condition.isOpenHump);
                }
            }
        }

        if(CollectionUtil.isEmpty(fmc)) {
            throw new NullPointerException("The mapping field container is empty");
        }

        return fmc;
    }

    /**
     * 根据 @TableField put or ignore
     * !优化 @TableField 注解可尝试传入自定义的
     * @param fmc 映射字段容器
     * @param field 映射的字段
     * @param isOpenHump 是否开启驼峰转下划线模式
     */
    private static void putOrIgnoreByTableField(Map<String, String> fmc, Field field, boolean isOpenHump){
        String name = null;
        // 开启驼峰转下划线，则优先取字段名
        if(isOpenHump) {
            name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
        } else {
            boolean annotationPresent = field.isAnnotationPresent(TableField.class);
            if (annotationPresent) {
                // 获取注解值
                name = field.getAnnotation(TableField.class).value();
            }
        }
        if(StringUtils.isNotEmpty(name)) {
            fmc.put(field.getName(), name);
        }
    }

}
