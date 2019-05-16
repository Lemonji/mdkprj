package com.mdkproject.mdk2019.controller;

import com.mdkproject.mdk2019.entity.DeptOrderExcel;
import com.mdkproject.mdk2019.response.CommonReturnType;
import com.mdkproject.mdk2019.services.DeptOrderExcelService;
import com.mdkproject.mdk2019.services.DeptOrderInfoService;
import com.mdkproject.mdk2019.utils.ExcelUtil;
import com.mdkproject.mdk2019.utils.MyTools;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-19 10:39
 * @Description: 预约单位信息excel表导入
 * @Version 1.0
 */
@Controller
@RequestMapping("/excel")
public class DeptOrderExcelController extends BaseController{

    @Autowired
    private DeptOrderExcelService deptOrderExcelService;
    @Autowired
    private DeptOrderInfoService deptOrderInfoService;


    /**
     * 导入Excep表格
     * @return
     */
    @RequestMapping(value = "inExcel",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType toExcel(MultipartFile excel){
        if (excel.isEmpty()){//说明文件不为空
            try {
                String fileName = excel.getOriginalFilename();
                InputStream is = excel.getInputStream(); //转化为流的形式
                List<DeptOrderExcel> list = new ArrayList<>();
                List<Row> rowList = ExcelUtil.getExcelRead(fileName, is, true);
                //首先是读取行 也就是一行一行读，然后在取到列，遍历行里面的行，根据行得到列的值
                for (Row row:rowList){
                    //得到每个元素的值start
                    Cell cell_0 = row.getCell(0);
                    Cell cell_1 = row.getCell(1);
                    Cell cell_2 = row.getCell(2);
                    Cell cell_3 = row.getCell(3);
                    Cell cell_4 = row.getCell(4);
                    Cell cell_5 = row.getCell(5);
                    Cell cell_6 = row.getCell(6);
                    Cell cell_7 = row.getCell(7);
                    Cell cell_8 = row.getCell(8);
                    Cell cell_9 = row.getCell(9);
                    Cell cell_10 = row.getCell(10);
                    Cell cell_11 = row.getCell(11);
                    //得到每个元素的值end

                    //解析每个元素的值start
                    String deptName = ExcelUtil.getValue(cell_0);       //单位
                    String deptCode = ExcelUtil.getValue(cell_1);       //单位统一征信代码
                    String hostpitalCode = ExcelUtil.getValue(cell_2);  //体检机构
                    String pName = ExcelUtil.getValue(cell_3);          //姓名
                    String pSex = ExcelUtil.getValue(cell_4);           //性别
                    String pAge = ExcelUtil.getValue(cell_5);           //年龄
                    String pIdcard = ExcelUtil.getValue(cell_6);        //身份证号
                    String pPhoto = ExcelUtil.getValue(cell_7);         //照片
                    String status = ExcelUtil.getValue(cell_8);         //状态
                    String pTelphone = ExcelUtil.getValue(cell_9);      //手机号
                    String createTime = ExcelUtil.getValue(cell_10);     //创建时间
                    String updateTime = ExcelUtil.getValue(cell_11);     //更新时间
                    //解析每个元素的值end

                    //将读取出来的数值进行包装start
                    DeptOrderExcel deptOrderExcel = new DeptOrderExcel();
                    deptOrderExcel.setDeptName(deptName);
                    deptOrderExcel.setDeptCode(deptCode);
                    deptOrderExcel.setHostpitalCode(hostpitalCode);
                    deptOrderExcel.setpName(pName);
                    deptOrderExcel.setpSex(pSex);
                    deptOrderExcel.setpAge(Integer.valueOf(pAge));
                    deptOrderExcel.setpIdcard(pIdcard);
//                    deptOrderExcel.setpPhoto(pPhoto);
                    deptOrderExcel.setStatus("未审核");
                    deptOrderExcel.setpTelphone(pTelphone);
                    deptOrderExcel.setCreateTime(MyTools.getTime());
                    deptOrderExcel.setUpdateTime(MyTools.getTime());
                    list.add(deptOrderExcel);
                    //将读取出来的数值进行包装end
                }
                if (list.size()>0){
                    for (DeptOrderExcel item:list){
                        deptOrderExcelService.insertDeptOrderExcel(item);
                    }
                }
                return CommonReturnType.createCommonReturnType("导入成功");
            }catch (Exception e){
                e.printStackTrace();
                return CommonReturnType.createCommonReturnType("导入出现异常");
            }
        }else {
            return CommonReturnType.createCommonReturnType("导入文件为空");
        }
    }



    @RequestMapping("test")
    @ResponseBody
    public String test(String idCard,String photo){
        boolean b = deptOrderInfoService.updateByIdCard(idCard, photo);
        if (b){
            return "success";
        }
        return "false";

    }






}
