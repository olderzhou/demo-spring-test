package com.klaus.demospringes.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;

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

    @Bean
    @Profile({"local","uat","test"})
    public TransportClient elasticsearchClient() throws Exception {
        log.info("\n************************\nNormal TransportClient init at :{} \n******************************", System.currentTimeMillis());
        return getTransportClientFactoryBean().getObject();
    }




    @Bean
    @Profile({"huawei"})
    public TransportClient elasticsearchHuaweiClient() throws Exception {
        log.info("\n************************\nHuawei TransportClient init at :{} \n******************************", System.currentTimeMillis());
        return getTransportClientFactoryBean().getObject();
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
