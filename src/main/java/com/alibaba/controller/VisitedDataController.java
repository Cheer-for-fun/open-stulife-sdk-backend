package com.alibaba.controller;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.service.VisitedDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-stulife-sdk/api")
@Api(tags = "访客信息")
public class VisitedDataController {
    @Autowired
    private VisitedDataService visitedDataService;

    @RequestMapping(value = "/index1")
    public String index() {
        System.out.println(visitedDataService.findAll());
        return "index";
    }
}
