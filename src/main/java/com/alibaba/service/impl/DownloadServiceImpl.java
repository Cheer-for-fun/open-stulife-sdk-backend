package com.alibaba.service.impl;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.bean.CsdnDownload;
import com.alibaba.bean.Result;
import com.alibaba.mapper.DownloadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DownloadServiceImpl {

    @Resource
    private DownloadMapper downloadMapper;

    public Result downloadFile(CsdnDownload csdnDownload) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            downloadMapper.download(csdnDownload);
            System.out.println(csdnDownload.getId());
            result.setMsg("提交成功，1个工作日之内发送完毕。");
            result.setSuccess(true);
            result.setDetail(csdnDownload);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
