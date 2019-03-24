package com.klaus.kafka.kafkatesta.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.runner KafkaSimpleTestRunner
 * @description:
 * @date 2019/3/15 13:50
 */
@Slf4j
public class KafkaSimpleTestRunner implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> template;

    /**
     * producer kafka message to topic
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        this.template.send("myTopic", "foo1");
        this.template.send("myTopic", "foo2");
        this.template.send("myTopic", "foo3");
        log.info("***********************************All received***********************************");
    }
}
