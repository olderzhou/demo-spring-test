package com.klaus.kafka.kafkatesta;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaTestApplicationTests.class)
@Slf4j
public class KafkaTestApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private KafkaTemplate template;


    private final CountDownLatch latch = new CountDownLatch(3);

    @Test
    public void run() throws Exception {
        this.template.send("myTopic", "foo1");
        this.template.send("myTopic", "foo2");
        this.template.send("myTopic", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        log.info("All received");
    }

}
