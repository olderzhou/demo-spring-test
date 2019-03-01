package com.klaus.demospringkafka.school.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.model User
 * @description:
 * @date 2019/3/1 00:21
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String idCode;

    private String email;

    private String phone;

    private String mobilePhone;

    private String username;

    /**
     * 类型, 学生,老师,管理员,超级管理员
     */
    private String userType;

    private String descInfo;

    @CreatedBy
    private Long createBy;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss", timezone = "GMT+8")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createDate;
    @LastModifiedBy
    private Long lastUpdateBy;
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss", timezone = "GMT+8")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastUpdateDate;

    private Long schoolId;

    public enum  UserType {
        STUDENT,TEACHER;
    }





}
