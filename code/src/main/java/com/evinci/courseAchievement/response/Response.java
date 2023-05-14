package com.evinci.courseAchievement.response;

public class Response {
    /** 返回信息码 */
    private final String rspCode;
    /** 返回信息内容 */
    private final String rspMsg;

    protected Response(String rspCode, String rspMsg){
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public static Response of(ResponseMsg msg) {
        return new Response(msg.getCode(), msg.getMsg());
    }

    public static Response of(String rspCode, String rspMsg) {
        return new Response(rspCode, rspMsg);
    }

    public String getRspCode() {
        return rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
}
