package com.klaus.demospringes.service;

import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service PaperService
 * @description:
 * @date 2019/4/23 00:39
 */
public interface PaperService {

    /**
     * find index's type define
     * @param index
     * @param type
     * @return
     */
    Map findPaperDifinition(String index, String  type);


    /**
     * @param index
     * @param type
     * @return
     */
    boolean isTypeExists(String index, String type);


    /**
     * @param index
     * @param type
     * @return
     */
    String  createIndex(String index, String type);
}
