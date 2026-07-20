package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ik.i f6740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f6741b;

    public y(@os.l ik.i iVar, double d10) {
        kn.l0.p(iVar, "contentType");
        this.f6740a = iVar;
        this.f6741b = d10;
        if (0.0d > d10 || d10 > 1.0d) {
            throw new IllegalArgumentException(kn.l0.C("Quality should be in range [0, 1]: ", Double.valueOf(d10)).toString());
        }
    }

    public static /* synthetic */ y d(y yVar, ik.i iVar, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = yVar.f6740a;
        }
        if ((i10 & 2) != 0) {
            d10 = yVar.f6741b;
        }
        return yVar.c(iVar, d10);
    }

    @os.l
    public final ik.i a() {
        return this.f6740a;
    }

    public final double b() {
        return this.f6741b;
    }

    @os.l
    public final y c(@os.l ik.i iVar, double d10) {
        kn.l0.p(iVar, "contentType");
        return new y(iVar, d10);
    }

    @os.l
    public final ik.i e() {
        return this.f6740a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kn.l0.g(this.f6740a, yVar.f6740a) && kn.l0.g(Double.valueOf(this.f6741b), Double.valueOf(yVar.f6741b));
    }

    public final double f() {
        return this.f6741b;
    }

    public int hashCode() {
        return Double.hashCode(this.f6741b) + (this.f6740a.hashCode() * 31);
    }

    @os.l
    public String toString() {
        return "ContentTypeWithQuality(contentType=" + this.f6740a + ", quality=" + this.f6741b + ')';
    }

    public /* synthetic */ y(ik.i iVar, double d10, int i10, kn.w wVar) {
        this(iVar, (i10 & 2) != 0 ? 1.0d : d10);
    }
}
