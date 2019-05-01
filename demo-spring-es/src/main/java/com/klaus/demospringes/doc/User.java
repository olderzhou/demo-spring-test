package com.klaus.demospringes.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Generated;
import javax.validation.constraints.Max;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.doc User
 * @description:
 * @date 2019/3/22 11:03
 */

@Document(indexName = "demo-spring-es", type = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String name;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
//    @Max(value = 15)
    private String mobile;


}
