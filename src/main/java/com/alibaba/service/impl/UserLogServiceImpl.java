package com.alibaba.service.impl;

import com.alibaba.bean.Result;
import com.alibaba.bean.UserBodyTable;
import com.alibaba.mapper.UserBodyTableMapper;
import com.alibaba.service.SaltPassward;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

/**
 * @author yuyizhe
 * Created on 2021-12-10
 * @describe 用户登录和注册类
 */

@Service
public class UserLogServiceImpl {

    @Resource
    private UserBodyTableMapper userBodyTableMapper;

    //定义结果类
    private Result result = new Result();

    //实现加盐密码代码接口
    SaltPassward saltPassward = new SaltPassward() {
        @Override
        public String setSaltPassward(String passward, String userName) throws NoSuchAlgorithmException, UnsupportedEncodingException {

            //使用MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder encoder = Base64.getEncoder();

            //加密字符串(规则：将用户名和密码结合起来)
            String midPassward = passward+userName;
            String realPassward  = encoder.encodeToString(md5.digest(midPassward.getBytes("utf-8")));
            return realPassward;
        }
    };

    /**
     * 用户登录
     *
     * @param userBodyTable 用户账号和密码
     */
    public Result userSignUp(UserBodyTable userBodyTable) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        //将密码加密
        String realPassward = saltPassward.setSaltPassward(userBodyTable.getUsername(), userBodyTable.getPassword());
        //判断用户名和密码是否正确,返回结果
        UserBodyTable userBodyTable1 = userBodyTableMapper.selectByNameAndPassward(userBodyTable.getUsername(), realPassward);
        if(userBodyTable1 != null) {
            result.setSuccess(true);
            result.setMsg("用户登录成功！");
            result.setDetail(userBodyTable.getUsername());
        }
        else {
            result.setSuccess(false);
            result.setMsg("用户登录失败！");
            result.setDetail(null);
        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param userBodyTable 用户实体对象
     * @param mailVertifyCode 邮箱验证码
     */
    public Result userLogIn(UserBodyTable userBodyTable, String mailVertifyCode) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        //用户名需唯一，判断用户名是否存在。如果存在则返回null，不存在则存入数据库中
        UserBodyTable midUser = userBodyTableMapper.selectByUserName(userBodyTable.getUsername());
        if(midUser != null || mailVertify("q") == false) {
            result.setSuccess(false);
            result.setMsg("用户注册失败！");
            result.setDetail(null);
        }
        else {
            //获取当前时间
            Date date = new Date();   // 获取当前时间
            Date sql_date = new Date(date.getTime());
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:ss");
            String value = dateFormat.format(sql_date);

            //对密码加盐
            String realPassward = saltPassward.setSaltPassward(userBodyTable.getUsername(), userBodyTable.getPassword());
            userBodyTable.setPassword(realPassward);
            //对结果进行保存和返回
            userBodyTableMapper.insertByUserName(userBodyTable, value);
            result.setMsg("用户注册成功！");
            result.setSuccess(true);
            result.setDetail(userBodyTable.getUsername());
        }
        return result;
    }

    /**
     * 发送邮箱验证码
     *
     * @param mail 收件人邮箱
     */
    public Result mailSend(String mail) throws EmailException {

        //设置邮件的内容
        HtmlEmail email = new HtmlEmail();

        //创建一个HtmlEmail实例对象
        email.setHostName("smtp.163.com");

        //设置发送的字符类型
        email.setCharset("utf-8");

        //设置收件人
        email.addTo(mail);
        email.setFrom("yyzpku@163.com","bbser");
        email.setAuthentication("yyzpku@163.com","");

        //设置发送主题
        email.setSubject("bbs vertify");

        //生成一个随机数字
        Random random = new Random();
        int a = random.nextInt(900000)+100000;
        String pass = String.valueOf(a);

        //设置发送内容
        email.setMsg(pass);

        //进行发送,并包装result结果
        try {
            email.send();
            result.setMsg("短信验证码发送成功！");
            result.setSuccess(true);
            result.setDetail(null);
        } catch (EmailException e) {
            result.setMsg(e.getMessage());
            result.setSuccess(false);
            result.setDetail(null);
        }
        return result;
    }

    /**
     * 邮箱是否验证成功
     *
     * @param mailCode 收件人邮箱
     */
    public boolean mailVertify(String mailCode) {
        return true;
    }
}
