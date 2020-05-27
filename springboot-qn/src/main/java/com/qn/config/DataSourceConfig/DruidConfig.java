package com.qn.config.DataSourceConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源的配置
 */
@SpringBootConfiguration
public class DruidConfig {
    /**
     * 配置绑定boot
     *
     * @return
     */

    @Bean(name ="bootDataSource")
    @Primary //主数据源
    @Qualifier("bootDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.boot")
    public DruidDataSource bootDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置绑定app
     *
     * @return
     */
    @Bean(name ="appDataSource")
    @Qualifier("appDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.app")
    public DruidDataSource appDataSource() {
        return new DruidDataSource();
    }

    /**
     * Druid的servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123");
        bean.setInitParameters(initParams);
        bean.setUrlMappings(Arrays.asList("/druid/*"));
        return bean;
    }

    /**
     * Druid的filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "/css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
