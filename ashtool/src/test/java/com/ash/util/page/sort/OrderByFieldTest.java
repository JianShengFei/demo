package com.ash.util.page.sort;

import cn.hutool.json.JSONUtil;
import com.ash.util.page.FieldMappingCondition;
import com.ash.util.page.OrderByFieldUtil;
import org.junit.jupiter.api.Test;


import java.util.Map;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName OrderByFieldTest.java
 * @Description 分页工具测试
 * @createTime 2021年06月02日 15:42
 */
public class OrderByFieldTest {

    @Test
    public void testOrderBy(){

        OrderByFieldUtil orderByFieldUtil = new OrderByFieldUtil();

        FieldMappingCondition<OrderByMappingBean> condition = new FieldMappingCondition().setSingle(true);

        Map<String, String> orderByFieldsMap = orderByFieldUtil.getOrderByFieldsMap(condition);

        System.out.println(orderByFieldsMap);



    }

    /**
     * 打印 map
     * @param map
     */
    private void printMap(Map map){
        for (Object o : map.entrySet()) {
            System.out.println(JSONUtil.toJsonStr(o));
        }
    }


}
