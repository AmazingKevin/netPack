package cn.ddkl.android.netlayer.netbean.implement4n;

import cn.ddkl.android.netlayer.netbean.interface4n.TestBean;

public class TestBeanImp implements TestBean {




    private String resultcode;
    private String reason;
    private ResultEntity result;
    private int error_code;

    @Override
    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void setResult(ResultEntity result) {
        this.result = result;
    }

    @Override
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String getResultcode() {
        return resultcode;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public ResultEntity getResult() {
        return result;
    }

    @Override
    public int getError_code() {
        return error_code;
    }



    @Override
    public String getExecuteStatus() {
        return null;
    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
