package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.TbMachinecode;

public interface MachineService {
    int addmachine();
    TbMachinecode activeMachine(String machinecode);
    int updateTime(TbMachinecode machinecode);
    //int findFirstId();
    //int updateTime(TbMachinecode machinecode);
}
