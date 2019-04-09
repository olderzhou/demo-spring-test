package com.klaus.demospringes.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.config ElasticsearchUtils
 * @description:
 * @date 2019/3/24 15:02
 */

@Component
@Slf4j
@Profile("huawei")
public class HuaweiElasticsearchUtils {

    private RestClient restClient;


    @Autowired
    private static RestClient client;

    @PostConstruct
    public void init() {
        client = this.restClient;
    }


    public static Response clusterHealth() {

        Response rsp = null;
        try {
            rsp = client.performRequest("GET", "/_cluster/health");
            log.info("queryEsClusterHealth,response entity is : {} ", rsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsp;
    }


}
