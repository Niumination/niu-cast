package l9;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7354b;

    static {
        String str = "0";
        try {
            try {
                Class<?> cls = Class.forName("com.transsion.hubsdk.os.TranBuild");
                Field fieldC = o9.c(cls, "THUBCORE_VERSION");
                if (fieldC != null) {
                    str = (String) fieldC.get(cls.newInstance());
                }
            } catch (Exception e) {
                boolean z2 = j9.a.f6132a;
                Log.e("o9", "Failed to get value of getFieldString", e);
            }
            int i8 = Integer.parseInt(str.replace(".", ""));
            f7353a = i8;
            j9.a.c("b", "initializer: version = " + str + ", THUBCORE_VERSION = " + i8);
            int i9 = Build.VERSION.SDK_INT;
            f7354b = i9;
            j9.a.c("b", "ro.build.version.sdk = " + i9);
        } catch (Throwable th2) {
            String str2 = "static initializer: e = " + th2.getMessage();
            boolean z3 = j9.a.f6132a;
            Log.e("b", str2);
        }
    }

    public static boolean a(String str) {
        String string;
        int i8 = f7353a;
        try {
            if (i8 >= Integer.parseInt(str) && Integer.parseInt(str) >= Integer.parseInt(a.f7342a)) {
                return true;
            }
        } catch (Exception e) {
            boolean z2 = j9.a.f6132a;
            Log.e("b", "supportThubCore: e = " + e);
        }
        StringBuilder sb2 = new StringBuilder("THUBCore No support Call!!! method version = ");
        sb2.append(str);
        sb2.append(", >>> ThubCore vserion = ");
        sb2.append(i8);
        sb2.append("\n mthod version must <= ThubCore version.\n ---");
        Throwable th2 = new Throwable();
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb3 = new StringBuilder(th2.toString());
            int i9 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb3.append("\n#" + stackTraceElement.getClassName());
                sb3.append(".");
                sb3.append(stackTraceElement.getMethodName());
                sb3.append("[" + stackTraceElement.getLineNumber() + "]");
                i9++;
                if (i9 >= 4) {
                    break;
                }
            }
            string = sb3.toString();
        } catch (Exception e4) {
            boolean z3 = j9.a.f6132a;
            Log.w("b", "getStackTrace Exception" + e4);
            string = "";
        }
        sb2.append(string);
        String string2 = sb2.toString();
        boolean z5 = j9.a.f6132a;
        Log.w("b", string2);
        return false;
    }
}
