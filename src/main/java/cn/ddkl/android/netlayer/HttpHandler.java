package cn.ddkl.android.netlayer;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

import java.io.File;
import java.util.Map;

import cn.ddkl.android.debug.W;
import cn.ddkl.android.netlayer.callback.FileDownloadCallBack;
import cn.ddkl.android.netlayer.callback.NetCallBack;
import cn.ddkl.android.netlayer.engine.NetEngine;
import cn.ddkl.android.netlayer.engine.NetImageLoader;
import cn.ddkl.android.netlayer.engine.OkHttpEngine;
import cn.ddkl.android.netlayer.engine.UniversalImageLoader;
import cn.ddkl.android.netlayer.netbean.NetBeanType;
import cn.ddkl.android.utils.Context.CX;
import cn.ddkl.android.utils.NetUtil;
import cn.ddkl.android.utils.ToastUtil;
import cn.ddkl.android.utils.cache.CacheFileDirUtil;

/**
 * net层直接提供数据接口
 */
public class HttpHandler {

    /**
     * 单例
     */
    private static HttpHandler instance=new HttpHandler();
    private HttpHandler(){
    }
    public static HttpHandler getInstance()
    {
        return instance;
    }

    private static NetEngine engine;
    private static NetImageLoader netImageLoader;



    //初始化最好在application中初始化

    /**
     *
     * @param context 初始放入的application参数
     * @return
     */
    public static HttpHandler init(Context context)
    {
        CX.context=context;
        ToastUtil.mHander=new Handler();
        engine=new OkHttpEngine();
        netImageLoader=new UniversalImageLoader(context);

        return instance;
    }



    /**
     *
     * @param tag 请求的tag，标识该次请求
     * @param type 返回枚举的类型
     * @param map 返回参数的集合
     * @param callBack  回调
     * @param <T> 泛型必须与枚举中的一致，否则必然会有强行转换的错误
     */
    public  <T> void requestNetBean(String tag,NetBeanType type,Map<String,String> map,NetCallBack<T> callBack)
    {

        if(!NetUtil.isOpenNetwork())
        {
            //说明网络不是连接的
            ToastUtil.t("无法连接网络,请打开网络");
            return;
        }
        //参数传入一个具体的实现类，使用者根据，该类的代码改动不影响接口的使用
        engine.requestNetBean(tag, type, map, callBack);

    }


    /**
     * 任何一个数据bean对象直接使用这个api提交给服务器一个json字符串
     * @param tag 请求的tag，标识该次请求
     * @param type 返回枚举的类型
     * @param jsonObj 数据bean对象
     * @param callBack  回调
     * @param <T>  泛型必须与枚举中的一致，否则必然会有强行转换的错误
     */
    public <T> void postJson(String tag,NetBeanType type,Object jsonObj,final  NetCallBack<T> callBack) {

        if(!NetUtil.isOpenNetwork())
        {
            //说明网络不是连接的
            ToastUtil.t("无法连接网络,请打开网络");
            return;
        }

        engine.postJson(tag, type, jsonObj, callBack);

    }


    /**
     *根据网络请求的tag取消网络访问,需要与activity或者fragment的onDestroy方法中绑定   机制与注册广播接受者 取消注册广播接受者 相似
     * @param tag 申请网络请求时候打下的tag
     */
    public  void cancelNetVisitByTag(String tag)
    {
        engine.cancalByTag(tag);
    }

    //后期根据实际需求提供网络访问策略的方法


    /**
     * 网络访问图片
     * @param url       需要加载的网络地址
     * @param imageView 需要加载的imageView
     */
    public void displayNetImage(String url,ImageView imageView)
    {

        if(!NetUtil.isOpenNetwork())
        {
            //说明网络不是连接的
            ToastUtil.t("无法连接网络,请打开网络");
            return;
        }
        netImageLoader.displayImage(url, imageView);

    }

    /**
     *停止所有的图片加载任务,需要与activity或者fragment的onDestroy方法中绑定   机制与注册广播接受者 取消注册广播接受者 相似
     */
    public void stopDisplayNetImage()
    {
        netImageLoader.stopNetImageDisplay();
    }

    /**
     * 与展示图片相同,由于内存使用缓存,手动释放内存
     */
    public void clearNetImageMemoryCache()
    {
        netImageLoader.clearMemoryCache();
    }

    /**
     * 存放在硬盘中的缓存手动释放,如果用户硬盘内存过小,应该考虑经常使用
     */
    public void clearNetImageDiskCache()
    {
        netImageLoader.clearDiskCache();
    }



    /**
     *   这个api 是图片 文件都可以上传
     * @param tag 标识上传线程的tag
     * @param type 上传文件类型
     * @param file 上传文件目录
     * @param callBack 成功的回调
     * @param <T>  泛型必须与枚举中的一致，否则必然会有强行转换的错误
     */
    public <T> void uploadFile(String tag, NetBeanType type, File file, NetCallBack<T> callBack) {

        if(!NetUtil.isOpenNetwork())
        {
            //说明网络不是连接的
            ToastUtil.t("无法连接网络,请打开网络");
            return;
        }
        engine.uploadFile(tag, type, file,callBack);

    }

    /**
     *  可以使用这个api下载文件,图片
     * @param tag 用于标识下载文件
     * @param type
     * @param fileName
     * @param  callBack
     */
    public  void downloadFile(String tag,NetBeanType type,  String fileName,FileDownloadCallBack callBack) {

        if(!NetUtil.isOpenNetwork())
        {
            //说明网络不是连接的
            ToastUtil.t("无法连接网络,请打开网络");
            return;
        }


       File file=  new File(CacheFileDirUtil.getCacheFileDir(fileName));

        if(file.exists())
        {
            //文件已经下载过了,不需要下载
            W.w("Net", "downloadFile文件存在,不需要下载,直接返回");
            callBack.onSuccess(file.getAbsolutePath());
            //successDownloadListener.onSuccessDownload(file.getAbsolutePath());
            return;
        }

        W.w("Net","文件不存在,开始重新下载");
        engine.downloadFile(tag,type,fileName, callBack);

    }
}
