package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.TbMachinecodeDao;
import com.mdkproject.mdk2019.entity.TbMachinecode;
import com.mdkproject.mdk2019.services.MachineService;
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
            str+=(char)(Math.random()*26+'A');
        }
        TbMachinecode machine=new TbMachinecode();
        machine.setMachinecode(str);
        machine.setStatus(0);
        return machinecodeDao.insertSelective(machine);
    }

    @Override
    public TbMachinecode activeMachine(String machinecode) {
        return machinecodeDao.activeMachine(machinecode);
    }

    @Override
    public int updateTime(TbMachinecode machinecode) {
        return machinecodeDao.updateTime(machinecode);
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
