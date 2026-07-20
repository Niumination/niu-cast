package h9;

import ic.q1;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7071c = "t";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q1 f7072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.u f7073b;

    public bf.q a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7071c, "TranThubUiModeManager");
            q1 q1Var = this.f7072a;
            if (q1Var != null) {
                return q1Var;
            }
            q1 q1Var2 = new q1();
            this.f7072a = q1Var2;
            return q1Var2;
        }
        dc.e.f(f7071c, "TranAospUiModeManager");
        p6.u uVar = this.f7073b;
        if (uVar != null) {
            return uVar;
        }
        p6.u uVar2 = new p6.u();
        this.f7073b = uVar2;
        return uVar2;
    }

    @yb.a(level = 1)
    public boolean b(boolean z10) {
        return a(fc.b.a.f5989i).a(z10);
    }
}
