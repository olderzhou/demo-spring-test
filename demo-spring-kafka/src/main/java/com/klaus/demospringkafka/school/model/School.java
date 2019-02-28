package com.klaus.demospringkafka.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.model School
 * @description:
 * @date 2019/3/1 00:21
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {


//    @Id
    private Long id;

    private String code;

    private String nameZh;

    private String nameEn;

    private String type;

    private String desc;



}
