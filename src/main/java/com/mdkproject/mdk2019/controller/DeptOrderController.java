package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.controller.viewobject.DeptOrderVO;
import com.mdkproject.mdk2019.entity.DeptOrder;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.DeptOrderService;
import com.mdkproject.mdk2019.services.model.DeptOrderModel;
import com.mdkproject.mdk2019.utils.MyTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 09:22
 * @Description:单位预约模块
 * @Version 1.0
 */
@Controller
@RequestMapping("/deptorder")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class DeptOrderController extends BaseController {
    
    @Autowired
    private DeptOrderService deptOrderService;

    private Logger logger = LoggerFactory.getLogger(DeptOrderController.class);
    
    @RequestMapping(value = "/add",method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType add(@RequestParam(name = "deptOrganization")String deptOrganization,
                                @RequestParam(name = "deptName")String deptName,
                                @RequestParam(name = "deptCode")String deptCode,
                                @RequestParam(name = "deptTel")String deptTel) throws BusinessException {

        DeptOrderModel deptOrderModel = new DeptOrderModel();
        deptOrderModel.setDeptOrganization(deptOrganization);
        deptOrderModel.setDeptName(deptName);
        deptOrderModel.setDeptCode(deptCode);
        deptOrderModel.setDeptTel(deptTel);
        deptOrderModel.setCreateTime(MyTools.getTime());
        deptOrderModel.setUpdateTime(MyTools.getTime());

        DeptOrderModel deptOrderModelReturn = deptOrderService.deptorder(deptOrderModel);
        DeptOrderVO deptOrderVO = this.convertDeptOrderVOFromDeptOrderModel(deptOrderModelReturn);
        return CommonReturnType.createCommonReturnType(deptOrderVO);
    }


    /**
     * 多图片上传
     * 单位预约证件照图片上传
     */
    @RequestMapping(value = "/updateImg",method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType updateImg(@RequestParam(name = "uploadfile")MultipartFile[] files){
        List<String> paths = new ArrayList<>();
        String FILE_PATH = "F:\\file-service\\image";
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() && !file.isDirectory()){
                System.out.println("目录不存在");
                file.mkdirs();//新建一个目录
            }
            //判断file数组不能为空并且长度大于0
            if (files != null && files.length>0){
                //循环取数组中的文件
                for (int i = 0; i<files.length; i++){
                    MultipartFile multipartFile = files[i];
                    //获取文件名
                    String originalFilename = multipartFile.getOriginalFilename();
                    if (!originalFilename.trim().equals("")){
                       String fileNmae = MyTools.getDateR()+".jpg";
                        Path filePath = Paths.get(FILE_PATH+fileNmae);
                        Files.write(filePath,multipartFile.getBytes());
                        paths.add(fileNmae);
                    }
                }

            }
        }catch (Exception e){
            logger.info("添加照片错误"+e);
        }
        return CommonReturnType.createCommonReturnType(paths);
    }


    //返回给前端,内容可控
    private DeptOrderVO convertDeptOrderVOFromDeptOrderModel(DeptOrderModel deptOrderModel){
        if (deptOrderModel==null){
            return null;
        }
        DeptOrderVO deptOrderVO = new DeptOrderVO();
        BeanUtils.copyProperties(deptOrderModel,deptOrderVO);
        return deptOrderVO;
    }

    //查询当日体检预约单位个数
    @GetMapping("/dayordernum")
    @ResponseBody
    public int dayordernum(){
        return deptOrderService.dayordernum();
    }


    //查询最近一周预约单位个数
    @GetMapping("/weektjnum")
    @ResponseBody
    public List<DeptOrder> weektjnum(){
        return deptOrderService.weektjnum();
    }
}
