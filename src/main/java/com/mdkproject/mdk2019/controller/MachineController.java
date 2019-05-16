package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machinecode")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/add")
    public int addmachine(){
        int sum=0;
        for(int i=0;i<10;i++){
            try {
                machineService.addmachine();
                sum++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    @PostMapping("/activeMachine")
    public int activeMachine(@RequestParam String code){
        /*TbMachinecode machinecode=new TbMachinecode();
        String date= SimpledateUtil.getSimpledate();
        machinecode.setActivetime(date);
        machinecode.setActivedept(deptname);
        machinecode.setStatus(Integer.parseInt(status));*/
        return machineService.activeMachine(code);
    }

    /*@GetMapping("/firstid")
    public int  getfirstid(){
        return machineService.findFirstId();
    }*/

    @GetMapping("/test")
    public int test(){
        return 0;
    }

}
