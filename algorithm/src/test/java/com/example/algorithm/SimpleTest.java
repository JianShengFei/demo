package com.example.algorithm;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName SimpleTest.java
 * @Description 简单 写法 测试
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
            sort -= 10;
            bean.setNum(sort);
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
        return date.plusDays(day);
    }


    @Test
    public void test4(){
        LocalDate localDate = LocalDate.of(2021, 2, 33);
        LocalDate newLocalDate = byWeek(localDate, 5);
        System.out.println(newLocalDate);
    }


    /**
     * stream 流 差集计算
     */
    @Test
    public void test05(){
        List<Integer> asdasd = new ArrayList<>();

        asdasd.add(3);
        asdasd.add(4);
        asdasd.add(6);
        asdasd.add(7);

        List<Integer> newas = new ArrayList<>();
        newas.add(3);

        List<Integer> collect = asdasd.stream().filter(integer -> !newas.contains(integer)).collect(Collectors.toList());

        System.out.println(collect);

        System.out.println(asdasd.size() >> 1);

    }


    /**
     * 获取操作系统测试
     */
    @Test
    public void test06(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString(); //获取本机ip
            String hostName = addr.getHostName().toString(); //获取本机计算机名称
            System.out.println("本机IP：" + ip + "\n本机名称:" + hostName);
            Properties props = System.getProperties();
            System.out.println("操作系统的名称：" + props.getProperty("os.name"));
            System.out.println("操作系统的版本：" + props.getProperty("os.version"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 时间测试
     */
    @Test
    public void test07(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date now = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 5, 24, 18, 30, 00);
        Date startTime = calendar.getTime();

        calendar.set(2021, 5, 24, 20, 30, 00);
        Date endTime = calendar.getTime();
        System.out.println(format.format(now));
        System.out.println(format.format(startTime));
        System.out.println(format.format(endTime));

        System.out.println("----------------------------------");

        System.out.println(now.after(startTime));
        System.out.println(now.before(endTime));
        System.out.println(now.after(startTime) && now.before(endTime));
    }

    /**
     * 随机数
     */
    @Test
    public void test08(){
        Random rd = new Random();
        System.out.println(rd.nextInt(100));

    }

}
