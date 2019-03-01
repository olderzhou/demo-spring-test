package com.klaus.demospringkafka.school.util;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.function.LongSupplier;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.util DslPageExecution
 * @description:
 * @date 2019/3/2 02:26
 */
public class DslPageExecution {
    private DslPageExecution() {}
    public static Page getPage(JPAQuery jpaQuery, Pageable pageable){
        return PageableExecutionUtils.getPage( jpaQuery.fetch(), pageable,
                () -> jpaQuery.fetchCount()
        );
    }
}
