package com.klaus.demographdcarango;

import com.arangodb.springframework.annotation.EnableArangoAuditing;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
//@EnableArangoAuditing
//@EnableArangoRepositories(basePackages = {"com.klaus.demographdcarango.model","com.klaus.demographdcarango.repo"})
public class DemoGraphDcArangoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphDcArangoApplication.class, args);
    }

}
