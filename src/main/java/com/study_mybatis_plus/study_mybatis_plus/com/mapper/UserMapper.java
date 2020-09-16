package com.study_mybatis_plus.study_mybatis_plus.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study_mybatis_plus.study_mybatis_plus.com.api.entry.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther lby
 * @Date 2020/9/16
 * 使用mybatis-plus需要继承基础的basemapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
