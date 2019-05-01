package com.klaus.demographdcarango.service.impl;

import com.klaus.demographdcarango.model.User;
import com.klaus.demographdcarango.repo.UserRepository;
import com.klaus.demographdcarango.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service.impl UserServiceImpl
 * @description:
 * @date 2019/5/2 04:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByMobile(String mobile) {
        return userRepository.findUserByMobile(mobile);
    }




}
