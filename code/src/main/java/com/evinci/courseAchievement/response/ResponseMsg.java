package com.evinci.courseAchievement.response;

public enum ResponseMsg {
    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"), // 500表示服务器内部错误
    PARAM_ERROR("400", "参数错误！"),  // 400表示客户端请求的语法错误
    FILE_EMPTY("400", "上传文件为空");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
