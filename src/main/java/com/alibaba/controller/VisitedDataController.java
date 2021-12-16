package com.alibaba.controller;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.service.VisitedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VisitedDataController {
    @Autowired
    private VisitedDataService visitedDataService;

    @RequestMapping(value = "/index1")
    public String index() {
        System.out.println(visitedDataService.findAll());
        return "index";
    }
}
