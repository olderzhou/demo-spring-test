package com.klaus.demospringes.config;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.config MyConfig
 * @description:
 * @date 2019/3/24 19:56
 */

//@Component
//@ConfigurationProperties(prefix="response")
@ToString
@Data
public class ResponseCodeRules {

    private List<Map<String, String>> codeMap = new ArrayList<Map<String, String>>();


//    public



}
