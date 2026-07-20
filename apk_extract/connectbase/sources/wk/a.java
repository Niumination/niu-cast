package wk;

import ik.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final w f19586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final w f19587c;

    public a(@os.l w wVar, @os.l w wVar2) {
        kn.l0.p(wVar, "first");
        kn.l0.p(wVar2, y1.o.r.f20674f);
        this.f19586b = wVar;
        this.f19587c = wVar2;
    }

    public static /* synthetic */ a g(a aVar, w wVar, w wVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            wVar = aVar.f19586b;
        }
        if ((i10 & 2) != 0) {
            wVar2 = aVar.f19587c;
        }
        return aVar.f(wVar, wVar2);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        x xVarA = this.f19586b.a(j0Var, i10);
        if (!xVarA.f19681a) {
            return xVarA;
        }
        x xVarA2 = this.f19587c.a(j0Var, i10 + xVarA.f19684d);
        if (!xVarA2.f19681a) {
            return xVarA2;
        }
        return new x(true, xVarA2.f19682b * xVarA.f19682b, e1.e(xVarA.f19683c, xVarA2.f19683c), xVarA.f19684d + xVarA2.f19684d);
    }

    @os.l
    public final w d() {
        return this.f19586b;
    }

    @os.l
    public final w e() {
        return this.f19587c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kn.l0.g(this.f19586b, aVar.f19586b) && kn.l0.g(this.f19587c, aVar.f19587c);
    }

    @os.l
    public final a f(@os.l w wVar, @os.l w wVar2) {
        kn.l0.p(wVar, "first");
        kn.l0.p(wVar2, y1.o.r.f20674f);
        return new a(wVar, wVar2);
    }

    @os.l
    public final w h() {
        return this.f19586b;
    }

    public int hashCode() {
        return this.f19587c.hashCode() + (this.f19586b.hashCode() * 31);
    }

    @os.l
    public final w i() {
        return this.f19587c;
    }

    @os.l
    public String toString() {
        return "{" + this.f19586b + " & " + this.f19587c + rs.f.f14860b;
    }
}
