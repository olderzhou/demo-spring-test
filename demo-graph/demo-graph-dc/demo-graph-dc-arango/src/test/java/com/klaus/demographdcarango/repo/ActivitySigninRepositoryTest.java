package com.klaus.demographdcarango.repo;

import com.klaus.demographdcarango.DemoGraphDcArangoApplication;
import com.klaus.demographdcarango.model.Activity;
import com.klaus.demographdcarango.model.ActivitySignin;
import com.klaus.demographdcarango.model.Register;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo ActivitySigninRepositoryTest
 * @description:
 * @date 2019/5/21 23:32
 */



@SpringBootTest(classes = DemoGraphDcArangoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles(profiles = {"local"})
public class ActivitySigninRepositoryTest {

    @Autowired
    private ActivitySigninRepository signinRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private RegisterRepository registerRepository;

    @Test
    public void test() {

        Optional<Activity> activityOptional = activityRepository.findById("activity/65121732");

        Optional<Register> registerOptional = registerRepository.findById("register/65122416");

        ActivitySignin signin = new ActivitySignin();
        signin.setCreateDt(new Date());
        signin.setLabel("register-activity");
        signin.setSigninDt(new Date());
        if(activityOptional.isPresent()) {
            log.info("activityOptional data is :{}", activityOptional.get());
            signin.setTo(activityOptional.get());
        }
        if(registerOptional.isPresent()) {
            log.info("registerOptional data is :{}", activityOptional.get());
            signin.setFrom(registerOptional.get());
        }
        log.info("######################################signin is: {}", signin);
        ActivitySignin activitySignin = signinRepository.save(signin);
        log.info("--------------------------------------activitySignin is: {}", activitySignin);
        Assert.assertTrue(activitySignin != null);

    }

}