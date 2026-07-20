package hj;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f5441a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i referent, Throwable th2) {
        super(referent);
        Intrinsics.checkNotNullParameter(referent, "referent");
        this.f5441a = th2;
    }
}
