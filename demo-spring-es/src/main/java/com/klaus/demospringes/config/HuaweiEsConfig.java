package com.klaus.demospringes.config;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.config MyConfig
 * @description:
 * @date 2019/3/24 19:56
 */


@Component
@ConfigurationProperties(prefix="huawei.es")
@ToString
@Data
@Slf4j
public class HuaweiEsConfig {


    private Boolean isSecureMode;
    private String esServerHosts;
    private int maxRetryTimeoutMillis;
    private String index;
    private String type;
    private int id;
    private int shardNum;
    private int connectTimeout;
    private int socketTimeout;
    private String schema;

    private String krb5ConfFilePath;
    private String jaasConfFilePath;
    private String userKeyFilePath;







}


