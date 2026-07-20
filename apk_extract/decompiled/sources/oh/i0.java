package oh;

import k3.bc;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;
import li.o1;
import li.p1;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements s0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f8487h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(i0.class, "maxFrameSize", "getMaxFrameSize()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(i0.class, "masking", "getMasking()Z", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ni.m f8488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f8489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f8490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1 f8491d;
    public final r0 e;

    public i0(jh.o input, jh.j0 output, long j8, boolean z2, CoroutineContext coroutineContext) {
        nh.b pool = ah.a.f799a;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        r1 r1Var = new r1((p1) coroutineContext.get(o1.f7483a));
        this.f8488a = bc.a(0, 6, null);
        CoroutineContext coroutineContextPlus = coroutineContext.plus(r1Var).plus(new li.f0("raw-ws"));
        this.f8489b = coroutineContextPlus;
        Delegates delegates = Delegates.INSTANCE;
        this.f8490c = new h0(Long.valueOf(j8), this, 0);
        new h0(Boolean.valueOf(z2), this, 1);
        this.f8491d = new a1(output, coroutineContextPlus, z2, pool);
        this.e = new r0(input, coroutineContextPlus, j8, pool);
        li.l0.p(this, null, null, new g0(this, null), 3);
        r1Var.r0();
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        Object objR = w().r(sVar, continuationImpl);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f8490c.setValue(this, f8487h[0], Long.valueOf(j8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oh.s0
    public final long N() {
        return ((Number) this.f8490c.getValue(this, f8487h[0])).longValue();
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8489b;
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) throws Throwable {
        Object objL = this.f8491d.l(continuationImpl);
        return objL == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objL : Unit.INSTANCE;
    }

    @Override // oh.s0
    public final ni.f0 o() {
        return this.f8488a;
    }

    @Override // oh.s0
    public final ni.g0 w() {
        return this.f8491d.e;
    }
}
