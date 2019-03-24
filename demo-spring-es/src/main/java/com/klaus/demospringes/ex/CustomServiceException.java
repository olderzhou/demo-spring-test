package com.klaus.demospringes.ex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.ex CustomServiceException
 * @description:
 * @date 2019/3/25 02:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomServiceException extends Throwable {
    private String code;
    private String message;
}
