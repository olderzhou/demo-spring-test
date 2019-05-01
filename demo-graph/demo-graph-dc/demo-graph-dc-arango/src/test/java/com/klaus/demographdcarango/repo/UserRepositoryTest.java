package com.klaus.demographdcarango.repo;

import com.klaus.demographdcarango.DemoGraphDcArangoApplication;
import com.klaus.demographdcarango.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo UserRepositoryTest
 * @description:
 * @date 2019/5/2 03:45
 */


@SpringBootTest(classes = DemoGraphDcArangoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testSaveUser() {

        User user = new User();
        user.setAge(10);
        user.setGender((short) 2);
        user.setMobile("18664878092");
        user.setName("klaus");
        user = userRepository.save(user);

        log.info("user is :{}", user);

        Assert.assertNotNull(user.getId());

    }
}