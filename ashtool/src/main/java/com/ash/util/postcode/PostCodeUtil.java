package com.ash.util.postcode;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @Description 根据地址获取邮编号码
 * @ClassName PostCodeUtil.java
 * @createTime 2021年04月21日 09:29
 */
@Slf4j
public class PostCodeUtil {

    private static final String URL_PREFIX = "http://cpdc.chinapost.com.cn/web/index.php?m=postsearch&c=index&a=ajax_addr&searchkey=";

    /**
     * 通过地址获取邮编信息
     * @param addr -> 地址
     * @return postcode -> 邮编
     */
    public static String getPostCodeByAddr(String addr) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URL_PREFIX + addr, String.class);
        JSONObject jsonResp = JSONUtil.parseObj(response);
        return Optional.ofNullable(jsonResp)
                .map(jsonObject -> jsonObject.getJSONArray("rs"))
                .filter(jsonArray -> jsonArray.size() > 0)
                // 地址不精确导致找到多个默认取第一个
                .map(jsonArray -> jsonArray.getJSONObject(0))
                .map(jsonObject -> jsonObject.get("POSTCODE")).orElse(StringUtils.EMPTY).toString();
    }

    public static void main(String[] args) {

        //510640
        System.out.println(getPostCodeByAddr("广东省广州市天河区"));
        //System.out.println(getPostCodeByAddr("安徽省安庆市宿松县孚玉镇"));

        String a = getPostCodeByAddr("湖南省常德市");
        System.out.println(a);
    }

}