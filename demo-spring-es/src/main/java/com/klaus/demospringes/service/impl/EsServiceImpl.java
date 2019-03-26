package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.config.ElasticsearchUtils;
import com.klaus.demospringes.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl EsServiceImpl
 * @description:
 * @date 2019/3/25 10:13
 */


@Service
@Profile({"local","test","uat"})
@Slf4j
public class EsServiceImpl implements EsService {

    @Autowired
    private TransportClient client;

    @Override
    public String info() {
        log.info("client info is :{}", client.transportAddresses());
        log.info("normal es service invoked");

        ClusterHealthResponse response = ElasticsearchUtils.clusterHealth();
        log.info("ClusterHealthResponse is {}", response);
        return "sucess";
    }
}
