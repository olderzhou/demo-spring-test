package com.klaus.demographdcmeta;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
@EnableSwagger2Doc
public class DemoGraphDcMetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphDcMetaApplication.class, args);
    }

}
