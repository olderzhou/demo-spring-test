package com.klaus.kafka.kafkatesta.controller;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.controller DataCenter
 * @description:
 * @date 2019/3/15 15:30
 */

@Api
@RestController("/dc")
@Slf4j
public class DataCenter {

    @Autowired
    private AdminClient adminClient;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/toKafka")
    public ResponseEntity<String> toKafkaMongoCenter() {

        for(int i=0;i<10; i++){
            this.kafkaTemplate.send("mytopic", "test data is :"+ i);
        }
        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "创建topic")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",defaultValue = "first_top",
                    required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "partitions", value = "分区数", defaultValue = "4",
                    required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "replicationFactor", value = "副本数", defaultValue = "1",
                    required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/createTopic")
    public String createTopic(String topicName,int partitions,int replicationFactor){
        adminClient.createTopics(Arrays.asList(new NewTopic(topicName,partitions,(short)replicationFactor)));
        return "create success";
    }

    @ApiOperation(value = "查看所有的topic")
    @GetMapping("/findAllTopic")
    public String findAllTopic() throws ExecutionException, InterruptedException {
        ListTopicsResult result = adminClient.listTopics();
        Collection<TopicListing> list = result.listings().get();
        List<String> resultList = new ArrayList<>();
        for(TopicListing topicListing : list){
            resultList.add(topicListing.name());
        }
        return new Gson().toJson(resultList);
    }

    @ApiOperation(value = "查看topic详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",defaultValue = "first_top",
                    required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/info")
    public String topicInfo(String topicName) throws ExecutionException, InterruptedException {
        DescribeTopicsResult result = adminClient.describeTopics(Arrays.asList(topicName));
        Map<String,String> resultMap = new HashMap<>();
        result.all().get().forEach((k,v)->{
            log.info("k: "+k+" ,v: "+v.toString());
            resultMap.put(k,v.toString());
        });

        return new Gson().toJson(resultMap);
    }

    @ApiOperation(value = "删除topic")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",defaultValue = "first_top",
                    required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/delete")
    public String deleteTopic(String topicName){
        DeleteTopicsResult  result = adminClient.deleteTopics(Arrays.asList(topicName));
        return  new Gson().toJson(result.values());
    }


}
