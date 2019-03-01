package com.klaus.demospringkafka.common;

import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.common CurrentTimeDateTimeService
 * @description:
 * @date 2019/3/1 21:48
 */

@Slf4j
public class CurrentTimeDateTimeService implements DateTimeService{

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        ZonedDateTime currentDateAndTime =  ZonedDateTime.now();
        return currentDateAndTime;
    }
}
