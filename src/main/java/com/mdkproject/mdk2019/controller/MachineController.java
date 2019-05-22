package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.entity.TbMachinecode;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.MachineService;
import com.mdkproject.mdk2019.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machinecode")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/add")
    public CommonReturnType addmachine(){
        int sum=0;
        for(int i=0;i<10;i++){
            try {
                machineService.addmachine();
                sum++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CommonReturnType.createCommonReturnType(sum);
    }

    @PostMapping("/activeMachine")
    public CommonReturnType activeMachine(@RequestParam String code){
        TbMachinecode machine=machineService.activeMachine(code);
        if(machine==null){
           return CommonReturnType.createCommonReturnType("500","fail");
        }
        if(machine.getActivetime()==null){
            machine.setActivetime(MyTools.getTime());
            machineService.updateTime(machine);
            machine.setActivetime("ok");
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("status",machine.getStatus());
            jsonObject.put("time",machine.getActivetime());
            return CommonReturnType.createCommonReturnType(jsonObject);
        }else{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("status",machine.getStatus());
            jsonObject.put("time",machine.getActivetime());
            return CommonReturnType.createCommonReturnType(jsonObject);
        }
    }

    /*@GetMapping("/firstid")
    public int  getfirstid(){
        return machineService.findFirstId();
    }*/

    @GetMapping("/test")
    public int test(){
        return 0;
    }

    public static void main(String[] args) {
        TbMachinecode machine=new TbMachinecode();
        machine.setActivetime("ok");
        machine.setStatus(1);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",machine.getStatus());
        jsonObject.put("time",machine.getActivetime());
        System.out.println(jsonObject);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
    }

}
