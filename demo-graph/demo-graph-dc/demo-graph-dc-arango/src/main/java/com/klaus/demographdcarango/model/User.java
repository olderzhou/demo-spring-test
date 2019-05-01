package com.klaus.demographdcarango.model;

import com.arangodb.entity.KeyType;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.model User
 * @description:
 * @date 2019/5/2 03:28
 */

@Document(value = "user", replicationFactor = 1, numberOfShards = 4, keyType = KeyType.traditional)
@HashIndex(fields = { "name", "mobile" }, unique = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String mobile;

    private int age;
    //1:male, 2:female, 3:unknow
    private short gender;
}
