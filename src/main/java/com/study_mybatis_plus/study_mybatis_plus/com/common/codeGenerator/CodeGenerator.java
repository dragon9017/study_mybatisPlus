package com.study_mybatis_plus.study_mybatis_plus.com.common.codeGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther lby
 * @Date 2020/9/16
 * 封装代码自动生成工具类
 * 需要导入mybatis-plus,mybatis-plus-generator,
 */
@Slf4j
public class CodeGenerator {
    /**
     * 代码自动生成
     */
    public static void codeGen(){
        //        设置代码生成器
        AutoGenerator generator = new AutoGenerator();
//        配置代码生成内容




//        1. 全局配置
        GlobalConfig gc = new GlobalConfig();
//        存储路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
//        作者
        gc.setAuthor("lby");
//        是否开启资源管理器
        gc.setOpen(false);
//        取消覆盖
        gc.setFileOverride(false);
//        取消文件名称前缀
        gc.setServiceName("%sService");
//        是否开启API 注解
//        gc.setSwagger2(true);
        generator.setGlobalConfig(gc);





//        2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/cloud_test?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("password");
        dataSourceConfig.setDbType(DbType.MYSQL);
        generator.setDataSource(dataSourceConfig);






//        3. 设置包的配置
        PackageConfig pc = new PackageConfig();
//        模块名称
        pc.setModuleName("payment");
        pc.setParent("com.generator");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setController("controller");
        generator.setPackageInfo(pc);






//        4. 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        设置包名下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        设置映射的表名称
        strategy.setInclude("payment");
//        设置是否支持lombok
        strategy.setEntityLombokModel(true);
//        设置逻辑删除
        strategy.setLogicDeleteFieldName("delFlag");
//        设置controller 中的restController
        strategy.setRestControllerStyle(true);
        generator.setStrategy(strategy);






//        5. 设置xml文件生成，设置模板






//        6. 执行生成
        try {
            generator.execute();
            log.info("代码生成成功");
        } catch (Exception e) {
            log.info("代码生成失败");
            e.printStackTrace();
        }
    }

}
