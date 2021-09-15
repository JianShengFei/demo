package com.ash.util;

import cn.hutool.core.util.EnumUtil;
import com.ash.util.time.enums.TimeCycleTypeEnum;
import org.junit.jupiter.api.Test;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName HuToolUtilTest.java
 * @Description HuTool 开源工具的测试类
 * @createTime 2021年09月14日 16:46
 */
public class HuToolUtilTest {

    @Test
    public void enumUtilTest() {
        boolean days = EnumUtil.contains(TimeCycleTypeEnum.class, "DAYS");
        System.out.println(days);
    }

    @Test
    public void beanUtilTest() {


    }


}
