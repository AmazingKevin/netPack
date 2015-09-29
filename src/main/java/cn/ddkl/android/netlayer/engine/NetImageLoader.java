package cn.ddkl.android.netlayer.engine;

import android.widget.ImageView;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface NetImageLoader {

   void displayImage(String url,ImageView imageView);
   void clearMemoryCache();
   void clearDiskCache();
   void stopNetImageDisplay();
}
