package com.mdkproject.mdk2019.error;


public enum EmBusinessError implements CommonError {

    //定义通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),


    //20000开头为用户信息相关错误
    USER_NOT_EXIT(20001,"用户不存在"),
    USER_LOGIN_FAIL(20002,"账号或密码不正确"),
    USER_NOT_LOGIN(20003,"用户还未登录"),


    //30000开头验证码错误
    CODE_ERROR(30001,"验证码错误"),
    CODE_LOSE(30002,"验证码已失效"),
    CODE_EXCEED(30003,"发送次数超过限制"),
    CODE_GET_ERROR(30004,"验证码获取失败"),

    //40000开头vikey错误信息
    VIKEY_NOT_EXIT(40001,"系统没有检测出ViKey"),
    VIKEY_NOT_ERROR(40002,"插入ViKey数量过多"),
    VIKEY_NOT_CODE(40003,"ViKey读取失败"),
    VIKEY_ERROR(40004,"ViKey检测失败，请确认ViKey"),

    //50000开头操作权限错误信息
    ROLE_NOT_EXIT(50001,"角色不存在"),
    ROLE_NOT_MANAGE(50002,"没有操作权限"),






    ;

    private EmBusinessError(Integer errCode,String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }

    private Integer errCode;
    private String errMsg;

    @Override
    public Integer getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg=errMsg;
        return this;
    }
}
