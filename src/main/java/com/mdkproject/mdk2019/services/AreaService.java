package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.AreaModel;

import java.util.List;

public interface AreaService {
    //新增区域
    AreaModel addArea(AreaModel areaModel) throws BusinessException;

    //区域详情
    AreaModel getAreaById(Integer areaId);

    //区域列表
    List<AreaModel> listArea();


}
