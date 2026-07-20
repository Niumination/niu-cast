package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f10995b;

    public w(String value, x kind) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.f10994a = value;
        this.f10995b = kind;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual(this.f10994a, wVar.f10994a) && this.f10995b == wVar.f10995b;
    }

    public final int hashCode() {
        return this.f10995b.hashCode() + (this.f10994a.hashCode() * 31);
    }

    public final String toString() {
        return "RoutingPathSegment(value=" + this.f10994a + ", kind=" + this.f10995b + ')';
    }
}
