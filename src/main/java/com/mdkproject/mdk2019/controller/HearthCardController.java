package com.mdkproject.mdk2019.controller;


import com.mdkproject.mdk2019.controller.viewobject.HearthCardVO;
import com.mdkproject.mdk2019.entity.HearthCard;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.error.EmBusinessError;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.HearthCardService;
import com.mdkproject.mdk2019.services.model.HealthCardModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-02 17:13
 * @Description:
 * @Version 1.0
 */
@Controller
@RequestMapping("/healthcard")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class HearthCardController{

    @Autowired
    private HearthCardService hearthCardService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    //健康证查询
    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType get(@RequestParam(name = "idCard")String idCard,
                                @RequestParam(name = "telphone")String telphone,
                                @RequestParam(name = "otpCode")String otpCode) throws BusinessException {

        //入参非空校验
        if(StringUtils.isEmpty(idCard)|| StringUtils.isEmpty(telphone) || StringUtils.isEmpty(otpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //redis中的key是否存在
        if (!redisTemplate.hasKey(telphone)){
           throw new BusinessException(EmBusinessError.CODE_ERROR);
        }
        //获取redis缓存中的手机号key和验证码value
        String code = redisTemplate.opsForValue().get(telphone);
        System.out.println(code);
        if (code==null || "".equals(code)){
            throw new BusinessException(EmBusinessError.CODE_LOSE);
        }else{
            //删除缓存数据
            System.out.println("删除缓存数据");
            redisTemplate.delete(telphone);
        }

        //验证手机号和对应的验证码相符合
        System.out.println(code);
        if (!StringUtils.equals(otpCode,code)){
            throw new BusinessException(EmBusinessError.CODE_ERROR);
        }
        //返回
        HealthCardModel healthCardModel = hearthCardService.getHealthCard(idCard);
        HearthCardVO hearthCardVO = this.convertHCVOFromHCModel(healthCardModel);
        return CommonReturnType.createCommonReturnType(hearthCardVO);
    }


    /**
     *  健康证查询
     *  安卓端接口
     */
    @RequestMapping(value = "/getHearthCard",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getHearthCard(@RequestParam(value = "idCard",required = false)String idCard) throws BusinessException {
        if (StringUtils.isEmpty(idCard)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //返回
        HealthCardModel healthCardModel = hearthCardService.getHealthCard(idCard);
        HearthCardVO hearthCardVO = this.convertHCVOFromHCModel(healthCardModel);
        return CommonReturnType.createCommonReturnType(hearthCardVO);
    }


    @GetMapping("/test")
    @ResponseBody
    public CommonReturnType test(){
    System.out.println("success");
    return CommonReturnType.createCommonReturnType("succes");
    }


    @GetMapping("/daycardnum")
    @ResponseBody
    public int daycardnum(){
        return hearthCardService.daycardnum();
    }




    //返回给前端model-->vo
    private HearthCardVO convertHCVOFromHCModel(HealthCardModel healthCardModel){
        if (healthCardModel==null){
            return null;
        }
        HearthCardVO hcvo = new HearthCardVO();
        BeanUtils.copyProperties(healthCardModel,hcvo);
        return hcvo;
    }


    //查询最近一周发证的数量
    @GetMapping("/weektjnum")
    @ResponseBody
    public List<HearthCard> weektjnum(){
        return hearthCardService.weektjnum();
    }


}
