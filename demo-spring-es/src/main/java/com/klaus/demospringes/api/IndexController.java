package com.klaus.demospringes.api;

import com.klaus.demospringes.config.MyConfig;
import com.klaus.demospringes.config.ResponseCodeRules;
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

@RestController("/myconfigs")
@Slf4j
public class IndexController {

    @Autowired
    private MyConfig config;

//    @Autowired
//    private ResponseCodeRules codeRules;


    @GetMapping()
    public ResponseEntity<MyConfig> getDefault() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }

    @GetMapping("/my")
    public ResponseEntity<MyConfig> getMyConfig() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }


    @GetMapping("/response/rules")
    public ResponseEntity<MyConfig> getResponseRuleConfigs() {
        log.info("config is :{}", config);
        return ResponseEntity.status(HttpStatus.OK).body(config);
    }



}
