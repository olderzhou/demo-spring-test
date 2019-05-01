package com.klaus.demographdcmeta.api;

import com.klaus.demographapi.dc.meta.qo.SchemaQo;
import com.klaus.demographdcmeta.model.SchemaInfo;
import com.klaus.demographdcmeta.service.SchemaInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.api SchemaInfoController
 * @description:
 * @date 2019/5/2 02:06
 */

@RestController
@RequestMapping("/schema")
@Api(value = "Schema Info API", tags = "module-schema-info")
@Slf4j
public class SchemaInfoController {

    @Autowired
    private SchemaInfoService infoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "findSchemaInfo", notes = "get schema by id")
    public ResponseEntity<SchemaInfo> findSchemaInfo(@PathVariable(value = "id", required = true) Long id) {
        log.info("params id is :{}", id);
        Optional<SchemaInfo> optional = infoService.getSchemaInfoById(id);
        if(optional.isPresent()) {
            log.info("params id is :{}", optional.get());
            return ResponseEntity.ok().body(optional.get());
        }
        return ResponseEntity.ok().body(null);
    }


    @PostMapping
    @ApiOperation(value = "saveOrUpdateSchemaInfo", notes = "get schema by id")
    public ResponseEntity<SchemaInfo> saveOrUpdateSchemaInfo(@RequestBody SchemaQo schemaQo) {
        SchemaInfo schemaInfo = new SchemaInfo();
        schemaInfo.setRemark(schemaQo.getRemark());
        schemaInfo.setName(schemaQo.getName());
        schemaInfo.setCode(schemaQo.getCode());
        log.info("param is :{}", schemaInfo);
        return ResponseEntity.ok().body(infoService.saveSchemaInfo(schemaInfo));
    }









}
