package com.it.controller;

import com.it.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hello/")
    public String hello(@RequestParam String message){
        return "hello"+message;
    }
    @PostMapping("/createUser")
    @ApiOperation("create an user")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",dataType="string", paramType = "query",example="xy2813"),
            @ApiImplicitParam(name="password",value="用户id",dataType="string", paramType = "query",example = "1234,qwer")})
    public User createUser(String username,  String password){
        return new User(username,password);
    }

}
