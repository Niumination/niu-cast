package yg;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import ni.f0;
import ni.g0;
import oh.s;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a, oh.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mg.b f11200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oh.k f11201b;

    public b(mg.b call, oh.k delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f11200a = call;
        this.f11201b = delegate;
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        return this.f11201b.E(sVar, continuationImpl);
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f11201b.I(j8);
    }

    @Override // oh.s0
    public final long N() {
        return this.f11201b.f8500a.N();
    }

    @Override // oh.d
    public final void b0(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        this.f11201b.b0(negotiatedExtensions);
    }

    @Override // yg.l
    public final mg.b c() {
        return this.f11200a;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f11201b.f8505i;
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) {
        return this.f11201b.l(continuationImpl);
    }

    @Override // oh.s0
    public final f0 o() {
        return this.f11201b.f8502c;
    }

    @Override // oh.s0
    public final g0 w() {
        return this.f11201b.f8503d;
    }
}
