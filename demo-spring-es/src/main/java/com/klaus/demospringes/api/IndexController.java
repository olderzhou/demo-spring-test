package com.klaus.demospringes.api;

import com.klaus.demospringes.config.MyConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
public class IndexController {

    @Autowired
    private MyConfig config;

//    @Autowired
//    private ResponseCodeRules codeRules;


    @ApiOperation(value = "getDefault", notes = "config is kind of configuration about me")
    @GetMapping("/getDefault")
    public ResponseEntity<MyConfig> getDefault() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }

    @ApiOperation(value = "get config", notes = "config is kind of configuration about me")
    @GetMapping("/my")
    public ResponseEntity<MyConfig> getMyConfig() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }


    @GetMapping("/response/rules")
    @ApiOperation(value = "get rule config", notes = "rule config is kind of configuration about response")
    public ResponseEntity<MyConfig> getResponseRuleConfigs() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }



}
