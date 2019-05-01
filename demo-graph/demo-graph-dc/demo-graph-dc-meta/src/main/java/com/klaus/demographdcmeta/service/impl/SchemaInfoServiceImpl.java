package com.klaus.demographdcmeta.service.impl;

import com.klaus.demographdcmeta.model.SchemaInfo;
import com.klaus.demographdcmeta.repository.SchemaInfoRepository;
import com.klaus.demographdcmeta.service.SchemaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.service.impl SchemaInfoServiceImpl
 * @description:
 * @date 2019/5/2 01:54
 */
@Service
public class SchemaInfoServiceImpl implements SchemaInfoService {

    @Autowired
    private SchemaInfoRepository infoRepository;


    @CachePut(cacheNames="content",key="#schemaInfo.userId")
    @Override
    public SchemaInfo saveSchemaInfo(SchemaInfo schemaInfo) {
        return infoRepository.save(schemaInfo);
    }

    @Override
    public SchemaInfo getSchemaInfoByCode(String code) {
        return infoRepository.findSchemaInfoByCode(code);
    }

    @Override
    @Cacheable(cacheNames="content",key="#id")
    public Optional<SchemaInfo> getSchemaInfoById(Long id) {
        return infoRepository.findById(id);
    }

    @CacheEvict
    @Override
    public void deleteById(Long id) {
        infoRepository.deleteById(id);
    }


}
