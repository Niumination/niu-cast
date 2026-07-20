package vq;

import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class v {
    public static final void a(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(h.a.a("Expected positive parallelism level, but got ", i10).toString());
        }
    }
}
