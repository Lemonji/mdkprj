package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.controller.viewobject.AreaVO;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.AreaService;
import com.mdkproject.mdk2019.services.model.AreaModel;
import com.mdkproject.mdk2019.utils.MyTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-03-27 14:14
 * @Description:区域模块
 * @Version 1.0
 */

@RequestMapping("/area")
@Controller
@CrossOrigin(origins = {"*"},allowCredentials = "true")//解决跨域请求
public class AreaController extends BaseController{
    @Autowired
    private AreaService areaService;


    //添加区域
    @RequestMapping(value = "/add",method = {RequestMethod.POST},consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonReturnType add(@RequestParam(name = "areaname")String areaname,
                                @RequestParam(name = "areanum")String areanum) throws BusinessException {


        //入参非空校验
        if(StringUtils.isEmpty(areaname)||StringUtils.isEmpty(areanum)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //模型
        AreaModel areaModel = new AreaModel();
        areaModel.setAreaName(areaname);
        areaModel.setAreaNum(areanum);
        //string格式有要求，必须是yyyy-MM-dd hh:mm:ss
        areaModel.setCreateTime(MyTools.getTime());
        areaModel.setUpdateTime(MyTools.getTime());
        areaModel.setCreateby("admin");
        AreaModel areaModelReturn = areaService.addArea(areaModel);

        //返回给前端可查看的信息
        AreaVO areaVO = this.convertAreaVOFromAreaModel(areaModelReturn);
        return CommonReturnType.createCommonReturnType(areaVO);
    }

    //详情查看
    @RequestMapping(value = "/getarea", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getArea( @RequestBody @RequestParam(name = "aredId") Integer aredId){
        AreaModel areaModel = areaService.getAreaById(aredId);
        //模型转换
        AreaVO areaVO = this.convertAreaVOFromAreaModel(areaModel);
        return CommonReturnType.createCommonReturnType(areaVO);
    }

    //区域列表
    @RequestMapping(value = "/listArea", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType listArea(){
        List<AreaModel> areaModelList = areaService.listArea();

        //使用stream api 将list内的areamodel 转化为areavo给用户看
        List<AreaVO> areaVOList = areaModelList.stream().map(areaModel -> {
            //把model > vo
            AreaVO areaVO = this.convertAreaVOFromAreaModel(areaModel);
            return areaVO;
        }).collect(Collectors.toList());
        return CommonReturnType.createCommonReturnType(areaVOList);
    }

    @GetMapping("/test")
    public String test(){
    System.out.println("有请求来了");
    return "连接成功";
    }

    //返回给前端
    private AreaVO convertAreaVOFromAreaModel(AreaModel areaModel){
        if (areaModel==null){
            return null;
        }
        AreaVO areaVO = new AreaVO();
        BeanUtils.copyProperties(areaModel,areaVO);
        return areaVO;
    }

}
