package com.study_mybatis_plus.study_mybatis_plus.com.api.entry;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Auther lby
 * @Date 2020/9/16
 */
@Data
public class User {
//    雪花算法，唯一
    @TableId
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;
    private Date updateTime;

}
