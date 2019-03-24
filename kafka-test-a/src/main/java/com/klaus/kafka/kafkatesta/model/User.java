package com.klaus.kafka.kafkatesta.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.model User
 * @description:
 * @date 2019/3/14 21:01
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}