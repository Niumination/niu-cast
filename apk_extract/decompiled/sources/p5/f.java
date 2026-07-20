package p5;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f8675b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f8676c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o4.g f8677a;

    public static f c() {
        f fVar;
        synchronized (f8675b) {
            u2.l.g(f8676c != null, "MlKitContext has not been initialized");
            fVar = f8676c;
            u2.l.e(fVar);
        }
        return fVar;
    }

    public final Object a(Class cls) {
        u2.l.g(f8676c == this, "MlKitContext has been deleted");
        u2.l.e(this.f8677a);
        return this.f8677a.a(cls);
    }

    public final Context b() {
        return (Context) a(Context.class);
    }
}
