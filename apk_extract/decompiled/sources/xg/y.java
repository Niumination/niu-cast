package xg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements mg.r, li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mg.r f10996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f10997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f10998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zf.d0 f10999d;
    public final qf.c e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u6.a f11000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f11001i;

    public y(mg.r engineCall, u route, CoroutineContext coroutineContext, vg.b receivePipeline, wg.b responsePipeline, zf.d0 pathParameters) {
        Intrinsics.checkNotNullParameter(engineCall, "engineCall");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(receivePipeline, "receivePipeline");
        Intrinsics.checkNotNullParameter(responsePipeline, "responsePipeline");
        Intrinsics.checkNotNullParameter(pathParameters, "pathParameters");
        this.f10996a = engineCall;
        this.f10997b = route;
        this.f10998c = coroutineContext;
        this.f10999d = pathParameters;
        this.e = new qf.c(this, receivePipeline, engineCall.g());
        this.f11000h = new u6.a(this, responsePipeline, engineCall.k());
        this.f11001i = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new ag.a(this, 21));
    }

    @Override // mg.b
    public final Object B(Object obj, ih.a aVar, ContinuationImpl continuationImpl) {
        return mg.l.a(this, obj, aVar, continuationImpl);
    }

    @Override // mg.b
    public final vg.c g() {
        return this.e;
    }

    @Override // mg.b
    public final mg.a getApplication() {
        return this.f10996a.getApplication();
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10998c;
    }

    @Override // mg.b
    public final zf.d0 getParameters() {
        return (zf.d0) this.f11001i.getValue();
    }

    @Override // mg.b
    public final zg.h i() {
        return this.f10996a.i();
    }

    @Override // mg.b
    public final wg.a k() {
        return this.f11000h;
    }

    public final String toString() {
        return "RoutingApplicationCall(route=" + this.f10997b + ')';
    }

    @Override // mg.r, mg.b
    public final vg.e g() {
        return this.e;
    }

    @Override // mg.r, mg.b
    public final wg.c k() {
        return this.f11000h;
    }
}
