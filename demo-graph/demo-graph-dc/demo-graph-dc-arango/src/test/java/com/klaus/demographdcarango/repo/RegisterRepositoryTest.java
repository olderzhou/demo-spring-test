package com.klaus.demographdcarango.repo;

import com.klaus.demographdcarango.DemoGraphDcArangoApplication;
import com.klaus.demographdcarango.model.Register;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo RegisterRepositoryTest
 * @description:
 * @date 2019/5/22 00:10
 */



@SpringBootTest(classes = DemoGraphDcArangoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class RegisterRepositoryTest {

    @Autowired
    private RegisterRepository registerRepository;

    @Test
    public void test() {
        Register register = new Register();
        register.setCreateDt(new Date());
        register.setEndDt(new Date());
        register.setMobile("18664878092");
        register.setName("klaus");
        register.setWorkCompany("stargraph");
        Register result = registerRepository.save(register);
    }
}