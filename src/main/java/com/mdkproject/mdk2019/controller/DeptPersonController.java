package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.controller.viewobject.DeptPersonVO;
import com.mdkproject.mdk2019.error.BusinessException;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.DeptPersonService;
import com.mdkproject.mdk2019.services.model.DeptPersonModel;
import com.mdkproject.mdk2019.utils.MyTools;
import net.sf.json.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-03 11:49
 * @Description:单位人员录入
 * @Version 1.0
 */
@Controller
@RequestMapping("/deptperson")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class DeptPersonController{
    @Autowired
    private DeptPersonService deptPersonService;

    @RequestMapping(value = "/add",method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType add(@RequestParam(name = "deptName")String deptName,
                                @RequestParam(name = "deptCode")String deptCode,
                                @RequestParam(name = "deptPname")String deptPname,
                                @RequestParam(name = "deptGender")String deptGender,
                                @RequestParam(name = "deptIdcard")String deptIdcard,
                                @RequestParam(name = "deptPhone")String deptPhone) throws BusinessException {

        DeptPersonModel deptPersonModel = new DeptPersonModel();
        deptPersonModel.setDeptName(deptName);
        deptPersonModel.setDeptCode(deptCode);
        deptPersonModel.setDeptPname(deptPname);
        deptPersonModel.setDeptGender(deptGender);
        deptPersonModel.setDeptIdcard(deptIdcard);
        deptPersonModel.setDeptPhone(deptPhone);
        deptPersonModel.setCreateTime(MyTools.getTime());
        deptPersonModel.setUpdateTime(MyTools.getTime());

        DeptPersonModel deptPersonModel1 = deptPersonService.add(deptPersonModel);
        DeptPersonVO deptPersonVO = this.convertDeptPersonVOFromDeptPersonModel(deptPersonModel1);
        return CommonReturnType.createCommonReturnType(deptPersonVO);
    }


    //批量录入
    @RequestMapping(value = "/all",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType all(@RequestBody Map<String, Object> map, HttpServletRequest request) throws BusinessException {
        List<DeptPersonModel> list = new ArrayList<>();
        Object user = map.get("user");          //key-value
        JSONArray jsonArray = JSONArray.fromObject(user);
        System.out.println(jsonArray);

        for(int i=0;i<jsonArray.size();i++){
            DeptPersonModel deptPersonModel = new DeptPersonModel();
            String deptName = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptName");
            String deptCode = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptCode");
            String deptPname = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptPname");
            String deptGender = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptGender");
            String deptIdcard = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptIdcard");
            String deptPhone = JSONObject.parseObject(JSONObject.toJSONString(jsonArray.get(i))).getString("deptPhone");

            deptPersonModel.setDeptName(deptName);
            deptPersonModel.setDeptCode(deptCode);
            deptPersonModel.setDeptPname(deptPname);
            deptPersonModel.setDeptGender(deptGender);
            deptPersonModel.setDeptIdcard(deptIdcard);
            deptPersonModel.setDeptPhone(deptPhone);
            deptPersonModel.setCreateTime(MyTools.getTime());
            deptPersonModel.setUpdateTime(MyTools.getTime());
            list.add(deptPersonModel);
        }
        //批量新增
        deptPersonService.insertList(list);
        return CommonReturnType.createCommonReturnType(null);
    }




    //单位人员列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonReturnType list(){
        List<DeptPersonModel> deptPersonModelList = deptPersonService.listDeptPerson();
        //使用steam api将list内的model-->vo给用户
        List<DeptPersonVO> personVOList = deptPersonModelList.stream().map(deptPersonModel -> {
            DeptPersonVO deptPersonVO = this.convertDeptPersonVOFromDeptPersonModel(deptPersonModel);
            return deptPersonVO;
        }).collect(Collectors.toList());
        return CommonReturnType.createCommonReturnType(personVOList);
    }




    //领域模型model-->vo
    private DeptPersonVO convertDeptPersonVOFromDeptPersonModel(DeptPersonModel deptPersonModel){
        if (deptPersonModel==null){
            return null;
        }
        DeptPersonVO deptPersonVO = new DeptPersonVO();
        BeanUtils.copyProperties(deptPersonModel,deptPersonVO);
        return deptPersonVO;
    }

}
