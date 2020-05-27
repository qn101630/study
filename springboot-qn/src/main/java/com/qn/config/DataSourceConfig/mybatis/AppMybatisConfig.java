package com.qn.config.DataSourceConfig.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootConfiguration
@MapperScan(basePackages = "com.qn.dao.app", sqlSessionTemplateRef = "sqlSessionTemplateApp")
public class AppMybatisConfig {

    @Autowired
    @Qualifier("appDataSource")
    private DruidDataSource appDataSource;

    @Bean
    SqlSessionFactory sqlSessionFactoryApp() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(appDataSource);
            sqlSessionFactory = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    @Bean
    SqlSessionTemplate sqlSessionTemplateApp() {
        return new SqlSessionTemplate(sqlSessionFactoryApp());
    }

    /**
     * 配置事务管理
     */
    @Bean
    DataSourceTransactionManager transactionManagerAppMybatis() {
        return new DataSourceTransactionManager(appDataSource);
    }

}
