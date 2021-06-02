package com.ash.page.sort;

import cn.hutool.json.JSONUtil;
import com.ash.page.OrderByFieldUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName OrderByFieldTest.java
 * @Description 分页工具测试
 * @createTime 2021年06月02日 15:42
 */
public class OrderByFieldTest {

    @Test
    public void testOrderBy(){
        Map<String, String> orderByFieldsMap1 = OrderByFieldUtil.getOrderByFieldsMap(OrderByMappingBean.class);
        Map<String, String> orderByFieldsMap2 = OrderByFieldUtil.getOrderByFieldsMap(OrderByMappingBean.class, true);

        // 忽略的字段集合
        List<String> ignoreFields = new ArrayList<>();
        ignoreFields.add("password");
        Map<String, String> orderByFieldsMap3 = OrderByFieldUtil.getOrderByFieldsMap(OrderByMappingBean.class, ignoreFields);
        Map<String, String> orderByFieldsMap4 = OrderByFieldUtil.getOrderByFieldsMap(OrderByMappingBean.class, ignoreFields, true);

        System.out.println("-----------------1-------------->> null");
        printMap(orderByFieldsMap1);
        System.out.println("-----------------2-------------->> 4");
        printMap(orderByFieldsMap2);
        System.out.println("-----------------3-------------->> null");
        printMap(orderByFieldsMap3);
        System.out.println("-----------------4-------------->> 3");
        printMap(orderByFieldsMap4);

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
