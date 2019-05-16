package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.AreaMapper;
import com.mdkproject.mdk2019.entity.Area;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.services.AreaService;
import com.mdkproject.mdk2019.services.model.AreaModel;
import com.mdkproject.mdk2019.validator.ValidationResult;
import com.mdkproject.mdk2019.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-27 14:16
 * @Description:
 * @Version 1.0
 */


@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private AreaMapper areaMapper;

    //新增
    @Override
    public AreaModel addArea(AreaModel areaModel) throws BusinessException {
        //入参校验
        ValidationResult result = validator.validate(areaModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        //转化areaModel ---> 实体entity
        Area area = this.convertAreaFromAreaModel(areaModel);

        //写入数据库
        areaMapper.insertSelective(area);
        areaModel.setAreaId(area.getAreaId());

        //返回创建的对象，在显示
        return this.getAreaById(areaModel.getAreaId());

    }



    //区域详情
    @Override
    public AreaModel getAreaById(Integer areaId) {
        Area area = areaMapper.selectByPrimaryKey(areaId);
        if (area==null){
            return null;
        }
        //entity ---> model
        AreaModel areaModel = this.convertModelFromEntity(area);
        return areaModel;
    }

    //区域列表
    @Override
    public List<AreaModel> listArea() {
        List<Area> areaList = areaMapper.listArea();
        //使用steam api 将list内的areamodel 转化为 areavo
        List<AreaModel> areaModelList = areaList.stream().map(area -> {
            //领域模型转化
            AreaModel areaModel = this.convertModelFromEntity(area);
            return areaModel;
        }).collect(Collectors.toList());
        return areaModelList;
    }


    //模型转化
    private Area convertAreaFromAreaModel(AreaModel areaModel){
        if (areaModel==null){
            return null;
        }
        Area area = new Area();
        BeanUtils.copyProperties(areaModel,area);
        return area;
    }

    //领域模型
    private AreaModel convertModelFromEntity(Area area){
        AreaModel areaModel = new AreaModel();
        BeanUtils.copyProperties(area,areaModel);
        return areaModel;
    }
}
