package wp;

import eo.e1;
import java.util.List;
import kn.l0;
import nm.k0;
import vp.a1;
import vp.c1;
import vp.n0;
import vp.n1;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends n0 implements yp.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final yp.b f19855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final j f19856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final n1 f19857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final fo.g f19858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f19859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19860g;

    public i(@os.l yp.b bVar, @os.l j jVar, @os.m n1 n1Var, @os.l fo.g gVar, boolean z10, boolean z11) {
        l0.p(bVar, "captureStatus");
        l0.p(jVar, "constructor");
        l0.p(gVar, "annotations");
        this.f19855b = bVar;
        this.f19856c = jVar;
        this.f19857d = n1Var;
        this.f19858e = gVar;
        this.f19859f = z10;
        this.f19860g = z11;
    }

    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return k0.INSTANCE;
    }

    @Override // vp.f0
    public a1 G0() {
        return this.f19856c;
    }

    @Override // vp.f0
    public boolean H0() {
        return this.f19859f;
    }

    @os.l
    public final yp.b P0() {
        return this.f19855b;
    }

    @os.l
    public j Q0() {
        return this.f19856c;
    }

    @os.m
    public final n1 R0() {
        return this.f19857d;
    }

    public final boolean S0() {
        return this.f19860g;
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public i N0(boolean z10) {
        return new i(this.f19855b, this.f19856c, this.f19857d, this.f19858e, z10, false, 32, null);
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public i Q0(@os.l g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        yp.b bVar = this.f19855b;
        j jVarJ = this.f19856c.b(gVar);
        n1 n1Var = this.f19857d;
        return new i(bVar, jVarJ, n1Var == null ? null : gVar.a(n1Var).J0(), this.f19858e, this.f19859f, false, 32, null);
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public i O0(@os.l fo.g gVar) {
        l0.p(gVar, "newAnnotations");
        return new i(this.f19855b, this.f19856c, this.f19857d, gVar, this.f19859f, false, 32, null);
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.f19858e;
    }

    @Override // vp.f0
    @os.l
    public op.h o() {
        op.h hVarI = vp.x.i("No member resolution should be done on captured type!", true);
        l0.o(hVarI, "createErrorScope(\"No mem…on captured type!\", true)");
        return hVarI;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(yp.b bVar, j jVar, n1 n1Var, fo.g gVar, boolean z10, boolean z11, int i10, kn.w wVar) {
        if ((i10 & 8) != 0) {
            fo.g.f6167h.getClass();
            gVar = fo.g.a.f6169b;
        }
        this(bVar, jVar, n1Var, gVar, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@os.l yp.b bVar, @os.m n1 n1Var, @os.l c1 c1Var, @os.l e1 e1Var) {
        this(bVar, new j(c1Var, null, null, e1Var, 6, null), n1Var, null, false, false, 56, null);
        l0.p(bVar, "captureStatus");
        l0.p(c1Var, "projection");
        l0.p(e1Var, "typeParameter");
    }
}
