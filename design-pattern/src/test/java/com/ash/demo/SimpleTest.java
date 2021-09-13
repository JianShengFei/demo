//package com.ash.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author jianshengfei
// * @version 1.0.0
// * @ClassName Test.java
// * @createTime 2021年03月30日 13:47
// * @Description 简单的实例测试demo
// */
//@Slf4j
//public class SimpleTest {
//
//    @Test
//    public void StringBuilderTest(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(",见,中间,中国");
//        String substring = stringBuilder.substring(1);
//        System.out.println(substring);
//    }
//
//    @Test
//    public void java8StreamForEachTest(){
//        List<String> strings = new ArrayList<>();
//        strings.add("天下第一");
//        strings.add("武林至尊");
//        strings.add("葵花宝典");
//
//        strings.stream().forEach(s -> {
//
//            System.out.println(s);
//        });
//    }
//
//    @Test
//    public void copyList(){
//        CopyTestSourceBean copyTestSourceBean = new CopyTestSourceBean();
//        copyTestSourceBean.setName("简圣飞");
//        System.out.println("copy前bean：" + JSONUtil.toJsonStr(copyTestSourceBean));
//
//        CopyTestTargetBean copyTestTargetBean = new CopyTestTargetBean();
//
//        copyTestTargetBean.setId(2);
//        copyTestTargetBean.setName("简易枫");
//        copyTestTargetBean.setSex(true);
//        System.out.println("copy前bean：" + JSONUtil.toJsonStr(copyTestTargetBean));
//
//        List<CopyTestSourceBean> copyTestSourceBeans = new ArrayList<>();
//        copyTestSourceBeans.add(copyTestSourceBean);
//
//        List<CopyTestTargetBean> copyTestTargetBeans = new ArrayList<>();
//        System.out.println(JSONUtil.toJsonStr(copyTestTargetBeans));
//        System.out.println(JSONUtil.toJsonStr(copyTestSourceBean));
//
//        BeanUtil.copyProperties(copyTestSourceBean, copyTestTargetBean);
//
//        System.out.println(JSONUtil.toJsonStr(copyTestTargetBeans));
//        System.out.println(JSONUtil.toJsonStr(copyTestSourceBean));
//
//
//    }
//
//    /**
//     * hutool 对象克隆工具使用demo
//     */
//    @Test
//    public void copyProperties(){
//
//        CopyTestSourceBean copyTestSourceBean = new CopyTestSourceBean();
//        copyTestSourceBean.setName("简圣飞");
//        System.out.println("copy前bean：" + JSONUtil.toJsonStr(copyTestSourceBean));
//        CopyTestTargetBean copyTestTargetBean = new CopyTestTargetBean();
//
//        copyTestTargetBean.setId(2);
//        copyTestTargetBean.setName("简易枫");
//        copyTestTargetBean.setSex(true);
//        System.out.println("copy前bean：" + JSONUtil.toJsonStr(copyTestTargetBean));
//
//        // 忽略null复制
//        BeanUtil.copyProperties(copyTestSourceBean, copyTestTargetBean, new CopyOptions().setIgnoreNullValue(true));
//
//        // 知识点：断言，isNull 当object不为空时，抛出异常
//        //Assert.isNull(copyTestSourceBean, "not null");
//
//        System.out.println("copy后bean：" + JSONUtil.toJsonStr(copyTestSourceBean));
//        System.out.println("copy后bean：" + JSONUtil.toJsonStr(copyTestTargetBean));
//    }
//
//    @Data
//    public class CopyTestSourceBean{
//        private Integer id;
//        private String name;
//        private Boolean sex;
//    }
//
//    @Data
//    public class CopyTestTargetBean{
//        private Integer id;
//        private String name;
//        private Boolean sex;
//    }
//
//
//
//
//}
