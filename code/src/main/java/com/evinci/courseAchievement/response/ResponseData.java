package com.evinci.courseAchievement.response;

public class ResponseData extends Response {
    private Object data;

    private ResponseData(Response response, Object data) {
        super(response.getRspCode(), response.getRspMsg());
        this.data = data;
    }

    public static ResponseData of(Response response, Object data) {
        return new ResponseData(response, data);
    }

    public static ResponseData of(ResponseMsg msg, Object data) {
        return new ResponseData(Response.of(msg), data);
    }

    public static ResponseData of(String rspCode, String rspMsg, Object data) {
        return new ResponseData(Response.of(rspCode, rspMsg), data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
}
