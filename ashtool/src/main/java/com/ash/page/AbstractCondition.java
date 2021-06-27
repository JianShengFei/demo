package com.ash.page;

import java.lang.reflect.ParameterizedType;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName AbstractCondition.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年06月08日 09:28
 */
public abstract class AbstractCondition<T> {

    protected Class<T> entityClass;

    public Class initGenericParadigm() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return entityClass;
    }

}
