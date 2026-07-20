package ma;

import android.app.admin.DevicePolicyManager;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10615c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public md.a f10616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v7.a f10617b;

    @yb.a(level = 1)
    public int a(int i10) {
        return f(fc.b.a.f5982b).g(i10);
    }

    public DevicePolicyManager b() {
        return f(fc.b.a.f5989i).c();
    }

    public long c(int i10) {
        return f(fc.b.a.f5988h).i(i10);
    }

    public long d(long j10, int i10) {
        return f(fc.b.a.f6001u).f(j10, i10);
    }

    public boolean e(int i10) {
        return f(fc.b.a.f5988h).h(i10);
    }

    public gg.c f(String str) {
        if (fc.b.b(str)) {
            md.a aVar = this.f10616a;
            if (aVar != null) {
                return aVar;
            }
            md.a aVar2 = new md.a();
            this.f10616a = aVar2;
            return aVar2;
        }
        v7.a aVar3 = this.f10617b;
        if (aVar3 != null) {
            return aVar3;
        }
        v7.a aVar4 = new v7.a();
        this.f10617b = aVar4;
        return aVar4;
    }

    @yb.a(level = 3)
    public String g(String str, int i10) {
        return f(fc.b.a.f5988h).b(str, i10);
    }

    @yb.a(level = 1)
    public boolean h(int i10) {
        return f(fc.b.a.f5982b).e(i10);
    }

    public void i(boolean z10, int i10) {
        f(fc.b.a.f6001u).a(z10, i10);
    }

    @yb.a(level = 3)
    public void j(String str, String str2, int i10) {
        f(fc.b.a.f5988h).d(str, str2, i10);
    }
}
