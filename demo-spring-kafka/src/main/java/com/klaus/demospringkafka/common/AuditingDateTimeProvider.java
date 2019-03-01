package com.klaus.demospringkafka.common;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.common AuditingDateTimeProvider
 * @description:
 * @date 2019/3/1 21:49
 */


public class AuditingDateTimeProvider /*implements DateTimeProvider*/ {

    private final DateTimeService dateTimeService;

    public AuditingDateTimeProvider(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

//    @Override
    public Calendar getNow() {
        return GregorianCalendar.from(dateTimeService.getCurrentDateAndTime());
    }
}
