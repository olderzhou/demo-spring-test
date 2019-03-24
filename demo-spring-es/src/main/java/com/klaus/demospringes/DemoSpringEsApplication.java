package com.klaus.demospringes;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Klaus Mikaelson
 */
@SpringBootApplication(scanBasePackages = {"com.klaus.demospringes"})
@EnableSwagger2Doc
public class DemoSpringEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringEsApplication.class, args);
    }

}
