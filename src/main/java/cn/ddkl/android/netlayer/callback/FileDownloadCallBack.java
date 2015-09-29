package cn.ddkl.android.netlayer.callback;

/**
 * Created by Administrator on 2015/9/23.
 */
public interface FileDownloadCallBack {

    void onError(Exception e);
    void onSuccess(String filePath);

}
