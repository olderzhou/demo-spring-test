package com.klaus.demospringkafka.school.service;

import com.klaus.demospringkafka.school.model.User;
import org.springframework.data.domain.Page;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.school.service ISchoolService
 * @description:
 * @date 2019/3/1 21:11
 */
public interface IUserService {

    /**
     * findUserBySchoolId
     * @param schoolId
     * @return
     */
    public Page<User> findUserBySchoolId(Long schoolId);
}
