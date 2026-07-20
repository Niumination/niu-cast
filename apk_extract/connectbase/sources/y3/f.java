package y3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20700a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f20701b;

    @RequiresApi(21)
    public static class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            f.f20700a = -1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            f.f20700a = -1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            f.f20700a = -1;
        }

        public a(b bVar) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x008e  */
    public static int a(Context context) {
        String subtypeName;
        int subtype;
        NetworkInfo activeNetworkInfo;
        NetworkCapabilities networkCapabilities;
        int i10 = f20700a;
        if (i10 != -1 && i10 != 0 && i10 != 99) {
            return i10;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!e(connectivityManager)) {
                f20700a = 99;
                return 99;
            }
            if (g(connectivityManager)) {
                f20700a = 1;
            } else if (c(connectivityManager)) {
                f20700a = 6;
            } else {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                int i11 = 0;
                if ((activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? false : networkCapabilities.hasTransport(0)) {
                    ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                    if (connectivityManager2 == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null) {
                        subtypeName = "";
                        subtype = 0;
                    } else {
                        subtype = activeNetworkInfo.getSubtype();
                        subtypeName = activeNetworkInfo.getSubtypeName();
                    }
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            i11 = 2;
                            break;
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
                            i11 = 3;
                            break;
                        case 13:
                        case 18:
                        case 19:
                            i11 = 4;
                            break;
                        case 20:
                            i11 = 5;
                            break;
                        default:
                            if (TextUtils.isEmpty(subtypeName)) {
                                i11 = 99;
                            } else if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                i11 = 3;
                            }
                            break;
                    }
                    f20700a = i11;
                } else {
                    f20700a = 100;
                }
            }
            return f20700a;
        } catch (Exception unused) {
            return 99;
        }
    }

    public static void b() {
        f20700a = -1;
    }

    public static boolean c(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(3);
    }

    public static boolean d(Context context) {
        try {
            return e((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return false;
        }
    }

    public static boolean e(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean f(Context context) {
        try {
            if (!d(context)) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return g(connectivityManager) || c(connectivityManager);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    public static void h(Context context) {
        try {
            if (f20701b == null) {
                f20701b = new a();
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(networkRequestBuild, f20701b);
            }
        } catch (Exception e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
        }
    }
}
