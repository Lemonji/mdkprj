package com.mdkproject.mdk2019.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {
//读取文件的方法
    /**
     * 获取解析文件行数据
     * @param fileName : 文件地址
     * @param isTitle  : 是否过滤第一行解析
     * @return
     * @throws Exception
     */
    public static List<Row> getExcelRead(String fileName, InputStream is, boolean isTitle) throws Exception{
        try {
            //判断其兼容版本 调用了判断版本的方法
            Workbook workbook = getWorkbook(fileName,is);
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            List<Row> list = new ArrayList<Row>();
            for (Row row : sheet) {
                // 跳过第一行的目录
                if (count == 0 && isTitle) {
                    count++;
                    continue;
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

//判断版本的方法

    public static Workbook getWorkbook(String fileName,InputStream is) throws Exception{
        Workbook workbook = null;
        try {
            /** 判断文件的类型，是2003还是2007 */
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }

            if (isExcel2003) {
                workbook = new HSSFWorkbook(is);
            } else {
                workbook = new XSSFWorkbook(is);
            }
        } catch (Exception e) {
            throw e;
        }
        return workbook;
    }

    //得到celL值的方法：
    public static String getValue(Cell cell){
        if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(cell.getBooleanCellValue());
        }else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            double value = cell.getNumericCellValue();
            return new BigDecimal(value).toString();
        }else if (cell.getCellType() ==HSSFCell.CELL_TYPE_STRING){
            return String.valueOf(cell.getStringCellValue());
        }else{
            return String.valueOf(cell.getStringCellValue());
        }
    }


    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }





}
