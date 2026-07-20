package vp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17721a;

    @Override // vp.a1
    @os.l
    public abstract eo.h d();

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1) || obj.hashCode() != hashCode()) {
            return false;
        }
        a1 a1Var = (a1) obj;
        if (a1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        eo.h hVarD = d();
        eo.h hVarD2 = a1Var.d();
        if (hVarD2 != null && g(hVarD) && g(hVarD2)) {
            return h(hVarD2);
        }
        return false;
    }

    public final boolean f(@os.l eo.h hVar, @os.l eo.h hVar2) {
        kn.l0.p(hVar, "first");
        kn.l0.p(hVar2, y1.o.r.f20674f);
        if (!kn.l0.g(hVar.getName(), hVar2.getName())) {
            return false;
        }
        eo.m mVarB = hVar.b();
        for (eo.m mVarB2 = hVar2.b(); mVarB != null && mVarB2 != null; mVarB2 = mVarB2.b()) {
            if (mVarB instanceof eo.h0) {
                return mVarB2 instanceof eo.h0;
            }
            if (mVarB2 instanceof eo.h0) {
                return false;
            }
            if (mVarB instanceof eo.k0) {
                return (mVarB2 instanceof eo.k0) && kn.l0.g(((eo.k0) mVarB).e(), ((eo.k0) mVarB2).e());
            }
            if ((mVarB2 instanceof eo.k0) || !kn.l0.g(mVarB.getName(), mVarB2.getName())) {
                return false;
            }
            mVarB = mVarB.b();
        }
        return true;
    }

    public final boolean g(eo.h hVar) {
        return (x.r(hVar) || hp.d.E(hVar)) ? false : true;
    }

    public abstract boolean h(@os.l eo.h hVar);

    public int hashCode() {
        int i10 = this.f17721a;
        if (i10 != 0) {
            return i10;
        }
        eo.h hVarD = d();
        int iHashCode = g(hVarD) ? hp.d.m(hVarD).f3815a.hashCode() : System.identityHashCode(this);
        this.f17721a = iHashCode;
        return iHashCode;
    }
}
