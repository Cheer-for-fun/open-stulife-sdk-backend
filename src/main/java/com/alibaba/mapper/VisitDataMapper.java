package com.alibaba.mapper;

import com.alibaba.bean.VisitedData;

import java.util.List;

/**
 * @author yuyizhe
 * Created on 2021-12-12
 */
public interface VisitDataMapper {

    List<VisitedData> selectAll();

}
