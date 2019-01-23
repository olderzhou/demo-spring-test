package com.klaus.demospringstatemachine;

import com.klaus.demospringstatemachine.runner.TestRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringstatemachine TestRunner
 * @description:
 * @date 2019/1/24 00:21
 */
@SpringBootApplication(scanBasePackages = {"com.klaus.demospringstatemachine"})
public class DemoSpringStateMachineApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoSpringStateMachineApplication.class, args);

        final Class<?>[] runner = new Class<?>[] { TestRunner.class };
        System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
    }


}

