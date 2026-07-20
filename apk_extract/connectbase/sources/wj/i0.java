package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends y1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vj.y2 f18727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t.a f18728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vj.n[] f18729e;

    public i0(vj.y2 y2Var, t.a aVar, vj.n[] nVarArr) {
        c1.h0.e(!y2Var.r(), "error must not be OK");
        this.f18727c = y2Var;
        this.f18728d = aVar;
        this.f18729e = nVarArr;
    }

    @b1.e
    public vj.y2 w() {
        return this.f18727c;
    }

    @Override // wj.y1, wj.s
    public void x(b1 b1Var) {
        b1Var.b("error", this.f18727c).b("progress", this.f18728d);
    }

    @Override // wj.y1, wj.s
    public void y(t tVar) {
        c1.h0.h0(!this.f18726b, "already started");
        this.f18726b = true;
        for (vj.n nVar : this.f18729e) {
            nVar.i(this.f18727c);
        }
        tVar.b(this.f18727c, this.f18728d, new vj.v1());
    }

    public i0(vj.y2 y2Var, vj.n[] nVarArr) {
        this(y2Var, t.a.PROCESSED, nVarArr);
    }
}
