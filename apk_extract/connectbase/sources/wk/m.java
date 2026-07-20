package wk;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final w f19641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final w f19642c;

    public m(@os.l w wVar, @os.l w wVar2) {
        kn.l0.p(wVar, "first");
        kn.l0.p(wVar2, y1.o.r.f20674f);
        this.f19641b = wVar;
        this.f19642c = wVar2;
    }

    public static /* synthetic */ m g(m mVar, w wVar, w wVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            wVar = mVar.f19641b;
        }
        if ((i10 & 2) != 0) {
            wVar2 = mVar.f19642c;
        }
        return mVar.f(wVar, wVar2);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        x xVarA = this.f19641b.a(j0Var, i10);
        return xVarA.f19681a ? xVarA : this.f19642c.a(j0Var, i10);
    }

    @os.l
    public final w d() {
        return this.f19641b;
    }

    @os.l
    public final w e() {
        return this.f19642c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kn.l0.g(this.f19641b, mVar.f19641b) && kn.l0.g(this.f19642c, mVar.f19642c);
    }

    @os.l
    public final m f(@os.l w wVar, @os.l w wVar2) {
        kn.l0.p(wVar, "first");
        kn.l0.p(wVar2, y1.o.r.f20674f);
        return new m(wVar, wVar2);
    }

    @os.l
    public final w h() {
        return this.f19641b;
    }

    public int hashCode() {
        return this.f19642c.hashCode() + (this.f19641b.hashCode() * 31);
    }

    @os.l
    public final w i() {
        return this.f19642c;
    }

    @os.l
    public String toString() {
        return "{" + this.f19641b + " | " + this.f19642c + rs.f.f14860b;
    }
}
