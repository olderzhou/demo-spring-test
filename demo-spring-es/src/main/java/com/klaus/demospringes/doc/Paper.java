package com.klaus.demospringes.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.doc User
 * @description:
 * @date 2019/3/22 11:03
 */

@Document(indexName = "demo-spring-es-paper", type = "paper")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    @Id
    private String id;

    @Field(type = FieldType.Text, searchAnalyzer = "standard",analyzer = "standard")
    private String author;

    @Field(type = FieldType.Date, searchAnalyzer = "standard", analyzer = "standard")
    private Date createDate;

    @Field
    private List<String> tags;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
//    @Max(value = 15)
    private String email;

    @Field
    private  String content;

    @Field
    private String title;


}
