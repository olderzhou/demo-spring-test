package com.klaus.demospringes.api;

import com.google.gson.Gson;
import com.klaus.demospringes.doc.User;
import com.klaus.demospringes.repo.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

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


    @Bean
    public NewTopic topic1() {
        return new NewTopic(topic, 10, (short) 2);
    }



    private final AtomicInteger count = new AtomicInteger(0);


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/send")
    @ApiOperation(value = "send kafka", notes = "for kafka test")
    public ResponseEntity<String> sendToKafka(@RequestParam(value = "name", defaultValue = "klaus") String name){

        for(int i = 0; i<10; i++){

            User user = new User(
                    UUID.randomUUID().toString().replace("-",""),
                    name+count.addAndGet(1),
                    String.valueOf(System.currentTimeMillis())
            );
            log.info("user is {}", user);
    //        kafkaTemplate.send(topic+"1", new Gson().toJson(user));
            kafkaTemplate.send(topic, user);
        }
        return ResponseEntity.ok("success");
    }




    @KafkaListener(topics = {"klaus"})
    public void consumeTopic(ConsumerRecord<String, User> record/*, Acknowledgment acknowledgment*/) {
        Optional<User> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            User message = kafkaMessage.get();

            log.info("----------------- record = {}", record);
            log.info("------------------ message = {}", message);
//            acknowledgment.acknowledge()
//            ;

            userRepository.save(message);
        }

    }



}
