package com.klaus.demospringkafka;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class
})
@EnableJpaAuditing()
@EnableTransactionManagement
public class DemoSpringKafkaApplication {


//    @Bean
//    DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
//
//        return new AuditingDateTimeProvider(dateTimeService);
//    }


    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringKafkaApplication.class, args);
    }

}
