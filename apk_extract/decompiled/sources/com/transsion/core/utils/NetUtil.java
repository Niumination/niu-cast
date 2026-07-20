package com.transsion.core.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.transsion.core.CoreUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NetUtil {
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNAVAILABLE = -1;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = -101;
    private static final int NETWORK_TYPE_1xRTT = 7;
    private static final int NETWORK_TYPE_CDMA = 4;
    private static final int NETWORK_TYPE_EDGE = 2;
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_0 = 5;
    private static final int NETWORK_TYPE_EVDO_A = 6;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_GPRS = 1;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final int NETWORK_TYPE_UMTS = 3;
    private static final int NETWORK_TYPE_UNAVAILABLE = -1;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = -101;

    public static boolean checkNetworkState() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (CoreUtil.getContext().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) CoreUtil.getContext().getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    private static int classifyNetType(int i8) {
        int i9 = -101;
        if (i8 != -101) {
            i9 = -1;
            if (i8 != -1) {
                switch (i8) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            }
        }
        return i9;
    }

    public static String getNetworkCountryIso() {
        return getTeleMgr() == null ? "" : getTeleMgr().getNetworkCountryIso();
    }

    public static String getNetworkOperator() {
        return getTeleMgr() == null ? "" : getTeleMgr().getNetworkOperator();
    }

    public static String getNetworkOperatorName() {
        return getTeleMgr() == null ? "" : getTeleMgr().getNetworkOperatorName();
    }

    public static int getNetworkType() {
        int networkType = 0;
        try {
            if (CoreUtil.getContext().getApplicationContext() == null && CoreUtil.getContext().getApplicationContext().getSystemService("connectivity") == null) {
                return 0;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) CoreUtil.getContext().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    networkType = -101;
                } else if (type == 0) {
                    networkType = ((TelephonyManager) CoreUtil.getContext().getApplicationContext().getSystemService("phone")).getNetworkType();
                }
            } else {
                networkType = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classifyNetType(networkType);
    }

    private static TelephonyManager getTeleMgr() {
        if (CoreUtil.getContext().getApplicationContext() == null) {
            return null;
        }
        return (TelephonyManager) CoreUtil.getContext().getApplicationContext().getSystemService("phone");
    }

    public static String getWLANMAC() {
        try {
            if (CoreUtil.getContext().getApplicationContext() != null) {
                return !PermissionUtil.lacksPermission("android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) CoreUtil.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress() : "";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
