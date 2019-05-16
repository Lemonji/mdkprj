package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.controller.viewobject.TJProjectVO;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.TijianProjectService;
import com.mdkproject.mdk2019.services.model.TijianProjectModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-15 13:39
 * @Description: 体检项目模块
 * @Version 1.0
 */
@Controller
@RequestMapping("tjproject")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class TijianProjectController{
    @Autowired
    private TijianProjectService tijianProjectService;





    /**
     *  1.先查询有无病史
     *  2.体征项目
     *  3.X线项目
     *  4.实验室检验项目
     *  5.评判结论
     */
    @RequestMapping(value = "add",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType add(TijianProjectModel tijianProjectModel) throws BusinessException {
        tijianProjectService.add(tijianProjectModel);
        return CommonReturnType.createCommonReturnType(null);
    }


    /**
     * 根据体检人ID生成体检表
     */
    @RequestMapping(value = "get",method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType get(@RequestParam(name = "personIdcard")String personIdcard) throws BusinessException {
        //入参校验
        if (StringUtils.isEmpty(personIdcard)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Map tjTable = tijianProjectService.findByIdcard(personIdcard);
        return CommonReturnType.createCommonReturnType(tjTable);
    }




    private TJProjectVO convertVOFromModel(TijianProjectModel model){
        TJProjectVO vo = new TJProjectVO();
        BeanUtils.copyProperties(model,vo);
        return vo;
    }



}
