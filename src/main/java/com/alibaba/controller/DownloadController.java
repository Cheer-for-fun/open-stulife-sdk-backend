package com.alibaba.controller;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.bean.CsdnDownload;
import com.alibaba.bean.Result;
import com.alibaba.service.impl.DownloadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/open-stulife-sdk/api/download")
@Api(tags = "Download 业务")
public class DownloadController {

    @Autowired
    private DownloadServiceImpl downloadServiceImpl;

    @ApiOperation(value = "下载接口")
    @PostMapping(value = "/submit")
    public Result downloadFile(@RequestBody CsdnDownload download) {
        Date date = new Date();   // 获取当前时间
        Date sql_date = new Date(date.getTime());

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:ss");
        String value = dateFormat.format(sql_date);
        download.setSubmit_time(value);

        return downloadServiceImpl.downloadFile(download);
    }
}


