package com.klaus.demographdcarango.service;

import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service CommonArangoService
 * @description:
 * @date 2019/5/2 04:08
 */
public interface CommonArangoService {


    /**
     * save data from map
     * @param map
     * @return
     */
    public boolean saveData(Map<String, Object> map);

    /**
     * for create database
     * @param database define a database name
     * @return boolean
     */
    public boolean createDataBases(String database);

    /**
     * create collection
     * @param database
     * @param options collection options
     * @return boolean
     */
    public boolean createCollection(String database, Map<String, String> options);

}
