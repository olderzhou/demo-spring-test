package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.config.ElasticsearchUtils;
import com.klaus.demospringes.service.UserSearchServiece;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl UserSearchServiceImpl
 * @description:
 * @date 2019/3/24 14:55
 */
@Slf4j
@Service
public class UserSearchServiceImpl implements UserSearchServiece {



    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @Autowired
    private RestClient restClient;

    @Override
    public Map<String, Object> findUser() {
        Map<String, Object>  data = ElasticsearchUtils.searchDataById("demo-spring-es", "user","idiii80","id,name");
        log.info("search result data is {}", data);
        return data;
    }

    @Override
    public void createType() {
        log.info("invoked {}", System.currentTimeMillis());


//        restHighLevelClient.c

        List<Node> nodes = restClient.getNodes();
        restHighLevelClient.getLowLevelClient();



    }
}
