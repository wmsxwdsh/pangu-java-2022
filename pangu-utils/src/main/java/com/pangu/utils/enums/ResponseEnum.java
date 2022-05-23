package com.pangu.utils.enums;

/**
 * 响应枚举
 *
 * @author LZG
 * @date 2019/3/14
 */
public enum ResponseEnum {

    success("200", "success"),
    error("500", "error"),

    query_not_exist("IC0001", "查询不到此信息"),
    sign_fail("IC0002", "报文验签不通过"),
    param_blank("IC0003", "请求参数不能为空"),
    login_fail("IC0004", "请尝试重新登录！"),

    not_sufficient_funds("UN0001","余额不足，请先充值"),

    sms_code_error("MF0001", "验证码错误！"),
    update_gender("MF0002","已修改过性别，不可再次修改");


    private String code;
    private String msg;

    private ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}