package com.mdkproject.mdk2019.services;


import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.services.model.TijianProjectModel;

import java.util.Map;

//体检项目
public interface TijianProjectService {

    //添加
    TijianProjectModel add(TijianProjectModel tijianProjectModel) throws BusinessException;

    //体检表
    Map findByIdcard(String personIdcard) throws BusinessException;

}
