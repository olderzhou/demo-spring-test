package com.klaus.demospringkafka.school.dao;

import com.klaus.demospringkafka.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.dao ISchoolDao
 * @description:
 * @date 2019/3/1 00:25
 */
public interface ISchoolDao extends JpaRepository<School, Long> , QuerydslPredicateExecutor<School> {




}
