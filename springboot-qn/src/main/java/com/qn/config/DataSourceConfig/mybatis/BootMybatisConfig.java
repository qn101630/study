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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootConfiguration
@MapperScan(basePackages = {"com.qn.dao.boot", "com.qn.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplateBoot")
public class BootMybatisConfig {
    @Autowired
    @Qualifier("bootDataSource")
    private DruidDataSource bootDataSource;

    @Bean
    @Primary
    SqlSessionFactory sqlSessionFactoryBoot() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(bootDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
            sqlSessionFactory = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    @Bean
    @Primary
    SqlSessionTemplate sqlSessionTemplateBoot() {
        return new SqlSessionTemplate(sqlSessionFactoryBoot());
    }

    /**
     * 配置事务管理
     */
    @Bean
    @Primary
    DataSourceTransactionManager transactionManagerBootMybatis() {
        return new DataSourceTransactionManager(bootDataSource);
    }
}
