package com.klaus.demospringes.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.api StatusController
 * @description:
 * @date 2019/3/27 01:48
 */

@Slf4j

@RestController
@RequestMapping("/sys")
@Api(tags = "Sys Related")
public class StatusController {


    @Autowired
    private Environment environment;

    @GetMapping("/env")
    @ApiOperation(value = "env", notes = "get environment config")
    public ResponseEntity<Environment> getEnvironment(){
        log.info("environment is {}", environment);
        return ResponseEntity.ok().body(environment);
    }

    @GetMapping("/status")
    @ApiOperation(value = "status", notes = "for health inspect")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("success");
    }
}
