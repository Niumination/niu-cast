package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class w extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a1 f17750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final op.h f17751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<c1> f17752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f17754f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @in.j
    public w(@os.l a1 a1Var, @os.l op.h hVar) {
        this(a1Var, hVar, null, false, null, 28, null);
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(hVar, "memberScope");
    }

    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return this.f17752d;
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return this.f17750b;
    }

    @Override // vp.f0
    public boolean H0() {
        return this.f17753e;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return new w(G0(), o(), F0(), z10, null, 16, null);
    }

    @Override // vp.n1
    @os.l
    public n0 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return this;
    }

    @os.l
    public String P0() {
        return this.f17754f;
    }

    @Override // vp.n1
    @os.l
    public w Q0(@os.l wp.g gVar) {
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
        return this.f17751c;
    }

    @Override // vp.n0
    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(G0());
        sb2.append(F0().isEmpty() ? "" : nm.h0.l3(F0(), ", ", "<", ">", -1, "...", null));
        return sb2.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @in.j
    public w(@os.l a1 a1Var, @os.l op.h hVar, @os.l List<? extends c1> list, boolean z10) {
        this(a1Var, hVar, list, z10, null, 16, null);
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(hVar, "memberScope");
        kn.l0.p(list, "arguments");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @in.j
    public w(@os.l a1 a1Var, @os.l op.h hVar, @os.l List<? extends c1> list, boolean z10, @os.l String str) {
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(hVar, "memberScope");
        kn.l0.p(list, "arguments");
        kn.l0.p(str, "presentableName");
        this.f17750b = a1Var;
        this.f17751c = hVar;
        this.f17752d = list;
        this.f17753e = z10;
        this.f17754f = str;
    }

    public w(a1 a1Var, op.h hVar, List list, boolean z10, String str, int i10, kn.w wVar) {
        this(a1Var, hVar, (i10 & 4) != 0 ? nm.k0.INSTANCE : list, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? "???" : str);
    }
}
