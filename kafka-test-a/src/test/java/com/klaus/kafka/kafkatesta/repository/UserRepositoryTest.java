package com.klaus.kafka.kafkatesta.repository;

import com.klaus.kafka.kafkatesta.KafkaTestApplication;
import com.klaus.kafka.kafkatesta.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.repository UserRepositoryTest
 * @description:
 * @date 2019/3/14 21:05
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = KafkaTestApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() throws Exception {
        User user = new User();
        user.setName("郑龙飞");
        user.setUrl("http://merryyou.cn");
        User result = userRepository.save(user);
        log.info(result.toString());
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void findOneTest() throws Exception{
        Optional<User> user = userRepository.findById(1l);
        log.info(user.toString());
        user.ifPresent(i -> log.info("user is :{}",i));
        Assert.assertTrue(user.isPresent());
    }
}