package com.ash.page.sort;

import cn.hutool.json.JSONUtil;
import com.ash.page.FieldMappingCondition;
import com.ash.page.OrderByFieldUtil;
import org.junit.jupiter.api.Test;

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

        OrderByFieldUtil orderByFieldUtil = new OrderByFieldUtil();

        FieldMappingCondition<OrderByMappingBean> condition = new FieldMappingCondition().setSingle(true);



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
