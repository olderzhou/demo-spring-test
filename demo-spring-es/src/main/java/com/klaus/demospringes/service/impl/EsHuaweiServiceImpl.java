package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.service.EsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl EsHuaweiServiceImpl
 * @description:
 * @date 2019/3/25 10:19
 */
@Service
@Profile({"huawei"})
public class EsHuaweiServiceImpl implements EsService {
    @Override
    public String info() {
        return null;
    }
}
