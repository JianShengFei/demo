package com.ash.util.page.sort;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName OrderByMappingBean.java
 * @Description 排序字段映射测试Bean
 * @createTime 2021年06月02日 15:43
 */
@Data
public class OrderByMappingBean {

    @TableField("name")
    private String userName;

    @TableField("password")
    private String password;

    private LocalDateTime createDateTime;

    private LocalDateTime registerDateTime;

}
