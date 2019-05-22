package com.klaus.demographdcarango.model;

import com.arangodb.entity.EdgeEntity;
import com.arangodb.entity.KeyType;
import com.arangodb.entity.VertexEntity;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.model Activity
 * @description:
 * @date 2019/5/21 19:29
 */

@Document(value = "register", replicationFactor = 1, numberOfShards = 4, keyType = KeyType.traditional)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register extends VertexEntity {

    private String name;
    private String mobile;
    private String workCompany;
    private Date createDt;
    private Date endDt;




}
