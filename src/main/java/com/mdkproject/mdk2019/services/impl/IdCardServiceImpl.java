package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TbIdcardDao;
import com.mdkproject.mdk2019.entity.TbIdcard;
import com.mdkproject.mdk2019.services.IdCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdCardServiceImpl implements IdCardService {



    @Resource
    private TbIdcardDao tbIdcardDao;

    @Override
    public int insert(TbIdcard tbIdcard) {
        return tbIdcardDao.insert(tbIdcard);
    }

    public int insertSelective(TbIdcard record){
        return tbIdcardDao.insert(record);
    }

    @Override
    public TbIdcard selectByIdnum(String idnum) {
        return tbIdcardDao.selectByIdnum(idnum);
    }

    @Override
    public int deleteByPrimaryKey(Integer healthNum) {
        return tbIdcardDao.deleteByPrimaryKey(healthNum);
    }


    //批量插入
    @Override
    public boolean insertBatch(List<TbIdcard> list) {
        if (list.size()<0){
            return false;
        }
        try {
            tbIdcardDao.insertBatch(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //批量更新
    @Override
    public boolean updateBatch(List<TbIdcard> list2) {
        if (list2.size()<0){
            return false;
        }
        try {
            tbIdcardDao.Updatebatch(list2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TbIdcard> selectAll() {
        //tbIdcardDao.seletAll();


        return null;
    }
}
