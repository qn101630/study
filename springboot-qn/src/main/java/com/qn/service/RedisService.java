package com.qn.service;

import com.qn.eneity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String,String> strRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    public String getValue(String key,String value){
        strRedisTemplate.opsForValue().set(key,value);
        return strRedisTemplate.opsForValue().get(key);
    }

    public UserEntity testSerializable() {
        UserEntity user=new UserEntity();
        user.setId(1L);
        user.setUserName("朝雾轻寒");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user", user);
        return (UserEntity) serializableRedisTemplate.opsForValue().get("user");
    }
}
