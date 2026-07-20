package zf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f11560d = new y("HTTP", 2, 0);
    public static final y e = new y("HTTP", 1, 1);
    public static final y f = new y("HTTP", 1, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11563c;

    static {
        new y("SPDY", 3, 0);
        new y("QUIC", 1, 0);
    }

    public y(String name, int i8, int i9) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f11561a = name;
        this.f11562b = i8;
        this.f11563c = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual(this.f11561a, yVar.f11561a) && this.f11562b == yVar.f11562b && this.f11563c == yVar.f11563c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11563c) + a1.a.c(this.f11562b, this.f11561a.hashCode() * 31, 31);
    }

    public final String toString() {
        return this.f11561a + '/' + this.f11562b + '.' + this.f11563c;
    }
}
