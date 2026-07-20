package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17680e = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a1 f17681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final op.h f17683d;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public f(@os.l a1 a1Var, boolean z10) {
        kn.l0.p(a1Var, "originalTypeVariable");
        this.f17681b = a1Var;
        this.f17682c = z10;
        op.h hVarH = x.h(kn.l0.C("Scope for stub type: ", a1Var));
        kn.l0.o(hVarH, "createErrorScope(\"Scope …: $originalTypeVariable\")");
        this.f17683d = hVarH;
    }

    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return nm.k0.INSTANCE;
    }

    @Override // vp.f0
    public boolean H0() {
        return this.f17682c;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return z10 == H0() ? this : Q0(z10);
    }

    @Override // vp.n1
    @os.l
    public n0 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return this;
    }

    @os.l
    public final a1 P0() {
        return this.f17681b;
    }

    @os.l
    public abstract f Q0(boolean z10);

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public f Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        fo.g.f6167h.getClass();
        return fo.g.a.f6169b;
    }

    @Override // vp.f0
    @os.l
    public op.h o() {
        return this.f17683d;
    }
}
