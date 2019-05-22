package com.klaus.demographdcarango.repo;

import com.arangodb.springframework.repository.ArangoRepository;
import com.klaus.demographdcarango.model.Activity;
import com.klaus.demographdcarango.model.User;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo UserRepository
 * @description:
 * @date 2019/5/2 03:36
 */
public interface ActivityRepository extends ArangoRepository<Activity, String> {


    /**
     * findActivitiesByType
     * @param type
     * @return
     */
    public Optional<Activity> findActivitiesByType(String type);
}
