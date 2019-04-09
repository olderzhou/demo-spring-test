package com.klaus.demospringes.api;

import com.google.gson.Gson;
import com.klaus.demospringes.doc.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.api StatusController
 * @description:
 * @date 2019/3/27 01:48
 */

@Slf4j

@RestController
@RequestMapping("/sys")
@Api(tags = "Sys Related")
public class StatusController {


    @Autowired
    private Environment environment;

    @GetMapping("/env")
    @ApiOperation(value = "env", notes = "get environment config")
    public ResponseEntity<Environment> getEnvironment(){
        log.info("environment is {}", environment.getProperty("logging.config"));
        return ResponseEntity.ok().body(environment);
    }

    @GetMapping("/status")
    @ApiOperation(value = "status", notes = "for health inspect")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("success");
    }


    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Value("${spring.kafka.topic}")
    private String topic;


    @GetMapping("/send")
    @ApiOperation(value = "send kafka", notes = "for kafka test")
    public ResponseEntity<String> sendToKafka(@RequestParam(value = "name", defaultValue = "klaus") String name){

        User user = new User(
                UUID.randomUUID().toString().replace("-",""),
                "klaus",
                String.valueOf(System.currentTimeMillis())
        );
        log.info("user is {}", user);
//        kafkaTemplate.send(topic+"1", new Gson().toJson(user));
        kafkaTemplate.send(topic+"1", user);
        return ResponseEntity.ok("success");
    }




    @KafkaListener(topics = {"klaus1"})
    public void consumeTopic(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("----------------- record = {}", record);
            log.info("------------------ message = {}", message);
        }

    }



}
