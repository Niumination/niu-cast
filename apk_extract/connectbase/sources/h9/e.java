package h9;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7023c = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic.b f7024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.c f7025b;

    public String a(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        if (this.f7025b == null) {
            this.f7025b = new p6.c();
        }
        return this.f7025b.b(activity);
    }

    public bf.b b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7023c, "TranThubActivity");
            ic.b bVar = this.f7024a;
            if (bVar != null) {
                return bVar;
            }
            ic.b bVar2 = new ic.b();
            this.f7024a = bVar2;
            return bVar2;
        }
        dc.e.f(f7023c, "TranAospActivity");
        p6.c cVar = this.f7025b;
        if (cVar != null) {
            return cVar;
        }
        p6.c cVar2 = new p6.c();
        this.f7025b = cVar2;
        return cVar2;
    }

    @Deprecated
    public void c(int i10, String str, String str2, String str3, boolean z10) throws ac.a {
        if (i10 < 0 || i10 > 100) {
            throw new IllegalArgumentException("sceneID must be between 0 and 100");
        }
        if (str == null || str2 == null || str3 == null) {
            throw new IllegalArgumentException("param cannot be null");
        }
        b(fc.b.a.f6001u).c(i10, str, str2, str3, z10);
    }

    public void d(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("alertActivity cannot be null");
        }
        b(fc.b.a.f5998r).a(obj);
    }
}
