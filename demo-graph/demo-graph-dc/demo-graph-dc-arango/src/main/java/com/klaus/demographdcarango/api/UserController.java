package com.klaus.demographdcarango.api;

import com.klaus.demographdcarango.model.User;
import com.klaus.demographdcarango.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.api UserController
 * @description:
 * @date 2019/5/2 04:14
 */


@RestController
@RequestMapping("/user")
@Api(tags = "User-Controller Module")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{mobile}")
    @ApiOperation(notes = "find user by mobile", value = "findUserByMobile")
    public ResponseEntity<User> findUserByMobile(@PathVariable(name = "mobile") String  mobile) {

        Optional<User> optionalUser = userService.findUserByMobile(mobile);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().body(optionalUser.get());
        }

        return ResponseEntity.ok(null);
    }



}
