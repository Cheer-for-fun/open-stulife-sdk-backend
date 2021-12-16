package com.alibaba.service.impl;

import com.alibaba.bean.RequirementTable;
import com.alibaba.bean.Result;
import com.alibaba.mapper.RequirementTableMapper;
import com.alibaba.service.RequirementMeetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ModestYjx
 * @Project: open-stulife-sdk
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/12/10 10:18
 */
@Service
public class RequirementMeetServiceImpl implements RequirementMeetService {

    @Resource
    private RequirementTableMapper requirementTableMapper;

    @Override
    public Result findAll() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<RequirementTable> requirementMeetList = requirementTableMapper.selectAll();
            result.setDetail(requirementMeetList);
        }catch (Exception e)
        {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findRequirementById(Long requirementMeetId){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            RequirementTable requirementMeet = requirementTableMapper.selectByPrimaryKey(requirementMeetId);
            result.setDetail(result);
        }catch (Exception e)
        {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deteleRequirementById(Long requirementMeetId){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            requirementTableMapper.deleteByPrimaryKey(requirementMeetId);
            result.setMsg("删除成功");
        }catch (Exception e)
        {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateRequirement(RequirementTable requirementMeet){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            requirementTableMapper.insert(requirementMeet);
            result.setMsg("更新需求成功！");
        }catch (Exception e)
        {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
