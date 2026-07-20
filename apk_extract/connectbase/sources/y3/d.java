package y3;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f20689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f20690b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f20691c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f20692d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f20693e = 0;

    public static int a(long j10) {
        if (j10 > 999) {
            return Integer.parseInt(String.valueOf(j10).substring(0, 4));
        }
        return 0;
    }

    @NonNull
    public static String b() {
        return f20689a == null ? "" : f20689a;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f20689a)) {
            try {
                f20689a = e.e(context).f20696a;
                if (!TextUtils.isEmpty(f20689a)) {
                    m0.a aVarA = m0.a.a(context);
                    if (!TextUtils.equals(f20689a, aVarA.i("athena_id"))) {
                        aVarA.g("athena_id", f20689a);
                    }
                }
            } catch (Exception e10) {
                b.d(e10.getMessage());
            }
            if (TextUtils.isEmpty(f20689a)) {
                f20689a = m0.a.a(context).i("athena_id");
            }
        }
        return f20689a;
    }

    public static String d(Context context, String str) {
        Map<String, String> map = f20690b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            if (!ki.a.f9177c) {
                return "";
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = f20692d;
            if (j10 != 0 && jElapsedRealtime - j10 < 600000) {
                return "";
            }
            String strA = m0.b.b(context).a(str);
            if (TextUtils.isEmpty(strA)) {
                f20692d = jElapsedRealtime;
                return "";
            }
            map.put(str, strA);
            f20692d = 0L;
            return strA;
        } catch (Exception e10) {
            b.d(e10.getMessage());
            return "";
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("Athena", "------------------------------------------------------------");
        Log.e("Athena", "");
        Log.e("Athena", str);
        Log.e("Athena", "");
        Log.e("Athena", "------------------------------------------------------------");
    }

    public static void f(String str) {
        f20689a = str;
    }

    public static boolean g() {
        return s3.g.N() || s3.g.S();
    }

    public static boolean h(long j10) {
        return j10 > 999 && j10 <= 9999;
    }

    public static boolean i(Context context) {
        try {
            if (f20691c) {
                if (TextUtils.isEmpty(m0.a.a(context).i("first_launch"))) {
                    if (new File(context.getFilesDir() + File.separator + s3.g.f14977j, "global.cfg").exists()) {
                        f20691c = false;
                    }
                } else {
                    f20691c = false;
                }
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return f20691c;
    }

    public static boolean j(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo("com.hoffnung", 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if ("com.transsion.dataservice.provider".equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return false;
    }
}
