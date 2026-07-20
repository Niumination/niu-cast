package jh;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f6313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f6314b;

    public z0(j0 channel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f6313a = channel;
        this.f6314b = coroutineContext;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f6314b;
    }
}
