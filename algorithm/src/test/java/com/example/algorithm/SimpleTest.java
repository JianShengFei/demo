package com.example.algorithm;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName SimpleTest.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年06月16日 11:08
 */
public class SimpleTest {

    @Test
    public void test(){

        List<SortBean> list = new ArrayList<>();

        SortBean sortBean1 = new SortBean();
        sortBean1.setNum(19L);
        list.add(sortBean1);

        SortBean sortBean2 = new SortBean();
        sortBean2.setNum(5L);
        list.add(sortBean2);

        SortBean sortBean3 = new SortBean();
        sortBean3.setNum(4L);
        list.add(sortBean3);

        SortBean sortBean4 = new SortBean();
        sortBean4.setNum(3L);
        list.add(sortBean4);

        SortBean sortBean5 = new SortBean();
        list.add(sortBean5);

        SortBean sortBean6 = new SortBean();
        list.add(sortBean6);

        SortBean sortBean7 = new SortBean();
        list.add(sortBean7);


        SortBean sortBean = new SortBean();
        sortBean.setNum(19L);

        System.out.println(list);

        Long sort = 1L;


        List<SortBean> nullList = list.stream().filter(bean -> bean.getNum() == null).collect(Collectors.toList());

        System.out.println(nullList);

        System.out.println("-------------------------------------------");

        for (SortBean bean : nullList) {
            bean.setNum(--sort);
        }

        System.out.println(nullList);


    }

    @Data
    private class SortBean{
        private Long num;
    }

    @Test
    public void test2(){
        String days = "13,16";


        LocalDateTime now = LocalDateTime.now();
        LocalDate node1 = now.toLocalDate();

        System.out.println(node1.getDayOfMonth());
        String[] split = days.split(",");

        int day = node1.getDayOfMonth();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(Integer.valueOf(s).equals(node1.getDayOfMonth())) {
                System.out.println("找到一样的日期了");
                if(i == split.length - 1) {
                    day = Integer.valueOf(split[0]);
                    node1 = node1.plusMonths(1L);
                    break;
                }else {
                    day = Integer.valueOf(split[i + 1]);
                }
                break;
            }
        }

        LocalDate node2 = LocalDate.of(node1.getYear(), node1.getMonth(), day);
        Period period = Period.between(node1, node2);

        System.out.println(node1);
        System.out.println(node2);

    }


    @Test
    public void test3(){
        String days = "5,3";


        LocalDateTime now = LocalDateTime.now();
        LocalDate node1 = now.toLocalDate();

        String[] split = days.split(",");

        int day = node1.getDayOfMonth();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(Integer.valueOf(s).equals(node1.getDayOfWeek().getValue())) {
                System.out.println("找到一样的日期了");
                if(i == split.length - 1) {
                    day = Integer.valueOf(split[0]);
                }else {
                    day = Integer.valueOf(split[i + 1]);
                }
                break;
            }
        }

        LocalDate localDate = byWeek(node1, day);



        System.out.println(node1);
        System.out.println(localDate);

    }

    public static LocalDate byWeek(LocalDate date, int dictionaryWeek) {

        if(date == null) {
            date = LocalDate.now();
        }

        int day = 0;
        int value = date.getDayOfWeek().getValue();
        if (dictionaryWeek == value) {
            day = 7;
        }
        if (value < dictionaryWeek) {
            day = dictionaryWeek - value;
        }
        if (value > dictionaryWeek) {
            day = 7 - (value - dictionaryWeek);
        }
        return LocalDate.now().plusDays(day);
    }


    @Test
    public void test4(){


    }



}
