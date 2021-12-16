package com.alibaba.service;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.bean.VisitedData;

import java.util.List;

public interface VisitedDataService {
    List<VisitedData> findAll();
}
