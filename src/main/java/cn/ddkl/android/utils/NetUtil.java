package cn.ddkl.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.ddkl.android.utils.Context.CX;

/**
 * Created by Kevin on 2015/8/18.
 */
public class NetUtil {

    ////////////// ////////////// //////////////  ////////////// ////////////// //////////////  ////////////// ////////////// //////////////
    //todo 网络监测工具类




    /**
     * 检测网络是否可用
     * @return true 可用,false 不可用
     */
    public static boolean isOpenNetwork() {
        ConnectivityManager connManager =(ConnectivityManager)CX.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    /**
     * WIFI是否连接   <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
     */
    public static boolean isWifiConnected( ) {

            ConnectivityManager mConnectivityManager = (ConnectivityManager) CX.context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
            else
            {
                return false;
            }


    }

    /**
     * 手机网络是否连接
     */
    public static boolean isMobileConnected( ) {

            ConnectivityManager mConnectivityManager = (ConnectivityManager) CX.context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
            else
            {
                return false;
            }


    }

    /**
     * 当前网络类型
     */
    public static int getConnectedType( ) {

            ConnectivityManager mConnectivityManager = (ConnectivityManager) CX.context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
            else
            {
                return -1;
            }

    }


}
