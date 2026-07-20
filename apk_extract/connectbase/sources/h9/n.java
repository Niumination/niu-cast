package h9;

import ic.j1;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7055c = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j1 f7056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.p f7057b;

    public void a() {
        c(fc.b.a.f5999s).d();
    }

    public int b(String str) {
        return c(fc.b.a.f5999s).c(str);
    }

    public bf.k c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7055c, "TranThubFollowDisplayOrientationManager");
            j1 j1Var = this.f7056a;
            if (j1Var != null) {
                return j1Var;
            }
            j1 j1Var2 = new j1();
            this.f7056a = j1Var2;
            return j1Var2;
        }
        dc.e.f(f7055c, "TranAospFollowDisplayOrientationManager");
        p6.p pVar = this.f7057b;
        if (pVar != null) {
            return pVar;
        }
        p6.p pVar2 = new p6.p();
        this.f7057b = pVar2;
        return pVar2;
    }

    public void d() {
        c(fc.b.a.f5999s).e();
    }

    public boolean e(String str) {
        return c(fc.b.a.f5999s).f(str);
    }

    public Object f(String str, boolean z10) {
        return c(fc.b.a.f5999s).b(str, z10);
    }

    public Object g(String str, int i10) {
        return c(fc.b.a.f5999s).a(str, i10);
    }
}
