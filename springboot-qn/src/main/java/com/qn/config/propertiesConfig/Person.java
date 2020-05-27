package com.qn.config.propertiesConfig;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类型安全配置
 *
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String lastName;
    @Max(150)
    private Integer age;
    private Date birth;
    private Map<String, String> maps;
    private List<String> lists;

    /**
     * 支持数据校验
     */
    @Email
    private String email;
}
