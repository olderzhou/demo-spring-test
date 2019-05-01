package com.klaus.demographdcmeta.config;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcmeta.config MySQL5InnoDBDialectUtf8mb4
 * @description:
 * @date 2019/5/2 00:59
 */
public class MySQL5DialectUtf8mb4 extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
    }
}
