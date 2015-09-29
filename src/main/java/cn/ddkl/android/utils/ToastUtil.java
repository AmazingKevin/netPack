package cn.ddkl.android.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import cn.ddkl.android.utils.Context.CX;

/**
 * Created by Administrator on 2015/9/21.
 */
public class ToastUtil {

    //todo 吐司
    private static Toast mToast;
    public static Handler mHander;

    /**
     * @param text
     */
    public static void t(final   CharSequence text) {

        if(Looper.myLooper()!=Looper.getMainLooper())
        {
            //not ui thread
            mHander.post(new Runnable() {
                @Override
                public void run() {
                    showToast(text);
                }
            });
        }
        else
        {
            //sure its ui thread
            showToast( text);
        }

    }

    /**
     * 展示吐司
     * @param text
     */
    private static void showToast(final   CharSequence text)
    {
        if(mToast==null)
        {
            mToast=Toast.makeText(CX.context,text,Toast.LENGTH_SHORT);
        }
        else
        {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
