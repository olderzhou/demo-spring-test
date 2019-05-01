package com.klaus.demospringes.api;

import com.google.gson.Gson;
import com.klaus.demospringes.doc.User;
import com.klaus.demospringes.repo.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.KafkaFuture;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    @Autowired
    private KafkaAdmin kafkaAdmin;

    private AdminClient adminClient;

    @PostConstruct
    public void init() {
        adminClient = AdminClient.create(kafkaAdmin.getConfig());
    }

    @GetMapping("/topicInfo")
    @ApiOperation(value = "show kafka info", notes = "for kafka test")
    public ResponseEntity<Map> topicInfo(@RequestParam(name = "topic", defaultValue = "klaus1") String topic) {
        Map<String, Object> result = new HashMap();
        log.info("topic is :{}", topic);

        result.putAll(kafkaAdmin.getConfig());
        CreateTopicsResult createTopicsResult  = adminClient.createTopics(Collections.singleton(new NewTopic(topic, 10, (short) 1)));
        log.info("createTopicsResult is :{}", createTopicsResult.values());
        KafkaFuture<Void> createKafkaFuture = createTopicsResult.all();
        try {
            createKafkaFuture.get(10L, TimeUnit.MINUTES);

            ListTopicsResult listTopicsResult = adminClient.listTopics();
            log.info("listTopicsResult is :{}", listTopicsResult.names());

            KafkaFuture<Collection<TopicListing>> kafkaFuture = listTopicsResult.listings();
                Collection<TopicListing> topics = kafkaFuture.get(1000L, TimeUnit.MINUTES);
                topics.stream().forEach(i -> log.info("------------------------topic is :{}", i.name()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(result);
    }


    @GetMapping("/send")
    @ApiOperation(value = "send kafka", notes = "for kafka test")
    public ResponseEntity<String> sendToKafka(@RequestParam(value = "name", defaultValue = "klaus") String name){

        for(int i = 0; i<10000; i++){

            User user = new User(
                    UUID.randomUUID().toString().replace("-",""),
                    name+count.addAndGet(1),
                    String.valueOf(System.currentTimeMillis())
            );
//            log.info("user is {}", user);
    //        kafkaTemplate.send(topic+"1", new Gson().toJson(user));
            kafkaTemplate.send(topic, user);
//            kafkaTemplate.sendDefault(user);
        }
        log.info("send user messages is: {}", 10000);
        return ResponseEntity.ok("success");
    }



//    @KafkaListener(topics = {"klaus"})
    public void consumeTopicL0(ConsumerRecord<String, User> record/*, Acknowledgment acknowledgment*/) {
        Optional<User> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            User message = kafkaMessage.get();

            log.info("KafkaListener 0----------------- record = {}", record);
            log.info("KafkaListener 0------------------ message = {}", message);
//            acknowledgment.acknowledge()
//            ;

//            userRepository.save(message);
        }

    }
    @KafkaListener(topics = {"klaus"}, groupId = "test-klaus-batch")
    public void consumeTopicL1(List<ConsumerRecord<String, User>> records/*, Acknowledgment acknowledgment*/) {
        log.info("record size is {}", records.size());
        for(ConsumerRecord<String, User> msg :records) {
            Optional<User> kafkaMessage = Optional.ofNullable(msg.value());
            if (kafkaMessage.isPresent()) {

                User message = kafkaMessage.get();

//                log.info("KafkaListener batch----------------- record = {}", msg);
//                log.info("KafkaListener batch------------------ message = {}", message);
    //            acknowledgment.acknowledge()
    //            ;

//                userRepository.save(message);
            }
        }

    }
//    @KafkaListener(topics = {"klaus"}, groupId = "test-klaus")
//    public void consumeTopicGroupNew(ConsumerRecord<String, User> record/*, Acknowledgment acknowledgment*/) {
//        Optional<User> kafkaMessage = Optional.ofNullable(record.value());
//
//        if (kafkaMessage.isPresent()) {
//
//            User message = kafkaMessage.get();
//
//            log.info("groupid test-klaus----------------- record = {}", record);
//            log.info("groupid test-klaus------------------ message = {}", message);
////            acknowledgment.acknowledge()
////            ;
//
////            userRepository.save(message);
//        }
//    }



}
