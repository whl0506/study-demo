package com.test.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 常量类，读取配置文件application.yml中的配置
 */
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${endpoint}")
    private String endpoint;

    @Value("${keyid}")
    private String keyId;

    @Value("${keysecret}")
    private String keySecret;

    @Value("${bucketname}")
    private String bucketName;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;


    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
