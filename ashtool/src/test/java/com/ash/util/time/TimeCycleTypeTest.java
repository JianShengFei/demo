package com.ash.util.time;

import com.ash.util.time.enums.TimeCycleTypeEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName TimeCycleTypeTest.java
 * @Description 周期时间测试
 * @createTime 2021年09月13日 15:08
 */
public class TimeCycleTypeTest {

    @Test
    public void test01() {
        LocalDate now = LocalDate.now();
        List<Integer> dateLists = new ArrayList<>();
        dateLists.add(2);
        dateLists.add(5);
        LocalDate nextDate = TimeUtil.getNextDate(now, dateLists, TimeCycleTypeEnum.DAYS);
        System.out.println(nextDate);

        LocalDate nextDate1 = TimeUtil.getNextDate(now, 15, TimeCycleTypeEnum.DAYS);
        System.out.println(nextDate1);
    }

    @Test
    public void test02() {
        LocalDate now = LocalDate.now();
        List<Integer> dateLists = new ArrayList<>();
        dateLists.add(2);
        dateLists.add(5);
        List<LocalDate> dates = TimeUtil.getPassageTimesByType(now, dateLists, TimeCycleTypeEnum.DAYS);
        dates.forEach(localDate -> System.out.println(localDate));

        System.out.println("---------------------------");

        LocalDate date = TimeUtil.getPassageTimesByType(LocalDate.now(), 12, TimeCycleTypeEnum.DAYS);
        System.out.println(date);
    }


}
