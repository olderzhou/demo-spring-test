package com.klaus.kafka.kafkatesta.repository;

import com.klaus.kafka.kafkatesta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.kafka.kafkatesta.repository UserRepository
 * @description:
 * @date 2019/3/14 21:02
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
