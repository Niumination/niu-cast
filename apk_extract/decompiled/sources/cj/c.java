package cj;

import k3.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final bj.h f1701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f1702m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String name, int i8) {
        super(name, null, i8);
        Intrinsics.checkNotNullParameter(name, "name");
        this.f1701l = bj.h.f1351b;
        this.f1702m = LazyKt.lazy(new b(i8, name, this));
    }

    @Override // cj.k, bj.d
    public final bj.d d(int i8) {
        return ((bj.d[]) this.f1702m.getValue())[i8];
    }

    @Override // cj.k
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bj.d)) {
            return false;
        }
        bj.d dVar = (bj.d) obj;
        if (dVar.getKind() != bj.h.f1351b) {
            return false;
        }
        return Intrinsics.areEqual(this.f1716a, dVar.e()) && Intrinsics.areEqual(i.a(this), i.a(dVar));
    }

    @Override // cj.k, bj.d
    public final e1 getKind() {
        return this.f1701l;
    }

    @Override // cj.k
    public final int hashCode() {
        int iHashCode = this.f1716a.hashCode();
        Intrinsics.checkNotNullParameter(this, "<this>");
        bj.f fVar = new bj.f(this);
        int iHashCode2 = 1;
        while (fVar.hasNext()) {
            int i8 = iHashCode2 * 31;
            String str = (String) fVar.next();
            iHashCode2 = i8 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // cj.k
    public final String toString() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return CollectionsKt___CollectionsKt.joinToString$default(new bj.g(this), ", ", this.f1716a.concat("("), ")", 0, null, null, 56, null);
    }
}
