package com.klaus.demographdcmeta.repository;

import com.klaus.demographdcmeta.DemoGraphDcMetaApplication;
import com.klaus.demographdcmeta.model.SchemaInfo;
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
 * @class demo-spring-test-com.klaus.demographdcmeta.repository SchemaInfoRepositoryTest
 * @description:
 * @date 2019/5/2 00:43
 */


@SpringBootTest(classes = DemoGraphDcMetaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class SchemaInfoRepositoryTest {


    @Autowired
    private SchemaInfoRepository schemaInfoRepository;



    @Test
    public void testSaveSchema() {

        SchemaInfo schmaInfo = new SchemaInfo();
        schmaInfo.setId(1L);
        schmaInfo.setCode("tv_person");
        schmaInfo.setName("人");
        schmaInfo.setRemark("person abstraction from the real world");
        schmaInfo.setCreateBy(1L);
        schmaInfo.setUpdateBy(1L);
        schemaInfoRepository.save(schmaInfo);

        Optional<SchemaInfo> optional = schemaInfoRepository.findById(1L);

        log.info("schema info is :{}", optional.get());
        Assert.assertTrue(optional.isPresent());

    }
}