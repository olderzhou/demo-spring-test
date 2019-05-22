package com.klaus.demographdcarango.repo;

import com.arangodb.springframework.repository.ArangoRepository;
import com.klaus.demographdcarango.model.ActivitySignin;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo UserRepository
 * @description:
 * @date 2019/5/2 03:36
 */
public interface ActivitySigninRepository extends ArangoRepository<ActivitySignin, String> {


    /**
     * findActivitySigninByLabel
     * @param label
     * @return
     */
    public Optional<ActivitySignin> findActivitySigninByLabel(String label);
}
