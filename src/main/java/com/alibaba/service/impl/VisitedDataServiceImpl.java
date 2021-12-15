package com.alibaba.service.impl;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.bean.VisitedData;
import com.alibaba.mapper.VisitDataMapper;
import com.alibaba.service.VisitedDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VisitedDataServiceImpl implements VisitedDataService {

    @Resource
    private VisitDataMapper visitDataMapper;

    @Override
    public List<VisitedData> findAll() {
        // 这里我们就可以直接使用 findAll 方法
        return visitDataMapper.selectAll();
    }
}
