package ni;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f8324a;

    public s(Throwable th2) {
        this.f8324a = th2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            if (Intrinsics.areEqual(this.f8324a, ((s) obj).f8324a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th2 = this.f8324a;
        if (th2 != null) {
            return th2.hashCode();
        }
        return 0;
    }

    @Override // ni.t
    public final String toString() {
        return "Closed(" + this.f8324a + ')';
    }
}
