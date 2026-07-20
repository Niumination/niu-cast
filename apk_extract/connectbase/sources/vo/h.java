package vo;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g f17620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17621b;

    public h(@os.l g gVar, boolean z10) {
        l0.p(gVar, "qualifier");
        this.f17620a = gVar;
        this.f17621b = z10;
    }

    public static /* synthetic */ h b(h hVar, g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = hVar.f17620a;
        }
        if ((i10 & 2) != 0) {
            z10 = hVar.f17621b;
        }
        return hVar.a(gVar, z10);
    }

    @os.l
    public final h a(@os.l g gVar, boolean z10) {
        l0.p(gVar, "qualifier");
        return new h(gVar, z10);
    }

    @os.l
    public final g c() {
        return this.f17620a;
    }

    public final boolean d() {
        return this.f17621b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f17620a == hVar.f17620a && this.f17621b == hVar.f17621b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int iHashCode = this.f17620a.hashCode() * 31;
        boolean z10 = this.f17621b;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    @os.l
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f17620a + ", isForWarningOnly=" + this.f17621b + ')';
    }

    public /* synthetic */ h(g gVar, boolean z10, int i10, w wVar) {
        this(gVar, (i10 & 2) != 0 ? false : z10);
    }
}
