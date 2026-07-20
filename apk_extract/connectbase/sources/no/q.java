package no;

import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final vo.h f11768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Collection<a> f11769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11770c;

    public q(vo.h hVar, Collection collection, boolean z10, int i10, kn.w wVar) {
        this(hVar, collection, (i10 & 4) != 0 ? hVar.f17620a == vo.g.NOT_NULL : z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q b(q qVar, vo.h hVar, Collection collection, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = qVar.f11768a;
        }
        if ((i10 & 2) != 0) {
            collection = qVar.f11769b;
        }
        if ((i10 & 4) != 0) {
            z10 = qVar.f11770c;
        }
        return qVar.a(hVar, collection, z10);
    }

    @os.l
    public final q a(@os.l vo.h hVar, @os.l Collection<? extends a> collection, boolean z10) {
        l0.p(hVar, "nullabilityQualifier");
        l0.p(collection, "qualifierApplicabilityTypes");
        return new q(hVar, collection, z10);
    }

    public final boolean c() {
        return this.f11770c;
    }

    @os.l
    public final vo.h d() {
        return this.f11768a;
    }

    @os.l
    public final Collection<a> e() {
        return this.f11769b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return l0.g(this.f11768a, qVar.f11768a) && l0.g(this.f11769b, qVar.f11769b) && this.f11770c == qVar.f11770c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = (this.f11769b.hashCode() + (this.f11768a.hashCode() * 31)) * 31;
        boolean z10 = this.f11770c;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    @os.l
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f11768a + ", qualifierApplicabilityTypes=" + this.f11769b + ", definitelyNotNull=" + this.f11770c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@os.l vo.h hVar, @os.l Collection<? extends a> collection, boolean z10) {
        l0.p(hVar, "nullabilityQualifier");
        l0.p(collection, "qualifierApplicabilityTypes");
        this.f11768a = hVar;
        this.f11769b = collection;
        this.f11770c = z10;
    }
}
