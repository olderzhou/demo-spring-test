package com.klaus.demospringarango.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringarango.api Index
 * @description:
 * @date 2019/5/1 02:26
 */

@RestController
@RequestMapping("/index")
public class Index {


    @GetMapping("/status")
    public ResponseEntity<Boolean> status() {
        return ResponseEntity.ok(true);
    }




}
