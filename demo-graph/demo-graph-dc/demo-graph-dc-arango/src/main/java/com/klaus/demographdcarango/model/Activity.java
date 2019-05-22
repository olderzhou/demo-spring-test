package com.klaus.demographdcarango.model;

import com.arangodb.entity.KeyType;
import com.arangodb.entity.VertexEntity;
import com.arangodb.springframework.annotation.Document;
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

@Document(value = "activity", replicationFactor = 1, numberOfShards = 4, keyType = KeyType.traditional)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity extends VertexEntity {

    private String type;
    private Date createDt;
    private Date endDt;
    private String description;
    private List<String> tips;




}
