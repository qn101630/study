package com.qn.config.propertiesConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 读取配置文件@value
 */
@Data
@Component
@Validated
@Profile("dev")
public class PersonValue {

    /**
     * 直接从配置文件读取一个值
     */
    @Value("${person.last-name}")
    private String lastName;

    /**
     * 支持SpEL表达式
     */
    @Value("#{11*4/2}")
    private Integer age;

    @Value("${person.birth}")
    private Date birth;

    /**
     * 不支持复杂类型
     */
    private Map<String, String> maps;
    private List<String> lists;

    /**
     * 不支持数据校验
     */
    @Email
    @Value("xxx@@@@")
    private String email;
}
