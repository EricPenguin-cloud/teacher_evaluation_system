package com.cqgcxy.tes.Response;

public class Response {
    public Response(int flag,Object result){
        this.flag = flag;
        this.result = result;
    }
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private int flag;//0,1

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    private Object result;
}
