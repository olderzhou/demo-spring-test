package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl PaperServiceImplTest
 * @description:
 * @date 2019/4/23 00:48
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class PaperServiceImplTest {

    @Autowired
    private PaperService paperService;

    @Test
    public void findPaperDifinition() {

        Map mapping = paperService.findPaperDifinition("demo-spring-es-paper", "paper");

        log.info("mapping is :{}", mapping);


    }

    @Test
    public void isTypeExists() {

        Boolean result = paperService.isTypeExists("demo-spring-es-paper", "paper");
        Assert.assertTrue(result);
    }

    @Test
    public void createIndex() {

        String index = paperService.createIndex("demo-spring-es-test", "test");
        log.info("index is :{}", index);

    }
}