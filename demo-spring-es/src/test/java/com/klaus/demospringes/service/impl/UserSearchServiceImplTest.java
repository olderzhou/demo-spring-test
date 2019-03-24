package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.service.UserSearchServiece;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl UserSearchServiceImplTest
 * @description:
 * @date 2019/3/24 15:34
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserSearchServiceImplTest {

    @Autowired
    private UserSearchServiece userSearchServiece;

    @Test
    public void findUser() {
        userSearchServiece.findUser();




    }
}