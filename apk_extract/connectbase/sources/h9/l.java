package h9;

import ic.h1;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7049c = "l";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h1 f7050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.n f7051b;

    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        b(fc.b.a.f5989i).a(str);
    }

    public bf.i b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7049c, "TranThubAlarmManager");
            h1 h1Var = this.f7050a;
            if (h1Var != null) {
                return h1Var;
            }
            h1 h1Var2 = new h1();
            this.f7050a = h1Var2;
            return h1Var2;
        }
        dc.e.f(f7049c, "TranAospAlarmManager");
        p6.n nVar = this.f7051b;
        if (nVar != null) {
            return nVar;
        }
        p6.n nVar2 = new p6.n();
        this.f7051b = nVar2;
        return nVar2;
    }
}
