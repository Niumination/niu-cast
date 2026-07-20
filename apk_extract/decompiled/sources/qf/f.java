package qf;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import pf.m1;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f9056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f9057b;

    public f(m1 httpSendSender, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(httpSendSender, "httpSendSender");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f9056a = httpSendSender;
        this.f9057b = coroutineContext;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f9057b;
    }
}
