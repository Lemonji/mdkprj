package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TbDeptupDao;
import com.mdkproject.mdk2019.entity.TbDeptup;
import com.mdkproject.mdk2019.services.DeptupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptupServiceImpl implements DeptupService {
    @Autowired
    private TbDeptupDao deptupDao;


    @Override
    public List<TbDeptup> getorderres(int status,int pagenum) {
        int page=(pagenum-1)*10;
        return deptupDao.getorderres(status,page);
    }

    @Override
    public int updatestatus(int deptid,int status) {
        return deptupDao.updateStatus(deptid,status);
    }
}
