package va;

import vd.d0;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16805c = "p";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f16806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.q f16807b;

    public o[] a(int i10) {
        return b(fc.b.a.f6001u).a(i10);
    }

    public pg.m b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16805c, d0.f16917b);
            d0 d0Var = this.f16806a;
            if (d0Var != null) {
                return d0Var;
            }
            d0 d0Var2 = new d0();
            this.f16806a = d0Var2;
            return d0Var2;
        }
        dc.e.f(f16805c, "TranAospThermalManager");
        e8.q qVar = this.f16807b;
        if (qVar != null) {
            return qVar;
        }
        e8.q qVar2 = new e8.q();
        this.f16807b = qVar2;
        return qVar2;
    }
}
