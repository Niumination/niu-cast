package uf;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import ni.f0;
import ni.g0;
import oh.s;
import oh.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements s0, oh.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh.d f10425a;

    public d(kf.c call, oh.d delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f10425a = delegate;
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        return this.f10425a.E(sVar, continuationImpl);
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f10425a.I(j8);
    }

    @Override // oh.s0
    public final long N() {
        return this.f10425a.N();
    }

    @Override // oh.d
    public final void b0(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        this.f10425a.b0(negotiatedExtensions);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10425a.getCoroutineContext();
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) {
        return this.f10425a.l(continuationImpl);
    }

    @Override // oh.s0
    public final f0 o() {
        return this.f10425a.o();
    }

    @Override // oh.s0
    public final g0 w() {
        return this.f10425a.w();
    }
}
