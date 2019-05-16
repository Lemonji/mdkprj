package com.mdkproject.mdk2019.services;

/**
 * @Auther: Liberal-World
 * @Date: 2019-04-27 18:04
 * @Description:
 * @Version 1.0
 */
public interface DeptOrderInfoService {

    /**
     * 依据身份证号补全信息
     * @param idCard
     * @param photo 照片路径
     * @return
     */
    boolean updateByIdCard(String idCard,String photo);


}
