package com.klaus.demographdcarango.service.impl;

import com.arangodb.springframework.core.ArangoOperations;
import com.klaus.demographdcarango.service.CommonArangoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service.impl CommonArangoServiceImpl
 * @description:
 * @date 2019/5/2 04:09
 */
public class CommonArangoServiceImpl implements CommonArangoService {

    @Autowired
    private ArangoOperations arangoOperations;


    @Override
    public boolean saveData(Map<String, Object> map) {


//        arangoOperations.insert();


        return false;
    }
}
