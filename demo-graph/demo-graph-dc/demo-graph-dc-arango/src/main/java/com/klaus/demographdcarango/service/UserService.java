package com.klaus.demographdcarango.service;

import com.klaus.demographdcarango.model.User;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service UserService
 * @description:
 * @date 2019/5/2 04:17
 */
public interface UserService {

    /**
     * findUserByMobile
     * @param mobile
     * @return
     */
    public Optional<User> findUserByMobile(String mobile);
}
