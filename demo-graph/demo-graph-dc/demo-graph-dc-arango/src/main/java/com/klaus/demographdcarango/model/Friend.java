package com.klaus.demographdcarango.model;

import com.arangodb.entity.EdgeEntity;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.model Friend
 * @description:
 * @date 2019/5/10 02:21
 */
@Document
public class Friend {

    private String type;

    private String startDate;

    private List<Story> stories;


    @From
    private User from;

    @To
    private User to;




}
