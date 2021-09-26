package com.ash.util.time.temporal;


import com.ash.util.time.DayOfMonth;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

/**
 * <p>
 * 基于 jdk1.8 的调整器, 实现的额外的功能方法扩展
 * </p>
 * Common and useful TemporalAdjusters.
 * <p>
 * Adjusters are a key tool for modifying temporal objects.
 * They exist to externalize the process of adjustment, permitting different
 * approaches, as per the strategy design pattern.
 * Examples might be an adjuster that sets the date avoiding weekends, or one that
 * sets the date to the last day of the month.
 * <p>
 * There are two equivalent ways of using a {@code TemporalAdjuster}.
 * The first is to invoke the method on the interface directly.
 * The second is to use {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisAdjuster.adjustInto(temporal);
 *   temporal = temporal.with(thisAdjuster);
 * </pre>
 * It is recommended to use the second approach, {@code with(TemporalAdjuster)},
 * as it is a lot clearer to read in code.
 * <p>
 * This class contains a standard set of adjusters, available as static methods.
 * These include:
 * <ul>
 * <li>finding the first or last day of the month
 * <li>finding the first day of next month
 * <li>finding the first or last day of the year
 * <li>finding the first day of next year
 * <li>finding the first or last day-of-week within a month, such as "first Wednesday in June"
 * <li>finding the next or previous day-of-week, such as "next Thursday"
 * </ul>
 *
 * @author Ash Jan
 * @implSpec
 * All the implementations supplied by the static methods are immutable.
 *
 * @see java.time.temporal.TemporalAdjuster
 * @since 1.8
 */
public class AdditiveTemporalAdjusters {

    /**
     * 获取下一次某个号数出现的时间调整器
     *
     * 如： 假设当前日期为  2021年9月15日  下次出现的日  17  是否往前查找为 false  返回的日期则为：2021年9月17日
*                                                     是否往前查找为 true   返回的日期则为：2021年8月17日
     *
     * @param dayOfMonth 下次出现得号数 即日
     * @param isPrev 是否往前面查找
     * @return
     */
    public static TemporalAdjuster nextDayOfMonth(DayOfMonth dayOfMonth, boolean isPrev) {
        return (temporal) -> {
            int calDow = temporal.get(DAY_OF_MONTH);
            int daysDiff = calDow - dayOfMonth.getDateNumber();
            if(isPrev) {
                return daysDiff == 0 ?
                        temporal.plus(-1, MONTHS) :
                        temporal.plus(daysDiff > 0 ?
                                -daysDiff : -(LocalDate.now().plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth() - dayOfMonth.getDateNumber() + calDow), DAYS);
            }
            return daysDiff == 0 ?
                    temporal.plus(1, MONTHS) :
                    temporal.plus(daysDiff > 0 ? LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth() - calDow + dayOfMonth.getDateNumber() : -daysDiff, DAYS);
        };
    }

    /**
     * 获取下一个某个号数出现的时间调整器
     * @param dayOfMonth
     * @return
     */
    public static TemporalAdjuster nextDayOfMonth(DayOfMonth dayOfMonth) {
        return nextDayOfMonth(dayOfMonth, false);
    }

    public static TemporalAdjuster nextDayOfMonth(int dayOfMonth, boolean isPrev) {
        return nextDayOfMonth(DayOfMonth.of(dayOfMonth), isPrev);
    }

    public static TemporalAdjuster nextDayOfMonth(int dayOfMonth) {
        return nextDayOfMonth(DayOfMonth.of(dayOfMonth), false);
    }

    /**
     * 获取下一个某个月出现的时间调整器
     *
     * 如：当前日期为：2021年9月15日  下次出现月份为 10月 是否往前查找为 false  返回的日期则为：2021年10月15日
     *                                             是否往前查找为 true   返回的日期则为：2020年9月15日
     *
     * @param month 下次出现的月份
     * @param isPrev 是否往前查找
     * @return
     */
    public static TemporalAdjuster nextMonthOfYear(Month month, boolean isPrev) {
        return (temporal -> {
            int calDow = temporal.get(MONTH_OF_YEAR);
            int monthsDiff = calDow - month.getValue();
            if(isPrev) {
                return temporal.plus(monthsDiff >= 0 ? -monthsDiff : -(12 - month.getValue() + calDow), MONTHS);
            }
            return temporal.plus(monthsDiff >= 0 ? 12 - monthsDiff : -monthsDiff, MONTHS);
        });
    }

    public static TemporalAdjuster nextMonthOfYear(Month month) {
        return nextMonthOfYear(month, false);
    }

    public static TemporalAdjuster nextMonthOfYear(int month, boolean isPrev) {
        return nextMonthOfYear(Month.of(month), isPrev);
    }

    public static TemporalAdjuster nextMonthOfYear(int month) {
        return nextMonthOfYear(Month.of(month), false);
    }

}
