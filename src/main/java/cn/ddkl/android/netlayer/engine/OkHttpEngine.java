package cn.ddkl.android.netlayer.engine;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import cn.ddkl.android.netlayer.callback.FileDownloadCallBack;
import cn.ddkl.android.netlayer.callback.NetCallBack;
import cn.ddkl.android.netlayer.netbean.NetBean;
import cn.ddkl.android.netlayer.netbean.NetBeanType;
import cn.ddkl.android.utils.AppUtil;
import cn.ddkl.android.utils.cache.CacheFileDirUtil;


public class OkHttpEngine implements NetEngine{

    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
    private static final Gson mGson =  new Gson();
    private static final Handler handler=new Handler();

    static  {
        //todo 初始化配置时间长短
        mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);//连接时间长度
        mOkHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);//写的时间长度
        mOkHttpClient.setReadTimeout(30, TimeUnit.SECONDS);//读的时间长度


        int availableMemory = AppUtil.getAvailableMemory();

        ConnectionPool pool;
        if(availableMemory>120)
        {
            //如果可用内存大于120m
            pool=new ConnectionPool(20,9999);//z最多可用10个线程池,每个线程池最多连接9999
        }
        else
        {
            //如果可用内存小于120m
            pool=new ConnectionPool(5,9999);//z最多可用5个线程池,每个线程池最多连接9999
        }

        //设置默认的线程池
         mOkHttpClient.setConnectionPool(pool);


    }






    @Override
    public <T> void requestNetBean(String tag, NetBeanType type, Map<String, String> map, NetCallBack<T> callBack) {

        //参数非空处理
        if(TextUtils.isEmpty(tag) ||type==null||map==null|| callBack ==null)
        {
            throw new NullPointerException("input args should not been null");
        }

        //访问主url
        String url=type.getUrl();
        // 类
        Class clazz=type.getClazz();
        //参数处理
        String para= handlePara(map);
        url+=para;
        // 取消之前的请求
        mOkHttpClient.cancel(tag);
        //url和tag 构造request
        Request request = new Request.Builder().url(url).tag(tag).build();

        clientRequest(request, callBack, clazz);

    }


    @Override
    public <T> void postJson(String tag,NetBeanType type,Object jsonObj, NetCallBack<T> callBack) {

        //参数非空处理
        if(TextUtils.isEmpty(tag) ||type==null||jsonObj==null|| callBack ==null)
        {
            throw new NullPointerException("input args should not been null");
        }
        //访问url
        String url=type.getUrl();
        // 类
        Class clazz=type.getClazz();

        // 取消之前的请求
        mOkHttpClient.cancel(tag);

        RequestBody body = RequestBody.create(MIME.JSON, mGson.toJson(jsonObj));
        Request request = new Request.Builder().url(url).post(body).tag(tag).build();

        //请求
        clientRequest(  request, callBack, clazz);

    }


    /**
     * 图片和文件都可以上传
     * @param tag
     * @param type
     * @param file
     * @param callBack
     * @param <T>
     */
    public <T> void uploadFile(String tag,NetBeanType type,File file, NetCallBack<T> callBack) {

        //参数非空处理
        if(TextUtils.isEmpty(tag) ||type==null||file==null|| callBack ==null )
        {
            throw new NullPointerException("input args should not been null");
        }
        //访问url
        String url=type.getUrl();
        // 类
        Class clazz=type.getClazz();

        // 取消之前的请求
        mOkHttpClient.cancel(tag);

        RequestBody fileBody = RequestBody.create(MIME.STREAM, file);

        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"mFile\";filename=\"" + file.getName() + "\""), fileBody)
                .build();

        Request request = new Request.Builder()
                .tag(tag)
                .url(url)
                .post(requestBody)
                .build();
        //请求
        clientRequest(request, callBack, clazz);


    }


    @Override
    public  void downloadFile(String tag,NetBeanType type, final   String fileName,final   FileDownloadCallBack callBack) {

        //参数非空处理
        if(TextUtils.isEmpty(tag) ||type==null|| callBack ==null || TextUtils.isEmpty(fileName))
        {
            throw new NullPointerException("input args should not been null");
        }
        //访问url
        String url=type.getUrl();

        // 取消之前的请求
        mOkHttpClient.cancel(tag);

        //url和tag 构造request
        Request request = new Request.Builder().url(url).tag(tag).build();

        //请求
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callBack.onError(e);

            }

            @Override
            public void onResponse(Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();

                String cacheFileDir = CacheFileDirUtil.getCacheFileDir(fileName);

                //文件操作
                FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheFileDir));

                byte[] buffer = new byte[1024 * 1024];
                int len = -1;

                while ((len = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                    fileOutputStream.flush();
                }

                callBack.onSuccess(fileName);

                fileOutputStream.close();
                inputStream.close();


            }
        });



    }
    

    /**
     * 构造请求
     * @param request 请求
     * @param callBack  回调
     * @param clazz  类
     * @param <T>    类型
     */
    private <T> void clientRequest(Request request,final NetCallBack<T> callBack , final Class clazz) {


        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request,final IOException e) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });

            }

            @Override
            public void onResponse(Response response) throws IOException {

                final  T wantType = (T) mGson.fromJson(response.body().charStream(), clazz);

               final NetBean netBean = (NetBean) wantType;

                if ("1".equals(netBean.getExecuteStatus()) && !TextUtils.isEmpty(netBean.getErrorMsg())) {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onException(netBean.getErrorCode(), netBean.getErrorMsg());
                        }
                    });
                    return;
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(wantType);
                    }
                });

            }
        });


    }


    /**
     * get请求拼接参数
     * @param map 参数map
     * @return
     */
    private String handlePara(Map<String, String> map) {

        StringBuilder sb=new StringBuilder();

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        Map.Entry<String, String> entry;
        while (iterator.hasNext())
        {
            entry = iterator.next();

            if(iterator.hasNext())
            {
                sb.append(entry.getKey()+"="+entry.getValue()+"&");
            }
            else
            {
                sb.append(entry.getKey()+"="+entry.getValue());
            }

        }

        return sb.toString();
    }




    @Override
    public void cancalByTag(String tag) {
        mOkHttpClient.cancel(tag);
    }
}



