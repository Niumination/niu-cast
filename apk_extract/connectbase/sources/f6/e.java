package f6;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5853a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5854b = -101;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5855c = -101;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5856d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5857e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5858f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5859g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5860h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5861i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5862j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5863k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5864l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5865m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5866n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5867o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5868p = 7;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5869q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5870r = 9;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5871s = 10;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5872t = 11;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5873u = 12;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5874v = 13;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5875w = 14;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5876x = 15;

    public static boolean a() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (b6.b.a().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) b6.b.a().getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static int b(int i10) {
        int i11 = -101;
        if (i10 != -101) {
            i11 = -1;
            if (i10 != -1) {
                switch (i10) {
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
        return i11;
    }

    public static String c() {
        return g() == null ? "" : g().getNetworkCountryIso();
    }

    public static String d() {
        return g() == null ? "" : g().getNetworkOperator();
    }

    public static String e() {
        return g() == null ? "" : g().getNetworkOperatorName();
    }

    public static int f() {
        int networkType = 0;
        try {
            if (b6.b.a().getApplicationContext() == null && b6.b.a().getApplicationContext().getSystemService("connectivity") == null) {
                return 0;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) b6.b.a().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    networkType = -101;
                } else if (type == 0) {
                    networkType = ((TelephonyManager) b6.b.a().getApplicationContext().getSystemService("phone")).getNetworkType();
                }
            } else {
                networkType = -1;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return b(networkType);
    }

    public static TelephonyManager g() {
        if (b6.b.a().getApplicationContext() == null) {
            return null;
        }
        return (TelephonyManager) b6.b.a().getApplicationContext().getSystemService("phone");
    }

    public static String h() {
        try {
            if (b6.b.a().getApplicationContext() != null) {
                return !f.a("android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) b6.b.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress() : "";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
