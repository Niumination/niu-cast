package f8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjectLogUtils f5006a = new ObjectLogUtils.Builder().setGlobalTag("GSLB_SDK").setLogHeadSwitch(true).setBorderSwitch(false).create();

    public static String a(String str) {
        String host;
        if (str == null || !str.startsWith("http")) {
            host = str;
        } else {
            try {
                host = new URL(str).getHost();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                host = "";
            }
        }
        if (TextUtils.isEmpty(host)) {
            f5006a.e("the url is illegal->" + str);
        }
        return host;
    }

    public static boolean b(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(4) || networkCapabilities.hasTransport(3);
            }
        } catch (Exception e) {
            f5006a.e(Log.getStackTraceString(e));
        }
        return false;
    }
}
