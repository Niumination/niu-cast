package qg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f9119b = new u("HTTP");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f9120c = new u("HTTPS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9121a;

    public u(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f9121a = name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && Intrinsics.areEqual(this.f9121a, ((u) obj).f9121a);
    }

    public final int hashCode() {
        return this.f9121a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("ConnectorType(name="), this.f9121a, ')');
    }
}
