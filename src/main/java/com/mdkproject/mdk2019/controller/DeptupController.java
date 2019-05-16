package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.entity.TbDeptup;
import com.mdkproject.mdk2019.services.DeptupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deptup")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class DeptupController {

    @Autowired
    private DeptupService deptupService;

    //查询审核结果
    @PostMapping("/getres")
    public List<TbDeptup> getres(@RequestParam(required = false) int status,
                                @RequestParam int pagenum){
        return deptupService.getorderres(status,pagenum);
    }

    //修改审核结果
    //@GetMapping("updatestatus")
    //public int updatestatus(int deptid,int status){
        //return deptupService.updatestatus(deptid,status);
    //}

    @GetMapping("/test/{id}")
    public int test(@PathVariable int id){
        return id;
    }
}
