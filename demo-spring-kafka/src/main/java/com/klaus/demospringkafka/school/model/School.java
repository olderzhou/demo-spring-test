package com.klaus.demospringkafka.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.model School
 * @description:
 * @date 2019/3/1 00:21
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class School {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String nameZh;

    private String nameEn;

    private String schoolType;

    private String descInfo;



    @CreatedBy
    private Long createBy;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedBy
    private Long lastUpdateBy;
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;



}
