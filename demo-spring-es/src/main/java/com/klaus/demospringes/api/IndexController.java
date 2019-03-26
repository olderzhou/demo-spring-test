package com.klaus.demospringes.api;

import com.klaus.demospringes.config.ElasticsearchUtils;
import com.klaus.demospringes.config.MyConfig;
import com.klaus.demospringes.config.ResponseCodeRules;
import com.klaus.demospringes.ex.GlobalRestExceptionHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.api IndexController
 * @description:
 * @date 2019/3/24 20:07
 */

@RestController
@RequestMapping("/myconfigs")
@Api(tags = "Index Test Module")
@Slf4j
public class IndexController extends GlobalRestExceptionHandler {

    @Autowired
    private MyConfig config;

    @Autowired
    private ResponseCodeRules codeRules;


    @ApiOperation(value = "cluster", notes = "cluster is es, this api show cluster's health status")
    @GetMapping("/cluster")
    public ResponseEntity<ClusterHealthResponse> getClusterHealth() {
        return ResponseEntity.status(HttpStatus.OK).body(ElasticsearchUtils.clusterHealth());
    }

    @ApiOperation(value = "get config", notes = "config is kind of configuration about me")
    @GetMapping("/config")
    public ResponseEntity<MyConfig> getMyConfig() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }


    @GetMapping("/rules")
    @ApiOperation(value = "get rule config", notes = "rule config is kind of configuration about response")
    public ResponseEntity<ResponseCodeRules> getResponseRuleConfigs() {
        log.info("config is :{}", codeRules);
        return ResponseEntity.status(HttpStatus.OK).body(codeRules);
    }



}
