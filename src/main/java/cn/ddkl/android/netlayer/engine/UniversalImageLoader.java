package cn.ddkl.android.netlayer.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 2015/9/21.
 */
public class UniversalImageLoader implements NetImageLoader {




    private  UniversalImageLoader(){}

    private ImageLoader imageLoader;

    public  UniversalImageLoader(Context context)
    {
        //图像设置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1)//加载后拖延时间长度
                .cacheInMemory(true) // default 是否缓存在内存中
                .cacheOnDisk(true) // default    是否缓存在硬盘中
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default 图像编码
                .build();

        //初始化配置
        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(50 * 1024 * 1024))
                .memoryCacheSize(50 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new UnlimitedDiskCache(new File(Environment.getExternalStorageDirectory(),context.getPackageName()))) // default
                .diskCacheSize(100 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(context)) // default
                .defaultDisplayImageOptions(options) //默认的显示设置
                .writeDebugLogs()
                .build();


        //初始化imageLoader
        imageLoader = ImageLoader.getInstance();
        //初始化基本设置
        imageLoader.init(config);
        //这是默认的
        //  imageLoader.init(ImageLoaderConfiguration.createDefault(context));

    }


    @Override
    public void displayImage(String url, ImageView imageView) {
        imageLoader.displayImage(url, imageView);

    }

    @Override
    public void clearMemoryCache() {
        imageLoader.clearMemoryCache();
    }

    @Override
    public void clearDiskCache() {
        imageLoader.clearDiskCache();
    }

    @Override
    public void stopNetImageDisplay() {
        imageLoader.stop();
    }


}
