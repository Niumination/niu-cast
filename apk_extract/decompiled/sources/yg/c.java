package yg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import ni.f0;
import ni.g0;
import oh.s;
import oh.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements l, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xg.r f11202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f11203b;

    public c(xg.r call, s0 delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f11202a = call;
        this.f11203b = delegate;
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        return this.f11203b.E(sVar, continuationImpl);
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f11203b.I(j8);
    }

    @Override // oh.s0
    public final long N() {
        return this.f11203b.N();
    }

    @Override // yg.l
    public final mg.b c() {
        return this.f11202a;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f11203b.getCoroutineContext();
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) {
        return this.f11203b.l(continuationImpl);
    }

    @Override // oh.s0
    public final f0 o() {
        return this.f11203b.o();
    }

    @Override // oh.s0
    public final g0 w() {
        return this.f11203b.w();
    }
}
