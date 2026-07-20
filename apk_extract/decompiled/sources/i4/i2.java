package i4;

import k3.r8;
import k3.t8;

/* JADX INFO: loaded from: classes.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5608b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5609c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2 f5610d;
    public w2 e;
    public h4.l f;

    public final w2 a() {
        w2 w2Var = this.f5610d;
        w2 w2Var2 = w2.STRONG;
        if (w2Var != null) {
            return w2Var;
        }
        if (w2Var2 != null) {
            return w2Var2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public final w2 b() {
        w2 w2Var = this.e;
        w2 w2Var2 = w2.STRONG;
        if (w2Var != null) {
            return w2Var;
        }
        if (w2Var2 != null) {
            return w2Var2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        int i8 = this.f5608b;
        if (i8 != -1) {
            aVarA.c(i8, "initialCapacity");
        }
        int i9 = this.f5609c;
        if (i9 != -1) {
            aVarA.c(i9, "concurrencyLevel");
        }
        w2 w2Var = this.f5610d;
        if (w2Var != null) {
            aVarA.d(r8.a(w2Var.toString()), "keyStrength");
        }
        w2 w2Var2 = this.e;
        if (w2Var2 != null) {
            aVarA.d(r8.a(w2Var2.toString()), "valueStrength");
        }
        if (this.f != null) {
            qf.c cVar = new qf.c();
            ((qf.c) aVarA.e).f9049d = cVar;
            aVarA.e = cVar;
            cVar.f9048c = "keyEquivalence";
        }
        return aVarA.toString();
    }
}
