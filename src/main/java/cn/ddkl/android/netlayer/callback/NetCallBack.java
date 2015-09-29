package cn.ddkl.android.netlayer.callback;

/**
 * Created by Administrator on 2015/9/23.
 */
public interface NetCallBack<T> {

    void onError(Exception e);
    void onException(String errorCode,String errorMsg);
    void onSuccess(T response);
}
