package com.klaus.demographdcmeta.repository;

import com.klaus.demographdcmeta.model.SchemaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.repository SchemaInfoRepository
 * @description:
 * @date 2019/5/1 04:16
 */
public interface SchemaInfoRepository extends JpaRepository<SchemaInfo, Long> {


    /**
     * find by code
     * @param code
     * @return
     */
    public SchemaInfo findSchemaInfoByCode(String code);



}
