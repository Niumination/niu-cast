package jq;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final tn.l f8862b;

    public m(@os.l String str, @os.l tn.l lVar) {
        kn.l0.p(str, "value");
        kn.l0.p(lVar, "range");
        this.f8861a = str;
        this.f8862b = lVar;
    }

    public static /* synthetic */ m d(m mVar, String str, tn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mVar.f8861a;
        }
        if ((i10 & 2) != 0) {
            lVar = mVar.f8862b;
        }
        return mVar.c(str, lVar);
    }

    @os.l
    public final String a() {
        return this.f8861a;
    }

    @os.l
    public final tn.l b() {
        return this.f8862b;
    }

    @os.l
    public final m c(@os.l String str, @os.l tn.l lVar) {
        kn.l0.p(str, "value");
        kn.l0.p(lVar, "range");
        return new m(str, lVar);
    }

    @os.l
    public final tn.l e() {
        return this.f8862b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kn.l0.g(this.f8861a, mVar.f8861a) && kn.l0.g(this.f8862b, mVar.f8862b);
    }

    @os.l
    public final String f() {
        return this.f8861a;
    }

    public int hashCode() {
        return this.f8862b.hashCode() + (this.f8861a.hashCode() * 31);
    }

    @os.l
    public String toString() {
        return "MatchGroup(value=" + this.f8861a + ", range=" + this.f8862b + ')';
    }
}
