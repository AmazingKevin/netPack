package cn.ddkl.android.netlayer.netbean;

import cn.ddkl.android.netlayer.constant.NetConstant;
import cn.ddkl.android.netlayer.netbean.implement4n.AddCategoryResponseImp;
import cn.ddkl.android.netlayer.netbean.implement4n.LoginBeanImp;
import cn.ddkl.android.netlayer.netbean.implement4n.PostJsonImp;
import cn.ddkl.android.netlayer.netbean.implement4n.RegistBeanImp;
import cn.ddkl.android.netlayer.netbean.implement4n.TestBeanImp;

/**
 * Created by Administrator on 2015/9/17.
 */
public enum NetBeanType {
    LoginBean("get", NetConstant.TEST_URL,LoginBeanImp.class),
    RegistBean("get", NetConstant.TEST_URL,RegistBeanImp.class),
    TestBean("get", NetConstant.TEST_URL,TestBeanImp.class),
    PostJson("post", NetConstant.TEST_POST,PostJsonImp.class),
    PostFile("post", NetConstant.TEST_FILE,PostJsonImp.class),
    DownloadFile("get", NetConstant.TEST_DOWNLOAD,PostJsonImp.class),
    DownloadImg("get", NetConstant.TEST_DOWNLOADIMG,PostJsonImp.class),
    //Baidu("get","http://www.baidu.com", BaiduImp.class),
    AddCategory("post",NetConstant.ADD_CATEGORY, AddCategoryResponseImp.class);

    NetBeanType(String METHOD,String url,Class clazz)
    {
        this.METHOD=METHOD;
        this.url=url;
        this.clazz=clazz;
    }

   private String METHOD;
    private  String url;
    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public String getUrl() {
        return url;
    }




}
