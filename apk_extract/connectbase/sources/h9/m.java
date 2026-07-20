package h9;

import ic.i1;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7052c = "m";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i1 f7053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.o f7054b;

    public int a(String str, int i10) {
        return b(fc.b.a.f5989i).a(str, i10);
    }

    public bf.j b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7052c, "TranThubAppGlobals");
            i1 i1Var = this.f7053a;
            if (i1Var != null) {
                return i1Var;
            }
            i1 i1Var2 = new i1();
            this.f7053a = i1Var2;
            return i1Var2;
        }
        dc.e.f(f7052c, "TranAospAppGlobals");
        p6.o oVar = this.f7054b;
        if (oVar != null) {
            return oVar;
        }
        p6.o oVar2 = new p6.o();
        this.f7054b = oVar2;
        return oVar2;
    }
}
