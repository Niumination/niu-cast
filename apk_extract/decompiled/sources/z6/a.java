package z6;

import com.transsion.core.log.ObjectLogUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjectLogUtils f11258a = new ObjectLogUtils.Builder().setGlobalTag("Athena").setLogHeadSwitch(true).setBorderSwitch(false).create();

    public static void a(String str) {
        if (str == null || str.length() == 0) {
            str = "%s";
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.d(str);
    }

    public static void b(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.d(str);
    }

    public static void c(String str) {
        if (str == null || str.length() == 0) {
            str = "%s";
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.e(str);
    }

    public static void d(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.e(str);
    }

    public static void e(String str) {
        if (str == null || str.length() == 0) {
            str = "%s";
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.i(str);
    }

    public static void f(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f11258a;
        objectLogUtils.setInvokeLayer(1);
        objectLogUtils.i(str);
    }
}
