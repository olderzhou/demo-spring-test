package com.klaus.demospringes.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.doc IndexBeanDefine
 * @description:
 * @date 2019/4/23 22:16
 */



@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexBeanDefine {


    private String indexName;
    private Map<String, Object> mapping;








}
