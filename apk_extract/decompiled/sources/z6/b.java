package z6;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import m3.g0;
import s6.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f11259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f11260b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f11261c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f11262d = 0;

    public static int a(long j8) {
        if (j8 > 999) {
            return Integer.parseInt(String.valueOf(j8).substring(0, 4));
        }
        return 0;
    }

    public static String b() {
        return f11259a == null ? "" : f11259a;
    }

    public static String c(int i8) {
        return a1.a.o(i8, i8 > 10 ? "" : "0");
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f11259a)) {
            try {
                f11259a = g0.b(context).f5115a;
                if (!TextUtils.isEmpty(f11259a)) {
                    i1.a aVarA = i1.a.a(context);
                    if (!TextUtils.equals(f11259a, aVarA.i("athena_id"))) {
                        aVarA.g("athena_id", f11259a);
                    }
                }
            } catch (Exception e) {
                a.c(e.getMessage());
            }
            if (TextUtils.isEmpty(f11259a)) {
                f11259a = i1.a.a(context).i("athena_id");
            }
        }
        return f11259a;
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

    public static boolean f(Context context, String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                String[] strArr = packageInfo.requestedPermissions;
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null && applicationInfo.uid == 1000 && strArr != null) {
                    for (String str2 : strArr) {
                        if (TextUtils.equals(str2, str)) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception e) {
                a.c(e.getMessage());
            }
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e4) {
            a.c(e4.getMessage());
            return false;
        }
    }

    public static String g(Context context, String str) {
        i1.b bVar;
        ConcurrentHashMap concurrentHashMap = f11260b;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j8 = f11262d;
            if (j8 != 0 && jElapsedRealtime - j8 < 600000) {
                return "";
            }
            synchronized (i1.b.class) {
                try {
                    if (i1.b.f5526c == null) {
                        i1.b bVar2 = new i1.b();
                        bVar2.f5528b = context.getApplicationContext();
                        i1.b.f5526c = bVar2;
                    }
                    bVar = i1.b.f5526c;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            String strB = bVar.b(str);
            if (TextUtils.isEmpty(strB)) {
                f11262d = jElapsedRealtime;
                return "";
            }
            concurrentHashMap.put(str, strB);
            f11262d = 0L;
            return strB;
        } catch (Exception e) {
            a.c(e.getMessage());
            return "";
        }
    }

    public static boolean h(Context context) {
        try {
            if (f11261c) {
                if (TextUtils.isEmpty(i1.a.a(context).i("first_launch"))) {
                    if (new File(context.getFilesDir() + File.separator + d.f9545j, "global.cfg").exists()) {
                        f11261c = false;
                    }
                } else {
                    f11261c = false;
                }
            }
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
        return f11261c;
    }

    public static boolean i(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo("com.hoffnung", 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if ("com.transsion.dataservice.provider".equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
        return false;
    }
}
