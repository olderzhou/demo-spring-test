package com.klaus.demographregistercenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@Slf4j
@EnableEurekaServer
public class DemoGraphRegisterCenterApplication {


    @RequestMapping("/")
    public String home() {
        log.debug("invoked here ------------------------");
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphRegisterCenterApplication.class, args);
    }

}
