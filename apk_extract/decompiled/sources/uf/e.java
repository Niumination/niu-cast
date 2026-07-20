package uf;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import ni.f0;
import ni.g0;
import oh.s;
import oh.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f10426a;

    public e(kf.c call, s0 session) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(session, "session");
        this.f10426a = session;
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        return this.f10426a.E(sVar, continuationImpl);
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f10426a.I(j8);
    }

    @Override // oh.s0
    public final long N() {
        return this.f10426a.N();
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10426a.getCoroutineContext();
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) {
        return this.f10426a.l(continuationImpl);
    }

    @Override // oh.s0
    public final f0 o() {
        return this.f10426a.o();
    }

    @Override // oh.s0
    public final g0 w() {
        return this.f10426a.w();
    }
}
