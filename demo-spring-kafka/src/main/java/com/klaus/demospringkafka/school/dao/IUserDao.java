package com.klaus.demospringkafka.school.dao;

import com.klaus.demospringkafka.school.model.School;
import com.klaus.demospringkafka.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.dao IUserDao
 * @description:
 * @date 2019/3/1 00:25
 */
public interface IUserDao extends JpaRepository<User, Long> {




}
