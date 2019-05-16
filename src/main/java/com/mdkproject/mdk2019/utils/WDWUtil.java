package com.mdkproject.mdk2019.utils;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-19 11:08
 * @Description:判断文件类型的工具类
 * @Version 1.0
 */

/**
 * 工具类验证Excel文档
 */
public class WDWUtil {

    /**
     * @描述：是否是2003的excel，返回true是2003
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * @描述：是否是2007的excel，返回true是2007
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证是否是EXCEL文件
     * @param filePath
     * @return
     */
    public static boolean validateExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
            return false;
        }
        return true;
    }

}
