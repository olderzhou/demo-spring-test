package com.klaus.demospringes.ex;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.ex ApiResponse
 * @description:
 * @date 2019/3/25 02:08
 */
@Data
@Builder
public class ApiResponse {

    private HttpStatus status;
    private String error_code;
    private String message;
    private String detail;
    private String path;

}
