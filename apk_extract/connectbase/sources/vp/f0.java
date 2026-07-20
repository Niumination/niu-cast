package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 implements fo.a, yp.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17684a;

    public f0() {
    }

    public final int E0() {
        if (h0.a(this)) {
            return super.hashCode();
        }
        return (H0() ? 1 : 0) + ((F0().hashCode() + (G0().hashCode() * 31)) * 31);
    }

    @os.l
    public abstract List<c1> F0();

    @os.l
    public abstract a1 G0();

    public abstract boolean H0();

    @os.l
    public abstract f0 I0(@os.l wp.g gVar);

    @os.l
    public abstract n1 J0();

    public final boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return H0() == f0Var.H0() && wp.r.f19875a.a(J0(), f0Var.J0());
    }

    public final int hashCode() {
        int i10 = this.f17684a;
        if (i10 != 0) {
            return i10;
        }
        int iE0 = E0();
        this.f17684a = iE0;
        return iE0;
    }

    @os.l
    public abstract op.h o();

    public f0(kn.w wVar) {
    }
}
