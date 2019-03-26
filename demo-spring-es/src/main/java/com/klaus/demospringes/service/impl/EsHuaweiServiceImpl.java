package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.config.ElasticsearchUtils;
import com.klaus.demospringes.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl EsHuaweiServiceImpl
 * @description:
 * @date 2019/3/25 10:19
 */
@Service
@Profile({"huawei"})
@Slf4j
public class EsHuaweiServiceImpl implements EsService {
    @Override
    public String info() {

        log.info("huawei es service invoked");

        ClusterHealthResponse response = ElasticsearchUtils.clusterHealth();
        return "success";
    }
}
