package com.klaus.kafka.kafkatesta;

import com.klaus.kafka.kafkatesta.runner.KafkaSimpleTestRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Niklaus Mikaelson
 */
@SpringBootApplication
//@EnableSwa
public class KafkaTestApplication {

    public static Logger logger = LoggerFactory.getLogger(KafkaTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaTestApplication.class, args);

//        final Class<?>[] runner = new Class<?>[] {KafkaTestApplication.class/*, KafkaSimpleTestRunner.class */};
//        /*System.exit(SpringApplication.exit(*/SpringApplication.run(runner, args)/*))*/;

    }



}

