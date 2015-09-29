package cn.ddkl.android.utils.cache;

import android.os.Environment;

import java.io.File;

import cn.ddkl.android.utils.Context.CX;

/**
 * Created by Administrator on 2015/9/22.
 */
public class CacheFileDirUtil {


    /**
     * 放入一个文件返回一个缓冲路径完整地址
     * 返回一个缓冲地址
     * @return
     */
    public static String getCacheFileDir(String fileName)
    {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
                   //sd卡路径                                                  //分隔符         //包名                    //分隔符          //名字
            return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator +CX.context.getPackageName()+ File.separator  +fileName;
        }
                //私人卡目录
        return  CX.context.getCacheDir().getAbsolutePath()+File.separator+fileName;
    }
}
