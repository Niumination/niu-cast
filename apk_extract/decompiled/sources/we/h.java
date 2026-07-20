package we;

import android.util.Log;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static void a(String mes) {
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 5) {
            Log.d("welinkBLE", mes, null);
        }
    }

    public static void b(String tag, String mes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 5) {
            Log.d(tag, "TransConnect:" + mes, null);
        }
    }

    public static void c(String tag, String mes, Throwable th2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, tag, th2);
        }
    }

    public static void d(String mes, Throwable th2) {
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", mes, th2);
        }
    }

    public static void g(String mes) {
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 3) {
            Log.i("welinkBLE", mes, null);
        }
    }

    public static void h(String tag, String mes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 3) {
            Log.i(tag, "TransConnect:" + mes, null);
        }
    }

    public static void i(String mes, Throwable th2) {
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 2) {
            Log.w("welinkBLE", mes, th2);
        }
    }

    public static void j(String tag, String mes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 2) {
            Log.w(tag, "TransConnect:" + mes, null);
        }
    }
}
