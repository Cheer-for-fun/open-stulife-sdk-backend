package com.alibaba.controller;

import com.alibaba.bean.Result;
import com.alibaba.bean.UserBodyTable;
import com.alibaba.service.impl.UserLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yuyizhe
 * Created on 2021-12-10
 * @describe 登录注册
 */

@RestController
@Api(tags = "用户登录 注册")
public class UserLogInController {

    //定义一个用户服务类
    @Autowired
    private UserLogServiceImpl userLogService;

    @ApiOperation(value = "发送邮箱验证码")
    @GetMapping(value = "/sendMail")
    public Result sendMail(@ApiParam(name = "mail", value = "发送人邮箱") @RequestParam String mail) throws EmailException {
        return userLogService.mailSend(mail);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/sendLogIn")
    public Result userLogIn(@RequestBody UserBodyTable userBodyTable, @ApiParam(name = "mailVertify", value = "邮箱验证码", required = true) @RequestParam String mailVertify) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userLogService.userLogIn(userBodyTable, mailVertify);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/sendLogUp")
    public Result sendLogUp(@RequestBody UserBodyTable userBodyTable) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userLogService.userSignUp(userBodyTable);
    }
}
