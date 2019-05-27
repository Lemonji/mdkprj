package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TbPublicinfoDao;
import com.mdkproject.mdk2019.entity.TbPublicinfo;
import com.mdkproject.mdk2019.services.PublicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PubInfoServiceimpl implements PublicInfoService {

    @Autowired
    private TbPublicinfoDao publicinfo;

    public List<TbPublicinfo> findthreeinfo(){
        return publicinfo.findthreeinfo();
    }
}
