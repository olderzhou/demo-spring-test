package com.klaus.demospringkafka;

import com.google.gson.Gson;
import com.klaus.demospringkafka.school.dao.ISchoolDao;
import com.klaus.demospringkafka.school.dao.IUserDao;
import com.klaus.demospringkafka.school.model.School;
import com.klaus.demospringkafka.school.model.User;
import com.klaus.demospringkafka.school.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringKafkaApplication.class)
@Slf4j
public class DemoSpringKafkaApplicationTests {

    @Autowired
    private ISchoolDao schoolDao;

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        log.info("invoked test ................ {}", LocalDateTime.now());
        List<School> schools =  schoolDao.findAll();

        log.info("schools is {}", schools);


        List<User> users = userDao.findAll();

        users.forEach(i -> log.info("user info is {}", i));

        User user = new User();
        user.setUsername("elena");
        user.setDescInfo("a pretty girl");
        user.setUserType(User.UserType.STUDENT.name());
        user.setIdCode("stu23432413411");
        user = userDao.save(user);

        log.info("after save user is {}", user);

        assertEquals("elena", user.getUsername());
    }



    @Test
    public void testFindUserBySchoolId() {
        Page<User> users = userService.findUserBySchoolId(1L);

        log.info("page user is {}", new Gson().toJson(users));


    }




}
