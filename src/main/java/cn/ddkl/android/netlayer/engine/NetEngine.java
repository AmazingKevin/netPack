package cn.ddkl.android.netlayer.engine;

import java.io.File;
import java.util.Map;

import cn.ddkl.android.netlayer.callback.FileDownloadCallBack;
import cn.ddkl.android.netlayer.callback.NetCallBack;
import cn.ddkl.android.netlayer.netbean.NetBeanType;

/**
 * Created by Administrator on 2015/9/18.
 */
public interface NetEngine {


    <T> void requestNetBean(String tag, NetBeanType type, Map<String, String> map, NetCallBack<T> callBack);
    <T>  void postJson(String tag,NetBeanType type,Object jsonObj,NetCallBack<T> callBack) ;
    <T> void uploadFile(String tag,NetBeanType type,File file,  NetCallBack<T> callBack);
    void cancalByTag(String tag);
    void downloadFile(String tag,NetBeanType type,   String fileName, FileDownloadCallBack callBack);
}
