package ni;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f8325b = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8326a;

    public static final Throwable a(Object obj) {
        s sVar = obj instanceof s ? (s) obj : null;
        if (sVar != null) {
            return sVar.f8324a;
        }
        return null;
    }

    public static final Object b(Object obj) {
        if (obj instanceof t) {
            return null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return Intrinsics.areEqual(this.f8326a, ((u) obj).f8326a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f8326a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f8326a;
        if (obj instanceof s) {
            return ((s) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
