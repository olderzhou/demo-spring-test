package com.klaus.demospringkafka.school.service.impl;

import com.klaus.demospringkafka.school.dao.ISchoolDao;
import com.klaus.demospringkafka.school.model.User;
import com.klaus.demospringkafka.school.service.IUserService;
import com.klaus.demospringkafka.school.util.DslPageExecution;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.klaus.demospringkafka.school.model.QSchool.school;
import static com.klaus.demospringkafka.school.model.QUser.user;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.service.impl SchoolServiceImpl
 * @description:
 * @date 2019/3/1 21:11
 */


@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private ISchoolDao schoolDao;

    @Autowired
    private JPAQueryFactory queryFactory;


    @Override
    public Page<User> findUserBySchoolId(Long schoolId) {
        PageRequest pageRequest = PageRequest.of(0,10);

        JPAQuery<User> query = queryFactory.select(user)
                .from(user).leftJoin(school).on(school.id.eq(user.schoolId))
                .where(user.schoolId.eq(schoolId))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                ;
        return DslPageExecution.getPage(query, pageRequest);
    }
}
