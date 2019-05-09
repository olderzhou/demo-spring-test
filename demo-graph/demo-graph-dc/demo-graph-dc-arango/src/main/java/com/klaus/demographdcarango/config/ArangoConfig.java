package com.klaus.demographdcarango.config;

import com.arangodb.springframework.annotation.EnableArangoAuditing;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import org.springframework.stereotype.Component;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.config ArangoConfig
 * @description:
 * @date 2019/5/9 21:16
 */

@Component
@EnableArangoAuditing
@EnableArangoRepositories
public class ArangoConfig {


}
