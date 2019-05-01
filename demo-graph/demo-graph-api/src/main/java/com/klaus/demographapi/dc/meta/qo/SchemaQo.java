package com.klaus.demographapi.dc.meta.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographapi.dc.meta.qo SchemaQo
 * @description:
 * @date 2019/5/1 04:05
 */
@ApiModel(value = "schema info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchemaQo {

    @ApiModelProperty(name = "name", value = "tv_klaus", notes = "名称")
    private String name;

    @ApiModelProperty(name = "remark", value = "tv_klaus", notes = "描述")
    private String remark;

    @ApiModelProperty(name = "code", value = "tv_klaus", notes = "编码")
    private String code;


}
