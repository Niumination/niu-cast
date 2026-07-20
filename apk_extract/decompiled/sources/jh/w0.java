package jh;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f6309b;

    public w0(o channel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f6308a = channel;
        this.f6309b = coroutineContext;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f6309b;
    }
}
