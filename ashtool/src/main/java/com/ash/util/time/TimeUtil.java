package com.ash.util.time;

import cn.hutool.core.collection.CollectionUtil;
import com.ash.util.time.enums.TimeCycleTypeEnum;
import com.ash.util.time.temporal.AdditiveTemporalAdjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName TimeUtil.java
 * @Description 时间处理工具类
 * @createTime 2021年09月13日 13:58
 */
public class TimeUtil {

    private TimeUtil() {}

    /**
     * 基于时间推移方法，得出下一个时间点最近的时间
     * <p>
     *     使用场景：在定义了多个时间点中，查询一个最近的节点，如从每月 3, 6, 9, 15 日集合中，获取离对比时间对象 最近的下一个时间节点
     *     例：
     *     时间集合 {3, 6, 9, 15} 单位日, 当前对比时间：2021年9月13日 最近的下一个时间节点 返回 15 日
     * </p>
     * @param localDate 对比时间对象
     * @param dateNums 需要计算推移的时间集合
     * @param cycleTimeEnum 推移时间集合类型 可以直接理解为时间单位
     * @return
     */
    public static LocalDate getNextDate(LocalDate localDate, List<Integer> dateNums, TimeCycleTypeEnum cycleTimeEnum) {

        if(CollectionUtil.isEmpty(dateNums)) {
            return null;
        }

        if(localDate == null) {
            localDate = LocalDate.now();
        }

        List<LocalDate> localDates = getPassageTimesByType(localDate, dateNums, cycleTimeEnum);

        Map<Integer, LocalDate> resultMap = new HashMap<>(localDates.size());
        for (LocalDate date : localDates) {
            long between = ChronoUnit.DAYS.between(localDate, date);
            resultMap.put((int) between, date);
        }

        Integer min = Collections.min(resultMap.keySet());
        return resultMap.get(min);
    }


    /**
     * 单个推移时间参数
     * @param localDate 对比时间对象
     * @param dateNum 需要计算推移的时间集合
     * @param cycleTimeEnum 推移时间集合类型 可以直接理解为时间单位
     * @return
     */
    public static LocalDate getNextDate(LocalDate localDate, Integer dateNum, TimeCycleTypeEnum cycleTimeEnum) {
        return getNextDate(localDate, new ArrayList<>(Arrays.asList(dateNum)), cycleTimeEnum);
    }

    /**
     * 根据 cycleTimeEnum 类型将 localDate 推荐 dateNums 并返回集合
     * <p>
     *     应用场景:
     *     需要计算某个时间下一个出现的时间节点
     *     例：2021年9月13日 开始计算下一个时间节点{10, 16} 类型为DAYS 日, 则返回 {2021年10月10日, 2021年9月16日}
     * </p>
     *
     * @param localDate 对比时间对象
     * @param dateNums 需要计算推移的时间点集合  {10, 16} 代表的是 10日 如 10月10日   此参数会进行一次去重, 避免多次无用的计算
     * @param cycleTimeEnum 推移时间集合类型  可以直接理解为时间单位
     * @return
     */
    public static List<LocalDate> getPassageTimesByType(LocalDate localDate, List<Integer> dateNums, TimeCycleTypeEnum cycleTimeEnum) {

        if(CollectionUtil.isEmpty(dateNums)) {
            throw new NullPointerException("Collection cannot be empty");
        }

        if(cycleTimeEnum == null) {
            throw new NullPointerException("enum cannot be null");
        }

        if(localDate == null) {
            localDate = LocalDate.now();
        }

        // 对传入的推移时间进行去重
        dateNums = dateNums.stream().distinct().collect(Collectors.toList());

        List<LocalDate> localDates = new ArrayList<>();
        for (Integer dateNum : dateNums) {
            localDates.add(plusDateByType(localDate, dateNum, cycleTimeEnum));
        }
        return localDates;
    }

    /**
     * 推移时间
     * @param localDate
     * @param dateNum
     * @param cycleTimeEnum
     * @return
     */
    private static LocalDate plusDateByType(LocalDate localDate, Integer dateNum, TimeCycleTypeEnum cycleTimeEnum) {
        if(cycleTimeEnum.equals(TimeCycleTypeEnum.DAYS)) {
            return localDate.with(AdditiveTemporalAdjusters.nextDayOfMonth(DayOfMonth.of(dateNum)));
        }else if(cycleTimeEnum.equals(TimeCycleTypeEnum.WEEKS)) {
            return localDate.with(TemporalAdjusters.next(DayOfWeek.of(dateNum)));
        }else if(cycleTimeEnum.equals(TimeCycleTypeEnum.MONTHS)) {
            return localDate.with(AdditiveTemporalAdjusters.nextMonthOfYear(Month.of(dateNum)));
        }
        return null;
    }

    /**
     * 单个推移时间参数
     * @param localDate 对比时间对象
     * @param dateNum 需要计算推移的时间集合
     * @param cycleTimeEnum 推移时间集合类型  可以直接理解为时间单位
     * @return
     */
    public static LocalDate getPassageTimesByType(LocalDate localDate, Integer dateNum, TimeCycleTypeEnum cycleTimeEnum) {
        return getPassageTimesByType(localDate, new ArrayList<>(Arrays.asList(dateNum)), cycleTimeEnum).get(0);
    }


}
