package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.service.EsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service EsServiceTest
 * @description:
 * @date 2019/3/25 16:03
 */


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@Profile({"huawei"})
@ActiveProfiles(profiles = "huawei")
public class EsServiceTest {

    @Autowired
    private EsService esService;

    @Test
    public void testEsService() {
        esService.info();
    }



}