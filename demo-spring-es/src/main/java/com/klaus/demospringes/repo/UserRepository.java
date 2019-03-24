package com.klaus.demospringes.repo;

import com.klaus.demospringes.doc.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes UserRepository
 * @description:
 * @date 2019/3/22 15:31
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {


    /**
     * find user by name
     * @param name
     * @return
     */
    public User findUserByName(String name);

}
