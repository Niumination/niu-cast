package vc;

import android.os.DeadSystemException;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import m3.i;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f10546c;

    static {
        boolean zBooleanValue;
        try {
            if (i.f7705a == null) {
                i.f7705a = Class.forName("android.app.ActivityThread");
            }
            if (i.f7706b == null) {
                Method declaredMethod = i.f7705a.getDeclaredMethod("isSystem", null);
                i.f7706b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            zBooleanValue = ((Boolean) i.f7706b.invoke(null, null)).booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            b("AndroidHiddenApi", "Warning : invoke ActivityThread.isSystem, " + e);
            zBooleanValue = false;
        }
        f10544a = "Kolun";
        f10545b = 1;
        if (zBooleanValue) {
            try {
                Class<?> cls = Class.forName("android.util.Log");
                Class cls2 = Integer.TYPE;
                Method declaredMethod2 = cls.getDeclaredMethod("println_native", cls2, cls2, String.class, String.class);
                f10546c = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
        }
    }

    public static int a(int i8, String str, String str2, Exception exc) {
        if (i8 <= f10545b) {
            return 0;
        }
        String strL = d.l(f10544a, ".", str);
        String string = "";
        String strI = h0.a.i("", str2);
        if (exc != null) {
            StringBuilder sbT = d.t(strI, "\n");
            Throwable cause = exc;
            while (true) {
                if (cause == null) {
                    StringWriter stringWriter = new StringWriter(256);
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    exc.printStackTrace(printWriter);
                    printWriter.flush();
                    string = stringWriter.toString();
                    break;
                }
                if (cause instanceof UnknownHostException) {
                    break;
                }
                if (cause instanceof DeadSystemException) {
                    string = "SystemServer is Crash";
                    break;
                }
                cause = cause.getCause();
            }
            sbT.append(string);
            strI = sbT.toString();
        }
        Method method = f10546c;
        if (method == null) {
            return Log.println(i8, strL, strI);
        }
        try {
            return ((Integer) method.invoke(null, 3, Integer.valueOf(i8), strL, strI)).intValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void b(String str, String str2) {
        a(5, str, str2, null);
    }
}
