package c6;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import f6.f;
import java.lang.reflect.Method;
import java.util.TimeZone;
import n1.e;

/* JADX INFO: loaded from: classes2.dex */
@b.b(3)
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1368a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1369b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f1370c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1371d = "";

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = b.f1368a = c6.a.a(b6.b.a()).f1363a;
                d6.a.P("advertisingId is " + b.f1368a);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void c(StringBuilder sb2, int i10, int i11) {
        String string = Integer.toString(i11);
        for (int i12 = 0; i12 < i10 - string.length(); i12++) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    public static String d(boolean z10, boolean z11, int i10) {
        char c10;
        int i11 = i10 / 60000;
        if (i11 < 0) {
            i11 = -i11;
            c10 = '-';
        } else {
            c10 = '+';
        }
        StringBuilder sb2 = new StringBuilder(9);
        if (z10) {
            sb2.append("GMT");
        }
        sb2.append(c10);
        c(sb2, 2, i11 / 60);
        if (z11) {
            sb2.append(e.f11184d);
        }
        c(sb2, 2, i11 % 60);
        return sb2.toString();
    }

    public static String e() {
        if (!TextUtils.isEmpty(f1370c)) {
            return f1370c;
        }
        String string = Settings.Secure.getString(b6.b.a().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String strB = TextUtils.isEmpty(string) ? "" : f6.c.b(string, "SHA-256");
        f1370c = strB;
        return strB;
    }

    public static String f() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (f.a("android.permission.BLUETOOTH") || defaultAdapter == null) ? "" : defaultAdapter.getAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(Context context) {
        double dDoubleValue;
        try {
            dDoubleValue = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), null)).doubleValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            dDoubleValue = 0.0d;
        }
        return String.valueOf(dDoubleValue + " mAh");
    }

    public static String h() {
        String str = f1368a;
        if (str == null || str.length() == 0) {
            new Thread(new a()).start();
        }
        return f1368a;
    }

    public static String i() {
        if (t()) {
            return h();
        }
        String str = f1368a;
        if (str != null && str.length() != 0) {
            return f1368a;
        }
        try {
            f1368a = c6.a.a(b6.b.a()).f1363a;
            d6.a.P("advertisingId is " + f1368a);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return f1368a;
    }

    public static String j() {
        if (!TextUtils.isEmpty(f1369b)) {
            return f1369b;
        }
        String str = "";
        String strA = c.a("prop.sim1.imei", "");
        if (strA == null || strA.length() == 0 || strA.length() != 15) {
            try {
                return ((TelephonyManager) b6.b.a().getSystemService("phone")).getImei();
            } catch (SecurityException unused) {
            }
        } else {
            str = strA;
        }
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            f1369b = str;
        } else {
            f1369b = f6.c.b(str, "SHA-256");
        }
        return f1369b;
    }

    public static String k(int i10) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) b6.b.a().getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i10));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i10));
            }
            return (TextUtils.isEmpty(str) || str.length() < 15) ? str : f6.c.b(str, "SHA-256");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l() {
        try {
            Context contextA = b6.b.a();
            TelephonyManager telephonyManager = (TelephonyManager) contextA.getSystemService("phone");
            if (contextA.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", contextA.getApplicationContext().getPackageName()) != 0) {
                return p();
            }
            String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
            return (subscriberId != null && subscriberId.length() >= 8) ? subscriberId.substring(0, 8) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(int i10) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) b6.b.a().getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i10));
            return !TextUtils.isEmpty(str) ? f6.c.b(str, "SHA-256") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String n() {
        if (TextUtils.isEmpty(f1371d)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, "ro.tranos.version", "");
                f1371d = str;
                if (TextUtils.isEmpty(str)) {
                    f1371d = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception unused) {
            }
        }
        return f1371d;
    }

    public static String o() {
        String serial;
        try {
            serial = Build.getSerial();
        } catch (Exception unused) {
            serial = "";
        }
        try {
            if (TextUtils.isEmpty(serial) || "unknown".equals(serial)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                serial = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            }
        } catch (Exception unused2) {
        }
        return TextUtils.isEmpty(serial) ? "" : f6.c.b(serial, "SHA-256");
    }

    public static String p() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) b6.b.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String q() {
        try {
            return d(true, true, TimeZone.getDefault().getRawOffset());
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static long r(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long s(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean t() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean u() {
        Context contextA = b6.b.a();
        return contextA.getResources() != null && (contextA.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
