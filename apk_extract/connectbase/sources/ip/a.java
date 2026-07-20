package ip;

import fo.g;
import java.util.List;
import kn.l0;
import kn.w;
import nm.k0;
import op.h;
import os.l;
import vp.a1;
import vp.c1;
import vp.n0;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends n0 implements yp.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final c1 f8345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final b f8346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final g f8348e;

    public a(@l c1 c1Var, @l b bVar, boolean z10, @l g gVar) {
        l0.p(c1Var, "typeProjection");
        l0.p(bVar, "constructor");
        l0.p(gVar, "annotations");
        this.f8345b = c1Var;
        this.f8346c = bVar;
        this.f8347d = z10;
        this.f8348e = gVar;
    }

    @Override // vp.f0
    @l
    public List<c1> F0() {
        return k0.INSTANCE;
    }

    @Override // vp.f0
    public a1 G0() {
        return this.f8346c;
    }

    @Override // vp.f0
    public boolean H0() {
        return this.f8347d;
    }

    @l
    public b P0() {
        return this.f8346c;
    }

    @Override // vp.n0
    @l
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public a N0(boolean z10) {
        return z10 == this.f8347d ? this : new a(this.f8345b, this.f8346c, z10, this.f8348e);
    }

    @Override // vp.n1
    @l
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public a Q0(@l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        c1 c1VarB = this.f8345b.b(gVar);
        l0.o(c1VarB, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(c1VarB, this.f8346c, this.f8347d, this.f8348e);
    }

    @Override // vp.n0
    @l
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public a O0(@l g gVar) {
        l0.p(gVar, "newAnnotations");
        return new a(this.f8345b, this.f8346c, this.f8347d, gVar);
    }

    @Override // fo.a
    @l
    public g getAnnotations() {
        return this.f8348e;
    }

    @Override // vp.f0
    @l
    public h o() {
        h hVarI = x.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        l0.o(hVarI, "createErrorScope(\n      …solution\", true\n        )");
        return hVarI;
    }

    @Override // vp.n0
    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Captured(");
        sb2.append(this.f8345b);
        sb2.append(')');
        sb2.append(this.f8347d ? "?" : "");
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(c1 c1Var, b bVar, boolean z10, g gVar, int i10, w wVar) {
        bVar = (i10 & 2) != 0 ? new c(c1Var) : bVar;
        z10 = (i10 & 4) != 0 ? false : z10;
        if ((i10 & 8) != 0) {
            g.f6167h.getClass();
            gVar = g.a.f6169b;
        }
        this(c1Var, bVar, z10, gVar);
    }
}
