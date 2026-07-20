package p9;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13034c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13035d = "application info should not be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qc.b f13036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x6.b f13037b;

    public int a(ApplicationInfo applicationInfo) {
        return b(fc.b.a.f5998r).h(applicationInfo);
    }

    public jf.b b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13034c, "TranThubApplicationInfo");
            qc.b bVar = this.f13036a;
            if (bVar != null) {
                return bVar;
            }
            qc.b bVar2 = new qc.b();
            this.f13036a = bVar2;
            return bVar2;
        }
        dc.e.f(f13034c, "TranAospApplicationInfo");
        x6.b bVar3 = this.f13037b;
        if (bVar3 != null) {
            return bVar3;
        }
        x6.b bVar4 = new x6.b();
        this.f13037b = bVar4;
        return bVar4;
    }

    public boolean c(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.F).a(applicationInfo);
        }
        throw new IllegalArgumentException("param cannot be null");
    }

    public boolean d(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.f5989i).g(applicationInfo);
        }
        throw new IllegalArgumentException(f13035d);
    }

    public boolean e(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.F).i(applicationInfo);
        }
        throw new IllegalArgumentException("param cannot be null");
    }

    public boolean f(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.C).f(applicationInfo);
        }
        throw new IllegalArgumentException("param cannot be null");
    }

    public boolean g(@gm.i ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.f5987g).c(applicationInfo);
        }
        throw new IllegalArgumentException(f13035d);
    }

    public boolean h(@gm.i ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.f5987g).d(applicationInfo);
        }
        throw new IllegalArgumentException(f13035d);
    }

    public boolean i(@gm.i ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.f5987g).b(applicationInfo);
        }
        throw new IllegalArgumentException(f13035d);
    }

    public boolean j(@gm.i ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            return b(fc.b.a.f5987g).e(applicationInfo);
        }
        throw new IllegalArgumentException(f13035d);
    }
}
