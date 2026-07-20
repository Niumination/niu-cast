package jh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f6280b;

    public a(Throwable th2) {
        this.f6280b = th2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.f6280b, ((a) obj).f6280b);
    }

    public final int hashCode() {
        Throwable th2 = this.f6280b;
        if (th2 == null) {
            return 0;
        }
        return th2.hashCode();
    }

    public final String toString() {
        return "Closed(cause=" + this.f6280b + ')';
    }
}
