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

    /*@Bean(name = "mapperObject")
    public ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        om.registerModule(javaTimeModule);
        return om;
    }*/

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

    /*@Component
    public class KafkaBean {

        private final KafkaTemplate kafkaTemplate;

        @Autowired
        public KafkaBean(KafkaTemplate kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        @KafkaListener(topics = "someTopic")
        public void processMessage(String content) {

        }
    }*/



    public static void main(String[] args) {
        SpringApplication.run(DemoSpringKafkaApplication.class, args);
    }

}
