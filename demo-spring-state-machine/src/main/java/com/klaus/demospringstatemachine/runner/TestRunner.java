package com.klaus.demospringstatemachine.runner;

import com.klaus.demospringstatemachine.config.Events;
import com.klaus.demospringstatemachine.config.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringstatemachine TestRunner
 * @description:
 * @date 2019/1/24 00:21
 */
@ComponentScan("com.klaus.demospringstatemachine.config")
@Slf4j
public class TestRunner implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        log.info("after E1 stateMachine state is :{}", stateMachine);
        stateMachine.sendEvent(Events.E2);
        log.info("after E2 stateMachine state is :{}", stateMachine);
        stateMachine.sendEvent(Events.E3);
        log.info("after E3 stateMachine state is :{}", stateMachine);
        stateMachine.sendEvent(Events.E4);
        log.info("after E4 stateMachine state is :{}", stateMachine);
    }
}
