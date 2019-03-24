package com.klaus.kafka.kafkatesta.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.config KafkaConfig
 * @description:
 * @date 2019/3/15 13:48
 */

@Slf4j
@Configuration
@EnableKafka
public class KafkaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public KafkaAdmin admin() {
//        log.info("===========================\nkafkaProperties is {}\n==============================", new Gson().toJson(kafkaProperties));
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, StringUtils.arrayToCommaDelimitedString(embeddedKafka().getBrokerAddresses()));
        return new KafkaAdmin(configs);
    }


    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(admin().getConfig());
    }


    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info("*****************************************\n  {} received data is:{}   \n ****************************************", System.currentTimeMillis(), cr.toString());
    }

//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("thing1", 10, (short) 1);
//    }
//
//    @Bean
//    public NewTopic topic2() {
//        return new NewTopic("thing2", 10, (short) 1);
//    }




}
