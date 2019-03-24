package com.klaus.demospringes.repo;

import com.klaus.demospringes.doc.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.repo UserRepositoryTest
 * @description:
 * @date 2019/3/22 15:53
 */



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testSaveUser() {
        Long start = System.currentTimeMillis();
        for (int i=0; i<10000000;i++) {
            User user = new User();
//            user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setId("idiii"+i);
            user.setMobile("18664878092"+i);
            user.setName("klaus"+i);
            User u = userRepository.save(user);
        }
        log.info("time user is：{}",  (System.currentTimeMillis() - start));

    }


    @Test
    public void testFindUserByName(){

        User user = userRepository.findUserByName("klaus");
        log.info("user info is :{}", user);


    }



    @Test
    public void testBulkSave() {

        List<User> users = new ArrayList<>();
        for(int i = 0;i<1000000;i++) {
            User user = new User();
//            user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setId("damon"+i);
            user.setMobile("18664878092"+i);
            user.setName("klaus"+i);
            users.add(user);
        }
        long start =System.currentTimeMillis();
        userRepository.saveAll(users);

        log.info("time user is {}",System.currentTimeMillis() - start);
    }


}