package com.klaus.demographdcarango.model;

import com.arangodb.entity.KeyType;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.model Story
 * @description:
 * @date 2019/5/10 02:24
 */





@Document(value = "story", replicationFactor = 1, numberOfShards = 4, keyType = KeyType.traditional)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Story {



    private Date startDt;

    private String topic;

    private List<User> joinUsers;





}
