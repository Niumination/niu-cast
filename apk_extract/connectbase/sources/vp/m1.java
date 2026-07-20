package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final String f17722g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(@os.l String str, @os.l a1 a1Var, @os.l op.h hVar, @os.l List<? extends c1> list, boolean z10) {
        super(a1Var, hVar, list, z10, null, 16, null);
        kn.l0.p(str, "presentableName");
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(hVar, "memberScope");
        kn.l0.p(list, "arguments");
        this.f17722g = str;
    }

    @Override // vp.w, vp.f0
    /* JADX INFO: renamed from: I0 */
    public f0 Q0(wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.w, vp.n1
    /* JADX INFO: renamed from: L0 */
    public n1 Q0(wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.w, vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return new m1(this.f17722g, this.f17750b, this.f17751c, this.f17752d, z10);
    }

    @Override // vp.w
    @os.l
    public String P0() {
        return this.f17722g;
    }

    @Override // vp.w
    public w Q0(wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @os.l
    public m1 R0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }
}
