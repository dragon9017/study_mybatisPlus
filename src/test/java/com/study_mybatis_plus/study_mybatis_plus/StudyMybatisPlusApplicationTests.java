package com.study_mybatis_plus.study_mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.study_mybatis_plus.study_mybatis_plus.com.api.entry.User;
import com.study_mybatis_plus.study_mybatis_plus.com.common.codeGenerator.CodeGenerator;
import com.study_mybatis_plus.study_mybatis_plus.com.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
@Slf4j
class StudyMybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    /**
     * 测试mybatis-plus
     */
    @Test
    void test01(){
//        此处需要传入wrapper参数，作为查询的条件
        List<User> users = userMapper.selectList(null);
        for (User user:users) {
            log.info("数据"+user);
        }
    }
    @Test
    void test02(){
        User user=new User();
        user.setId(1);
        user.setName("瓜皮");
        user.setAge(11);
        userMapper.updateById(user);
    }
    @Test
    void test03(){
//        第一页，5条数据
        Page<User> objectPage = new Page<>(1,5);
        Page<User> userPage = userMapper.selectPage(objectPage, null);
        log.info("分页数据"+userPage.getRecords());
    }

    /**
     * MP 条件构造器测试
     */
    @Test
    void test04(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        QueryWrapper<User> ge = wrapper
                .isNotNull("name")
                .isNotNull("id")
                .ge("age", 10);
        IPage<User> IPage = new Page<>(1,5);
        List<User> records = userMapper.selectPage(IPage, ge).getRecords();
        for (User user:records) {
            log.info("数据"+user);
        }
    }
    @Test
    void test05(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Date beginTime=new Date();
        Date endTime=new Date();
        wrapper
                .eq("name","瓜皮")
                .between("create_time",beginTime,endTime);
        List<User> list = userMapper.selectList(wrapper);
        for (User user:list) {
            log.info("message"+user);
        }
    }
    @Test
    void test06(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","皮");
        List<User> users = userMapper.selectList(wrapper);
        for (User user: users) {
            log.info("message"+user);
        }
    }

    /**
     * 代码自动生成测试
     */
    @Test
    void test07(){
        CodeGenerator.codeGen();

    }

}
