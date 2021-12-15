package com.alibaba.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yuyizhe
 * Created on 2021-12-10
 * @describe 密码加盐类
 */

public interface SaltPassward {
    String setSaltPassward(String passward, String userName) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
