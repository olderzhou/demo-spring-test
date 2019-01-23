package com.klaus.demospringstatemachine.runner;

import com.klaus.demospringstatemachine.config.Events;
import com.klaus.demospringstatemachine.config.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringstatemachine TestRunner
 * @description:
 * @date 2019/1/24 00:21
 */
@ComponentScan("com.klaus.demospringstatemachine.config")
public class TestRunner implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}
