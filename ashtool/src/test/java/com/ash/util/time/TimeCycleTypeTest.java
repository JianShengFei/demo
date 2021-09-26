package com.ash.util.time;

import com.ash.util.time.enums.TimeCycleTypeEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName TimeCycleTypeTest.java
 * @Description 周期时间测试
 * @createTime 2021年09月13日 15:08
 */
public class TimeCycleTypeTest {

    /**
     * 对 日 类型下一次出现时间的测试
     */
    @Test
    public void textNextDayTime() {
        LocalDate date = LocalDate.now();
        List<Integer> dateLists = new ArrayList<>();
        dateLists.add(2);
        dateLists.add(5);
        LocalDate nextDate1 = TimeUtil.getNextDate(date, dateLists, TimeCycleTypeEnum.DAYS);
        System.out.println(nextDate1);

        LocalDate nextDate2 = TimeUtil.getNextDate(date, 15, TimeCycleTypeEnum.DAYS);
        System.out.println(nextDate2);
    }

    /**
     * 对 周 类型下一次出现时间的测试
     */
    @Test
    public void testNextWeekTime() {
        LocalDate date = LocalDate.now();
        List<Integer> dateLists = new ArrayList<>();
        dateLists.add(3);
        dateLists.add(5);
        LocalDate nextDate1 = TimeUtil.getNextDate(date, dateLists, TimeCycleTypeEnum.WEEKS);
        System.out.println(nextDate1);

        LocalDate nextDate2 = TimeUtil.getNextDate(date, 4, TimeCycleTypeEnum.WEEKS);
        System.out.println(nextDate2);
    }

    /**
     * 对 月 类型下一次出现时间的测试
     */
    @Test
    public void testNextMonthTime() {
        LocalDate date = LocalDate.now();
        List<Integer> dateLists = new ArrayList<>();
        dateLists.add(2);
        dateLists.add(11);
        LocalDate nextDate1 = TimeUtil.getNextDate(date, dateLists, TimeCycleTypeEnum.MONTHS);
        System.out.println(nextDate1);

        LocalDate nextDate2 = TimeUtil.getNextDate(date, 12, TimeCycleTypeEnum.MONTHS);
        System.out.println(nextDate2);
    }




}
