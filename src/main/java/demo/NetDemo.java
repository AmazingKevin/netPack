package demo;

import android.content.Context;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.ddkl.android.netlayer.HttpHandler;
import cn.ddkl.android.netlayer.R;
import cn.ddkl.android.netlayer.callback.FileDownloadCallBack;
import cn.ddkl.android.netlayer.callback.NetCallBack;
import cn.ddkl.android.netlayer.netbean.NetBeanType;
import cn.ddkl.android.netlayer.netbean.interface4n.PostJson;
import cn.ddkl.android.netlayer.netbean.interface4n.TestBean;

/**
 * Created by Administrator on 2015/9/18.
 */
public class NetDemo {

    /**
     * 测试请求数据bean
     * @param context
     */
    public void runDemo(Context context)
    {

        HttpHandler.init(context);

        Map<String,String> map=new HashMap<>();
        map.put("phone","13429667914");
        map.put("key","60024fc0fc3cc48cbca7468e60c568f1");

        HttpHandler.getInstance().requestNetBean("1", NetBeanType.TestBean, map, new NetCallBack<TestBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onException(String errorCode, String errorMsg) {

            }

            @Override
            public void onSuccess(TestBean response) {

                System.out.println("" + response.getReason());
                System.out.println("" + response.getResult().getCity());
                System.out.println("" + response.getResult().getAreacode());
                System.out.println("" + response.getResult().getCard());
                System.out.println("" + response.getResult().getCompany());
                System.out.println("" + response.getResult().getProvince());
                System.out.println("" + response.getResult().getZip());

            }
        });

    }



    public final static String[] imageUrls = new String[] {
            "http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_3691.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_7315.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760663_7318.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_3454.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_5113.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_3305.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_7416.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_2946.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_1100.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760588_8297.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_2575.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_8906.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_2875.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_9517.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_7093.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_1352.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760548_2780.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1776.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1380.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_4944.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_5750.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760529_3289.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_7871.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_6063.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_6304.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_5081.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760498_7007.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_3128.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_6766.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_1358.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_3540.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760476_1240.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_7993.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760445_3283.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_8623.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_6822.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760422_2224.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760421_2824.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760420_2660.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760420_7188.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760419_4123.jpg",
    };

    /**
     * 测试单张图片网络请求
     * @param context
     * @param url
     * @param imageView
     */
    public void runImageDemo(Context context,String url,ImageView imageView)
    {
        HttpHandler.init(context).displayNetImage("https://www.baidu.com/img/bd_logo1.png", imageView);
    }

    /**
     * 测试listView图片网络请求
     * @param context
     * @param listView
     */
    public void runListImageDemo(Context context,ListView listView)
    {

        HttpHandler.init(context);

        ArrayList<String> mDatas=new ArrayList<String>();

        for (int i = 0; i <imageUrls.length ; i++) {
            mDatas.add(imageUrls[i]);
        }

        CommonAdapter<String> adapter=new CommonAdapter<String>(context,mDatas,R.layout.layout) {
            @Override
            public void convert(ViewHolder helper, String item) {

                helper.setImageByUrl(R.id.iv_demo,item);

            }
        };

        listView.setAdapter(adapter);
    }

    /**
     * 测试提交数据网络
     * @param context
     */
    public void runPostJson(Context context)
    {
        HttpHandler.init(context);

        Person person = new Person();
        person.setName("李四");
        person.setAddress("中国广东深圳");



        HttpHandler.getInstance().postJson("1", NetBeanType.PostJson, person, new NetCallBack<PostJson>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onException(String errorCode, String errorMsg) {

            }

            @Override
            public void onSuccess(PostJson response) {

                System.out.println(response.getExecuteStatus()+"");
                System.out.println(response.getErrorMsg()+"");
                System.out.println(response.getErrorCode()+"");


            }
        });

    }

    /**
     * 测试上传文件
     * @param context
     */
    public void runPostFile(Context context)
    {
        HttpHandler.init(context);
        File file=  new File(Environment.getExternalStorageDirectory(),"test.apk");

        HttpHandler.getInstance().uploadFile("1", NetBeanType.PostFile, file, new NetCallBack<PostJson>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onException(String errorCode, String errorMsg) {

            }

            @Override
            public void onSuccess(PostJson response) {

            }
        });



    }

    /**
     * 测试图片上传
     * @param context
     */
    public void runPostPic(Context context)
    {
        HttpHandler.init(context);
        File file=  new File(Environment.getExternalStorageDirectory(),"a.jpg");

        HttpHandler.getInstance().uploadFile("1", NetBeanType.PostFile, file, new NetCallBack<PostJson>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onException(String errorCode, String errorMsg) {

            }

            @Override
            public void onSuccess(PostJson response) {

            }
        });



    }


    /**
     * 测试文件下载
     * @param context
     */
    public void runDownloadFile(Context context)
    {
        HttpHandler.init(context);

        HttpHandler.getInstance().downloadFile("1", NetBeanType.DownloadFile, "test.apk", new FileDownloadCallBack() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(String filePath) {

            }
        });

    }

    /**
     * 测试图片下载
     * @param context
     */
    public void runDownloadImage(Context context)
    {
        HttpHandler.init(context);


        HttpHandler.getInstance().downloadFile("1", NetBeanType.DownloadImg, "abc.jpg", new FileDownloadCallBack() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onSuccess(String filePath) {

            }
        });

    }
}
