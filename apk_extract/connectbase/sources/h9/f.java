package h9;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7026c = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic.c f7027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.d f7028b;

    public bf.c a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7026c, "TranThubActivityClient");
            ic.c cVar = this.f7027a;
            if (cVar != null) {
                return cVar;
            }
            ic.c cVar2 = new ic.c();
            this.f7027a = cVar2;
            return cVar2;
        }
        dc.e.f(f7026c, p6.d.f12938a);
        p6.d dVar = this.f7028b;
        if (dVar != null) {
            return dVar;
        }
        p6.d dVar2 = new p6.d();
        this.f7028b = dVar2;
        return dVar2;
    }

    public void b(Activity activity, boolean z10) {
        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        a(fc.b.a.H).a(activity, z10);
    }

    public void c(Activity activity, boolean z10) {
        if (fc.a.f()) {
            if (activity == null) {
                throw new IllegalArgumentException("activity is null");
            }
            a(fc.b.a.f6002v).b(activity, z10);
        }
    }
}
