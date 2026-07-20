package bg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements nh.d {
    @Override // nh.d
    public final Object R() {
        return new char[2048];
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    @Override // nh.d
    public final void h0(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }
}
