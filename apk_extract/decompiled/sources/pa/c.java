package pa;

import android.content.ComponentName;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import j3.z;
import java.util.ArrayList;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m3.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static z f8709g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8705a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f8706b = LazyKt.lazy(new ob.c(3));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8707c = LazyKt.lazy(new ob.c(4));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f8708d = LazyKt.lazy(new ob.c(5));
    public static String e = "com.transsion.pcconnect";
    public static final Lazy f = LazyKt.lazy(new ob.c(6));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayList f8710h = new ArrayList();

    @Override // pa.b
    public final void a() {
        try {
            i1.a aVar = new i1.a(6);
            UserHandle userHandle = z8.a.f11265a;
            aVar.j();
        } catch (Throwable e4) {
            Intrinsics.checkNotNullParameter("ThubFrameworkProxy", "tag");
            Intrinsics.checkNotNullParameter(e4, "e");
            Log.e(gc.f6463b.concat("ThubFrameworkProxy"), e4.getMessage(), e4);
        }
    }

    @Override // pa.b
    public final synchronized void b(lc.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = f8710h;
        arrayList.remove(callback);
        if (arrayList.isEmpty() && f8709g != null) {
            try {
                f9.a aVar = (f9.a) f.getValue();
                aVar.getClass();
                String str = l9.a.f7342a;
                aVar.a().b();
            } catch (Throwable e4) {
                Intrinsics.checkNotNullParameter("ThubFrameworkProxy", "tag");
                Intrinsics.checkNotNullParameter(e4, "e");
                Log.e(gc.f6463b.concat("ThubFrameworkProxy"), e4.getMessage(), e4);
            }
            f8709g = null;
        }
    }

    @Override // pa.b
    public final synchronized void c(lc.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = f8710h;
        if (!arrayList.contains(callback)) {
            arrayList.add(callback);
        }
        if (f8709g == null) {
            z zVar = new z();
            f8709g = zVar;
            try {
                f9.a aVar = (f9.a) f.getValue();
                aVar.getClass();
                String str = l9.a.f7342a;
                aVar.a().a(zVar);
            } catch (Throwable e4) {
                Intrinsics.checkNotNullParameter("ThubFrameworkProxy", "tag");
                Intrinsics.checkNotNullParameter(e4, "e");
                Log.e(gc.f6463b.concat("ThubFrameworkProxy"), e4.getMessage(), e4);
                f8709g = null;
                f8710h.clear();
            }
        }
    }

    @Override // pa.b
    public final String d(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        try {
            String str = l9.a.f7342a;
            defaultValue = j0.a().b(key, defaultValue);
        } catch (RemoteException e4) {
            boolean z2 = j9.a.f6132a;
            Log.e("j0", "getWithDefaultMethod:" + e4);
        }
        Intrinsics.checkNotNullExpressionValue(defaultValue, "get(...)");
        return defaultValue;
    }

    @Override // pa.b
    public final String e(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String str = "";
        try {
            d9.a aVar = (d9.a) f8708d.getValue();
            aVar.getClass();
            String str2 = l9.a.f7342a;
            String str3 = aVar.a().get(key);
            if (str3 != null) {
                str = str3;
            }
        } catch (Throwable th2) {
            String log = "getPropertyByProp Throwable error: " + th2;
            Intrinsics.checkNotNullParameter("ThubFrameworkProxy", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("ThubFrameworkProxy"), log);
            }
        }
        return TextUtils.isEmpty(str) ? defaultValue : str;
    }

    @Override // pa.b
    public final void f(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        e = name;
    }

    @Override // pa.b
    public final String g() {
        s8.a aVar = (s8.a) f8707c.getValue();
        aVar.getClass();
        ComponentName componentName = aVar.a(l9.a.e).a().topActivity;
        if (componentName != null) {
            return componentName.getClassName();
        }
        return null;
    }
}
