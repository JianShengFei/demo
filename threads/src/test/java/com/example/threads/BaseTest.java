package com.example.threads;

import cn.hutool.core.convert.Convert;
import com.example.util.DateUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName BaseTest.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年05月07日 15:42
 */
public class BaseTest {


    @Test
    public void test01() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse("2021-05-08 15:42:01");

        Date nowDate = new Date();
        Date startDate = Convert.toDate(start);
        Date endDate = cn.hutool.core.date.DateUtil.offsetMinute(nowDate, -(Convert.toInt(30 + 5)));

        System.out.println(DateUtil.DateToStr(startDate));
        System.out.println(DateUtil.DateToStr(endDate));
    }

    @Test
    public void test02(){
        String price = "0.1";
        BigDecimal priceConfig = new BigDecimal(price).multiply(BigDecimal.valueOf(100)).setScale(0, ROUND_HALF_UP);
        System.out.println(priceConfig);
    }

    @Test
    public void test03(){
        NodeTree nodeTree = new NodeTree();
        nodeTree.setData("简圣飞");
        System.out.println(nodeTree);
    }

    @Data
    public class NodeTree{
        private NodeTree leftNode;
        private NodeTree rightNode;
        private Object data;
    }

}
