package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TbMachinecodeDao;
import com.mdkproject.mdk2019.entity.TbMachinecode;
import com.mdkproject.mdk2019.services.MachineService;
import com.mdkproject.mdk2019.utils.SimpledateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {
    @Autowired
    private TbMachinecodeDao machinecodeDao;

    @Override
    public int addmachine() {
        String str="";
        for(int i=0;i<8;i++){
            str+=(int)(Math.random()*10);
            str+=(char)(Math.random()*26+'a');
        }
        TbMachinecode machine=new TbMachinecode();
        /*try {
            machine.setMachinecode(MyMD5Util.getEncryptedPwd(str));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        machine.setMachinecode(str);
        machine.setStatus(0);
        return machinecodeDao.insertSelective(machine);
    }

    @Override
    public int activeMachine(String machinecode) {
        //int mcid=machinecodeDao.findFirstId();
        //machinecode.setId(mcid);
        TbMachinecode tbMachinecode=new TbMachinecode();
        tbMachinecode.setActivetime(SimpledateUtil.getSimpledate());
        tbMachinecode.setMachinecode(machinecode);
        machinecodeDao.updateTime(tbMachinecode);
        return machinecodeDao.activeMachine(machinecode);
    }

    /*@Override
    public int updateTime(TbMachinecode machinecode) {
        return 0;
    }*/

    /*@Override
    public int findFirstId() {
        return machinecodeDao.findFirstId();
    }*/
}
