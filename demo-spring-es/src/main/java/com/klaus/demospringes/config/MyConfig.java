package com.klaus.demospringes.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.config MyConfig
 * @description:
 * @date 2019/3/24 19:56
 */


@Component
@ConfigurationProperties(prefix="my")
@ToString
@Data
public class MyConfig {

    private List<String> servers = new ArrayList<String>();
}
