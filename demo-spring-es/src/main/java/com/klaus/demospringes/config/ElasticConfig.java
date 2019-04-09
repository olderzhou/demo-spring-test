package com.klaus.demospringes.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.config ElasticConfig
 * @description:
 * @date 2019/3/25 09:48
 */



@Configuration
@Slf4j
public class ElasticConfig {

    @Autowired
    private ElasticsearchProperties properties;

    @Autowired
    private HuaweiEsConfig huaweiEsConfig;

    @Bean
    @Profile({"local","uat","test"})
    public TransportClient elasticsearchClient() throws Exception {
        log.info("huawei es config is :{}", huaweiEsConfig);

        log.info("\n************************\nNormal TransportClient init at :{} \n******************************", System.currentTimeMillis());
        return getTransportClientFactoryBean().getObject();
    }




    @Bean
    @Profile({"huawei"})
    public RestClient elasticsearchHuaweiClient() throws Exception {
        log.info("\n************************\nHuawei RestClient init at :{} \n******************************", System.currentTimeMillis());
        log.info("huawei es mode is :{}", huaweiEsConfig.getIsSecureMode());

        RestClientBuilder builder = null;
        RestClient restClient = null;
        String hosts = huaweiEsConfig.getEsServerHosts();
        String[] hs = hosts.split(",");
        HttpHost[] httpHosts = Arrays.stream(hs).map(i -> {
            String[] ipPort = i.split(":");
            return new HttpHost(ipPort[0],Integer.valueOf(ipPort[1]), huaweiEsConfig.getSchema());
        }).toArray(HttpHost[] :: new);

        if(huaweiEsConfig.getIsSecureMode()){
            //进行Kerberos认证
            File krb5ConfFile = ResourceUtils.getFile("resources/krb5.conf");
            System.setProperty("java.security.krb5.conf", krb5ConfFile.getPath());
            File jaasPath = ResourceUtils.getFile("resources/jaas.conf");
            System.setProperty("java.security.auth.login.config", jaasPath.getPath());
            System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
            System.setProperty("javax.security.indication", "true");

            log.info("java.security.krb5.conf is :{}\n" +
                            "java.security.auth.login.config is:{}\n" +
                            "javax.security.auth.useSubjectCredsOnly is:{}\n" +
                            "javax.security.indication is:{}\n",
                    krb5ConfFile.getPath(),jaasPath.getPath(), "false", "true");
            builder = RestClient.builder(httpHosts);
        }else{
            builder = RestClient.builder(httpHosts);
        }
        Header[] defaultHeaders = new Header[] { new BasicHeader("Accept", "application/json"),
                new BasicHeader("Content-type", "application/json") };
        builder = builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                return requestConfigBuilder.setConnectTimeout(huaweiEsConfig.getConnectTimeout()).setSocketTimeout(huaweiEsConfig.getSocketTimeout());
            }
        }).setMaxRetryTimeoutMillis(huaweiEsConfig.getMaxRetryTimeoutMillis());
        builder.setDefaultHeaders(defaultHeaders);
        restClient = builder.build();
        return restClient;


    }

    public TransportClientFactoryBean getTransportClientFactoryBean() throws Exception {
        TransportClientFactoryBean factory = new TransportClientFactoryBean();
        factory.setClusterNodes(this.properties.getClusterNodes());
        factory.setProperties(this.createProperties());
        factory.afterPropertiesSet();
        return factory;
    }

    private Properties createProperties() {
        Properties properties = new Properties();
        properties.put("cluster.name", this.properties.getClusterName());
        properties.putAll(this.properties.getProperties());
        return properties;
    }



}
