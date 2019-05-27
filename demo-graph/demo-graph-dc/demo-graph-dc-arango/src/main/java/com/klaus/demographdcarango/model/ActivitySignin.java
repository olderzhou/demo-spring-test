package com.klaus.demographdcarango.model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.model Activity
 * @description:
 * @date 2019/5/21 19:29
 */

@Edge(value = "activity_signin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySignin {

    @From
    private Register from;
    @To
    private Activity to;
    private String label;
    private Date signinDt;
    private Date createDt;


}
