package com.ash.page.sort;

import cn.hutool.json.JSONUtil;
import com.ash.page.FieldMappingCondition;
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
        FieldMappingCondition fieldMappingCondition = new FieldMappingCondition().setSingle(true);


        OrderByFieldUtil orderByFieldUtil = new OrderByFieldUtil(fieldMappingCondition);

        Map<String, String> orderByFieldsMap = orderByFieldUtil.getOrderByFieldsMap(OrderByMappingBean.class);

//        new orderByFieldUtil(new FieldMappingCondition().setOpenHump(true)).getOrderByFieldsMap()


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
