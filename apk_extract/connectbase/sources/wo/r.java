package wo;

import eo.a1;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements tp.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final p f19819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final rp.s<cp.e> f19820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final tp.f f19822e;

    public r(@os.l p pVar, @os.m rp.s<cp.e> sVar, boolean z10, @os.l tp.f fVar) {
        l0.p(pVar, "binaryClass");
        l0.p(fVar, "abiStability");
        this.f19819b = pVar;
        this.f19820c = sVar;
        this.f19821d = z10;
        this.f19822e = fVar;
    }

    @Override // tp.g
    @os.l
    public String a() {
        return "Class '" + this.f19819b.f().b().b() + '\'';
    }

    @Override // eo.z0
    @os.l
    public a1 b() {
        a1 a1Var = a1.f4590a;
        l0.o(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @os.l
    public final p d() {
        return this.f19819b;
    }

    @os.l
    public String toString() {
        return ((Object) r.class.getSimpleName()) + ": " + this.f19819b;
    }
}
