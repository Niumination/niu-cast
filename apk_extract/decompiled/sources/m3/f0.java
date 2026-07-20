package m3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.transsion.core.log.ObjectLogUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7669a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static eb.d f7670b;

    public static int a(Context context) {
        String subtypeName;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int dataNetworkType = (telephonyManager == null || !(ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 || telephonyManager.hasCarrierPrivileges())) ? 0 : telephonyManager.getDataNetworkType();
        if (dataNetworkType != 0 || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            subtypeName = "";
        } else {
            dataNetworkType = activeNetworkInfo.getSubtype();
            subtypeName = activeNetworkInfo.getSubtypeName();
        }
        switch (dataNetworkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                if (TextUtils.isEmpty(subtypeName)) {
                    return 99;
                }
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 0;
        }
    }

    public static int b(Context context) {
        NetworkCapabilities networkCapabilities;
        NetworkCapabilities networkCapabilities2;
        NetworkCapabilities networkCapabilities3;
        int i8 = f7669a;
        if (i8 != -1 && i8 != 0 && i8 != 99) {
            return i8;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!c(connectivityManager)) {
                f7669a = 99;
                return 99;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            boolean zHasTransport = false;
            if ((activeNetwork == null || (networkCapabilities3 = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? false : networkCapabilities3.hasTransport(1)) {
                f7669a = 1;
            } else {
                Network activeNetwork2 = connectivityManager.getActiveNetwork();
                if ((activeNetwork2 == null || (networkCapabilities2 = connectivityManager.getNetworkCapabilities(activeNetwork2)) == null) ? false : networkCapabilities2.hasTransport(3)) {
                    f7669a = 6;
                } else {
                    Network activeNetwork3 = connectivityManager.getActiveNetwork();
                    if (activeNetwork3 != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork3)) != null) {
                        zHasTransport = networkCapabilities.hasTransport(0);
                    }
                    if (zHasTransport) {
                        f7669a = a(context);
                    } else {
                        f7669a = 100;
                    }
                }
            }
            return f7669a;
        } catch (Exception unused) {
            return 99;
        }
    }

    public static boolean c(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean d(Context context) {
        try {
            return c((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = z6.a.f11258a;
            z6.a.c(Log.getStackTraceString(e));
            return false;
        }
    }
}
