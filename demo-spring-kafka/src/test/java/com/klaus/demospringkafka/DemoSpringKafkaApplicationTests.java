package com.klaus.demospringkafka;

import com.generator.tables.records.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.generator.tables.User.USER;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringKafkaApplication.class)
@Slf4j
public class DemoSpringKafkaApplicationTests {

    @Autowired
    DSLContext create;


    @Test
    public void testGetUser() {

        Result<UserRecord> result = create.selectFrom(USER).fetch();
        log.info("data is {}", result);

        assertEquals(1, result.size());

    }

}
