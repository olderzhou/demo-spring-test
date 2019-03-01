package com.klaus.demospringkafka.school.service.impl;

import com.klaus.demospringkafka.school.dao.ISchoolDao;
import com.klaus.demospringkafka.school.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.service.impl SchoolServiceImpl
 * @description:
 * @date 2019/3/1 21:11
 */


@Service
public class SchoolServiceImpl implements ISchoolService {


    @Autowired
    private ISchoolDao schoolDao;







}
