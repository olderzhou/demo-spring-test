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

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.generator.tables.User.USER;
import static org.jooq.impl.DSL.count;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringKafkaApplication.class)
@Slf4j
public class DemoSpringKafkaApplicationTests {

    @Autowired
    DSLContext create;


    @Test
    public void testGetUser() {
        Integer count = create.select(count(USER.NAME)).from(USER).fetchOne(0, Integer.class);
        Result<UserRecord> result = create.selectFrom(USER).fetch();
        log.info("data is {}", result);
        log.info("count is {}" , count);
        assertEquals(count.intValue(), result.size());
    }


    @Test
    public void testInsert() {

        log.info("local zone id is {}, now is {}", ZoneId.of("GMT+8"), LocalDateTime.now().atZone(ZoneId.of("GMT+8")));
        UserRecord userRecord = create.insertInto(USER, USER.NAME, USER.BIRTH_DAY, USER.BIRTH_TIME, USER.BIRTH_SECONDS)
                .values("damon salvatore", LocalDateTime.now(ZoneId.of("GMT+8")), LocalDateTime.now(ZoneId.of("GMT+8")), (long) LocalDateTime.now(ZoneId.of("GMT+8")).getNano())
                .returning()
                .fetchOne();
        log.info("userRecord is {}", userRecord.getValue(USER.ID));

    }

}
