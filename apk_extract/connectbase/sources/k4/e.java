package k4;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f8930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Resources f8931b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f8932c = false;

    public static Context a() {
        return f8930a;
    }

    public static String b(int i10) {
        return f8931b.getString(i10);
    }

    public static void c(Application application) {
        f8930a = application;
        f8931b = application.getResources();
    }
}
