package com.ash.util.time;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName DayOfMonth.java
 * @Description 月份中的号数定义类
 * @createTime 2021年09月13日 13:50
 */
public class DayOfMonth {

    /**
     * 月份中的号数
     */
    private int dateNumber;

    public int getDateNumber(){
        return this.dateNumber;
    }

    public static DayOfMonth now() {
        final LocalDate now = LocalDate.now();
        return of(now.getMonth(), now.getDayOfMonth());
    }

    public static DayOfMonth of(Clock clock) {
        // called once
        final LocalDate now = LocalDate.now(clock);
        return DayOfMonth.of(now.getMonth(), now.getDayOfMonth());
    }

    public static DayOfMonth of(int dayOfMonth) {
        final LocalDate now = LocalDate.now();
        return of(now.getMonth(), dayOfMonth);
    }

    public static DayOfMonth of(Month month, int dayOfMonth) {
        Objects.requireNonNull(month, "month");
        DAY_OF_MONTH.checkValidValue(dayOfMonth);
        if (dayOfMonth > month.maxLength()) {
            throw new DateTimeException("Illegal value for DayOfMonth field, value " + dayOfMonth +
                    " is not valid for month " + month.name());
        }
        return new DayOfMonth(dayOfMonth);
    }

    public static DayOfMonth of(int month, int dayOfMonth) {
        return of(Month.of(month), dayOfMonth);
    }

    private DayOfMonth(int dateNumber) {
        this.dateNumber = dateNumber;
    }

}
