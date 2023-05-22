package com.evinci.courseAchievement.response;

public enum ResponseMsg {
    SUCCESS("200", "Operation successful"),
    FAILED("500", "Operation failed"), // 500 means Internal Server Error
    PARAM_ERROR("400", "Parameter error!"),  // 400 means Bad Request
    FILE_EMPTY("422", "Uploaded file is empty");

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
