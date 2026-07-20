package el;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class l<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public S f4535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final k<S> f4537c;

    public l(@os.m S s10, boolean z10, @os.l k<S> kVar) {
        l0.p(kVar, "provider");
        this.f4535a = s10;
        this.f4536b = z10;
        this.f4537c = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ l e(l lVar, Object obj, boolean z10, k kVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = lVar.f4535a;
        }
        if ((i10 & 2) != 0) {
            z10 = lVar.f4536b;
        }
        if ((i10 & 4) != 0) {
            kVar = lVar.f4537c;
        }
        return lVar.d(obj, z10, kVar);
    }

    @os.m
    public final S a() {
        return this.f4535a;
    }

    public final boolean b() {
        return this.f4536b;
    }

    @os.l
    public final k<S> c() {
        return this.f4537c;
    }

    @os.l
    public final l<S> d(@os.m S s10, boolean z10, @os.l k<S> kVar) {
        l0.p(kVar, "provider");
        return new l<>(s10, z10, kVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return l0.g(this.f4535a, lVar.f4535a) && this.f4536b == lVar.f4536b && l0.g(this.f4537c, lVar.f4537c);
    }

    public final boolean f() {
        return this.f4536b;
    }

    @os.l
    public final k<S> g() {
        return this.f4537c;
    }

    @os.m
    public final S h() {
        return this.f4535a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        S s10 = this.f4535a;
        int iHashCode = (s10 == null ? 0 : s10.hashCode()) * 31;
        boolean z10 = this.f4536b;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return this.f4537c.hashCode() + ((iHashCode + r10) * 31);
    }

    public final void i(@os.m S s10) {
        this.f4535a = s10;
    }

    @os.l
    public String toString() {
        return "SessionProviderData(value=" + this.f4535a + ", incoming=" + this.f4536b + ", provider=" + this.f4537c + ')';
    }
}
