package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a1 f17726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<c1> f17727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final op.h f17729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final jn.l<wp.g, n0> f17730f;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(@os.l a1 a1Var, @os.l List<? extends c1> list, boolean z10, @os.l op.h hVar, @os.l jn.l<? super wp.g, ? extends n0> lVar) {
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(list, "arguments");
        kn.l0.p(hVar, "memberScope");
        kn.l0.p(lVar, "refinedTypeFactory");
        this.f17726b = a1Var;
        this.f17727c = list;
        this.f17728d = z10;
        this.f17729e = hVar;
        this.f17730f = lVar;
        if (hVar instanceof x.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + hVar + '\n' + a1Var);
        }
    }

    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return this.f17727c;
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return this.f17726b;
    }

    @Override // vp.f0
    public boolean H0() {
        return this.f17728d;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        if (z10 == this.f17728d) {
            return this;
        }
        return z10 ? new l0(this) : new j0(this);
    }

    @Override // vp.n1
    @os.l
    public n0 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return gVar.isEmpty() ? this : new k(this, gVar);
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public n0 Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        n0 n0VarInvoke = this.f17730f.invoke(gVar);
        return n0VarInvoke == null ? this : n0VarInvoke;
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
        return this.f17729e;
    }
}
