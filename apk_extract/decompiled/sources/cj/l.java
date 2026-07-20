package cj;

import k3.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements bj.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bj.c f1726b;

    public l(String serialName, bj.c kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.f1725a = serialName;
        this.f1726b = kind;
    }

    @Override // bj.d
    public final int b() {
        return 0;
    }

    @Override // bj.d
    public final String c(int i8) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bj.d
    public final bj.d d(int i8) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bj.d
    public final String e() {
        return this.f1725a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (Intrinsics.areEqual(this.f1725a, lVar.f1725a)) {
            if (Intrinsics.areEqual(this.f1726b, lVar.f1726b)) {
                return true;
            }
        }
        return false;
    }

    @Override // bj.d
    public final e1 getKind() {
        return this.f1726b;
    }

    public final int hashCode() {
        return (this.f1726b.hashCode() * 31) + this.f1725a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("PrimitiveDescriptor("), this.f1725a, ')');
    }
}
