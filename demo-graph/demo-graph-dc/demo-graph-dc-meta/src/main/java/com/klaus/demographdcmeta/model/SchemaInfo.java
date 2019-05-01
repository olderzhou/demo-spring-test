package com.klaus.demographdcmeta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.model SchemaInfo
 * @description:
 * @date 2019/5/1 04:06
 */


@Entity(name = "t_schema_info")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchemaInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name" , length = 128)
    private String name;

    @Column(name = "remark", columnDefinition = "")
    private String remark;

    @Column(name = "code", columnDefinition = "", unique = true)
    private String code;

    @CreatedDate
    @Column(name = "create_dt")
    private Date createDt;

    @LastModifiedDate
    @Column(name = "update_dt")
    private Date updateDt;

    @Column(name = "create_by")
    private Long createBy;

    @Column(name = "update_by")
    private Long updateBy;










}