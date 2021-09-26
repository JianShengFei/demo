//package com.ash.demo.proxy;
//
//import com.ash.demo.proxy.dynamicproxy.Buy;
//import com.ash.demo.proxy.dynamicproxy.jdkproxy.JdkDynamicProxy;
//import com.ash.demo.proxy.staticproxy.Proxy;
//import com.ash.demo.proxy.staticproxy.User;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * @author Ash Jan
// * @version 1.0.0
// * @ClassName ProxyPatternTest.java
// * @Description 代理模式测试类
// * @createTime 2021年03月08日 17:14:00
// */
//public class ProxyPatternTest {
//
//    /**
//     * 常规代理模式写法 测试, 其实就是静态代理模式
//     */
//    @Test
//    void test(){
//        com.ash.demo.proxy.general.Proxy proxy = new com.ash.demo.proxy.general.Proxy(new com.ash.demo.proxy.general.RealSubject());
//        proxy.request();
//    }
//
//    /**
//     * 静态代理测试
//     */
//    @Test
//    void test01(){
//        User user = new User();
//        Proxy proxy = new Proxy(user);
//        proxy.buyMac();
//    }
//
//    /**
//     * 动态代理测试
//     */
//    @Test
//    void test02(){
//        JdkDynamicProxy proxy = new JdkDynamicProxy();
//        Buy buy = proxy.getInstance(new com.ash.demo.proxy.dynamicproxy.User());
//        buy.buyMac();
//    }
//
//
//    @Data
//    private class Bean {
//        private Integer id;
//        private String name;
//        private Integer preNodeId;
//        private String nextNodeIds;
//    }
//
//    private static volatile List<Bean> list = new ArrayList<>();
//
//    @Test
//    void test03(){
//
//        // 初始化构建权限树
//        List<Bean> list = builderBeanList();
//        for (Bean bean : list) {
//            System.out.println(bean);
//        }
//        System.out.println("------------------------------------------------------------");
//        // 将6节点更新到1节点下
//        updateNodeTree(4, 6);
//
//        System.out.println("------------------------------------------------------------");
//
//    }
//
//    /**
//     * 更新节点结构
//     * @param id 被更新Node 的 id
//     * @param preId 更新为 preId 的子Node
//     */
//    private void updateNodeTree(Integer id, Integer preId) {
//        if(id == null) {
//            log.info("更新失败");
//            return;
//        }
//
//        Bean bean = getBeanFromListById(id);
//        // 更新前 的子节点 前缀
//        String updateBeforePrefix = getBeanFromListById(bean.getPreNodeId()).getNextNodeIds();
//        // 更新后 的子节点 前缀
//        String updateAfterPrefix = getBeanFromListById(preId).getNextNodeIds();
//
//        // 先更新子节点
//        // 获取当前节点的子节点集合
//        List<Bean> beans = getBeanListByPreId(id);
//        if (CollectionUtil.isNotEmpty(beans)) {
//            for (Bean bean1 : beans) {
//                bean1.setNextNodeIds(bean1.getNextNodeIds().replace(updateBeforePrefix, updateAfterPrefix));
//            }
//        }
//        // 更新当前节点
//        bean.setPreNodeId(preId);
//        bean.setNextNodeIds(bean.getNextNodeIds().replace(updateBeforePrefix, updateAfterPrefix));
//
//        for (Bean bean1 : list) {
//            System.out.println(bean1);
//        }
//    }
//
//    private List<Bean> getBeanListByPreId(Integer id){
//        // copy 一个新增集合, 不改变源数据
//        List<Bean> result = new ArrayList<>();
//        result.addAll(list);
//
//        Bean bean = getBeanFromListById(id);
//
//        Iterator<Bean> iterator = result.iterator();
//        while (iterator.hasNext()) {
//            Bean s = iterator.next();
//            if (!s.getNextNodeIds().contains(bean.getNextNodeIds())) {
//                iterator.remove();
//            }
//        }
//        return result;
//    }
//
//    private Bean getBeanFromListById(Integer id) {
//        if(CollectionUtil.isEmpty(list) || id == null){
//            return null;
//        }
//        for (Bean bean : list) {
//            if(bean.getId().equals(id)) {
//                return bean;
//            }
//        }
//        return null;
//    }
//
//    private List<Bean> builderBeanList(){
//        // 定义三级权限树
//        Bean bean1 = new Bean();
//        bean1.setId(1);
//        bean1.setName("简圣飞");
//        bean1.setPreNodeId(null);
//        bean1.setNextNodeIds("#.1");
//
//        Bean bean2 = new Bean();
//        bean2.setId(2);
//        bean2.setName("王斌");
//        bean2.setPreNodeId(1);
//        bean2.setNextNodeIds("#.1.2");
//
//        Bean bean3 = new Bean();
//        bean3.setId(3);
//        bean3.setName("等疑问");
//        bean3.setPreNodeId(1);
//        bean3.setNextNodeIds("#.1.3");
//
//        Bean bean4 = new Bean();
//        bean4.setId(4);
//        bean4.setName("正辉");
//        bean4.setPreNodeId(2);
//        bean4.setNextNodeIds("#.1.2.4");
//
//        Bean bean5 = new Bean();
//        bean5.setId(5);
//        bean5.setName("谢文文");
//        bean5.setPreNodeId(null);
//        bean5.setNextNodeIds("#.5");
//
//        Bean bean6 = new Bean();
//        bean6.setId(6);
//        bean6.setName("玉婷");
//        bean6.setPreNodeId(5);
//        bean6.setNextNodeIds("#.5.6");
//
//        Bean bean7 = new Bean();
//        bean7.setId(7);
//        bean7.setName("春燕");
//        bean7.setPreNodeId(6);
//        bean7.setNextNodeIds("#.5.6.7");
//
//        Bean bean8 = new Bean();
//        bean8.setId(8);
//        bean8.setName("马云");
//        bean8.setPreNodeId(4);
//        bean8.setNextNodeIds("#.1.2.4.8");
//
//        Bean bean9 = new Bean();
//        bean9.setId(9);
//        bean9.setName("尼古拉斯");
//        bean9.setPreNodeId(8);
//        bean9.setNextNodeIds("#.1.2.4.8.9");
//
//        list.add(bean1);
//        list.add(bean2);
//        list.add(bean3);
//        list.add(bean4);
//        list.add(bean5);
//        list.add(bean6);
//        list.add(bean7);
//        list.add(bean8);
//        list.add(bean9);
//        return list;
//    }
//
//}
