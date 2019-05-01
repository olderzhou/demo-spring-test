package com.klaus.demographdcmeta.service;

import com.klaus.demographdcmeta.model.SchemaInfo;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.service SchemaInfoService
 * @description:
 * @date 2019/5/2 01:53
 */
public interface SchemaInfoService {


    /**
     * save entity
     * @param schemaInfo
     * @return
     */
    public SchemaInfo saveSchemaInfo(SchemaInfo schemaInfo);


    /**
     * find by code
     * @param code
     * @return
     */
    public SchemaInfo getSchemaInfoByCode(String code);

    /**
     * find by id
     * @param id
     * @return
     */
    public Optional<SchemaInfo> getSchemaInfoById(Long id);



    public void deleteById(Long id);

}
