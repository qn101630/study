package com.qn.config.propertiesConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 引入配置文件
 */
/*@Data
@Component
@Validated
@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(value = "person")*/
public class PersonSource {
    private String lastName;
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
