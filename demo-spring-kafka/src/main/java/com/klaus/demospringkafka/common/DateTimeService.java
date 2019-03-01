package com.klaus.demospringkafka.common;

import java.time.ZonedDateTime;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.common DateTimeService
 * @description:
 * @date 2019/3/1 21:45
 */
public interface DateTimeService {

    /**
     * Returns the current date and time.
     * @return
     */
    ZonedDateTime getCurrentDateAndTime();

}
