package kj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qj.j f6895d;
    public static final qj.j e;
    public static final qj.j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final qj.j f6896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final qj.j f6897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final qj.j f6898i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qj.j f6900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.j f6901c;

    static {
        qj.j.Companion.getClass();
        f6895d = qj.i.b(":");
        e = qj.i.b(":status");
        f = qj.i.b(":method");
        f6896g = qj.i.b(":path");
        f6897h = qj.i.b(":scheme");
        f6898i = qj.i.b(":authority");
    }

    public d(qj.j name, qj.j value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f6900b = name;
        this.f6901c = value;
        this.f6899a = value.size() + name.size() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f6900b, dVar.f6900b) && Intrinsics.areEqual(this.f6901c, dVar.f6901c);
    }

    public final int hashCode() {
        qj.j jVar = this.f6900b;
        int iHashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        qj.j jVar2 = this.f6901c;
        return iHashCode + (jVar2 != null ? jVar2.hashCode() : 0);
    }

    public final String toString() {
        return this.f6900b.utf8() + ": " + this.f6901c.utf8();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String name, String value) {
        this(qj.i.b(name), qj.i.b(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        qj.j.Companion.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String value, qj.j name) {
        this(name, qj.i.b(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        qj.j.Companion.getClass();
    }
}
