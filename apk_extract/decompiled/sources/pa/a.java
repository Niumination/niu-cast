package pa;

import android.os.RemoteException;
import android.util.Log;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m3.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8703a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f8704b = LazyKt.lazy(new ob.c(2));

    public static b h() {
        return (b) f8704b.getValue();
    }

    public static boolean j(String key) {
        boolean zA;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String str = l9.a.f7342a;
            zA = j0.a().a(key);
        } catch (RemoteException e) {
            boolean z2 = j9.a.f6132a;
            Log.e("j0", "getBooleanMethod:" + e);
            zA = false;
        }
        String log = "getProperty finalKey: " + key + " systemProperty: " + zA + " default: false";
        Intrinsics.checkNotNullParameter("FrameworkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("FrameworkProxy"), log);
        }
        return zA;
    }

    @Override // pa.b
    public final void a() {
        h().a();
    }

    @Override // pa.b
    public final void b(lc.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        h().b(callback);
    }

    @Override // pa.b
    public final void c(lc.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        h().c(callback);
    }

    @Override // pa.b
    public final String d(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return h().d(key, defaultValue);
    }

    @Override // pa.b
    public final String e(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return h().e(key, defaultValue);
    }

    @Override // pa.b
    public final void f(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        h().f(name);
    }

    @Override // pa.b
    public final String g() {
        return h().g();
    }

    public final String i(String key, String oldKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldKey, "oldKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String strD = d(key, "itIsNull");
        if (Intrinsics.areEqual(strD, "itIsNull")) {
            strD = d(oldKey, defaultValue);
            key = oldKey;
        }
        StringBuilder sbP = h0.a.p("getProperty finalKey: ", key, " systemProperty: ", strD, " default: ");
        sbP.append(defaultValue);
        String log = sbP.toString();
        Intrinsics.checkNotNullParameter("FrameworkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("FrameworkProxy"), log);
        }
        return strD;
    }

    public final String k(String key, String oldKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldKey, "oldKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String strE = e(key, "itIsNull");
        if (Intrinsics.areEqual(strE, "itIsNull")) {
            strE = e(oldKey, defaultValue);
            key = oldKey;
        }
        StringBuilder sbP = h0.a.p("getPropertyByProp finalKey: ", key, " appProperty: ", strE, " default: ");
        sbP.append(defaultValue);
        String log = sbP.toString();
        Intrinsics.checkNotNullParameter("FrameworkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("FrameworkProxy"), log);
        }
        return strE;
    }
}
