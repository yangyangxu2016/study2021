package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SoundbankResource;
import javax.validation.Valid;

/**
 * todo
 * author：xuyy
 * date：2021/3/2  6:18 下午
 */
@Api(tags = "indexController",value = "value")
@RestController
public class IndexController {

    @ApiOperation(value = "首页", notes = "测试备注")
    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @ApiOperation(value = "用户登录", notes = "测试备注")
    @PostMapping("/login")
    public User login(@RequestBody @Valid User user) {
        return user;
    }


    @RequestMapping("/signin")
    public void signin(@RequestBody String json) {
        System.out.println(json);
    }
}
