package xg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements mg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f10984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f10985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f10986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zg.h f10987d;
    public final mg.a e;

    public r(y pipelineCall) {
        Intrinsics.checkNotNullParameter(pipelineCall, "pipelineCall");
        this.f10984a = pipelineCall;
        final int i8 = 0;
        this.f10985b = LazyKt.lazy(new Function0(this) { // from class: xg.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f10983b;

            {
                this.f10983b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i8) {
                    case 0:
                        r rVar = this.f10983b;
                        y yVar = rVar.f10984a;
                        return new z(yVar.f10999d, yVar.e, rVar);
                    default:
                        r rVar2 = this.f10983b;
                        return new i0(rVar2, rVar2.f10984a.f11000h);
                }
            }
        });
        final int i9 = 1;
        this.f10986c = LazyKt.lazy(new Function0(this) { // from class: xg.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f10983b;

            {
                this.f10983b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i9) {
                    case 0:
                        r rVar = this.f10983b;
                        y yVar = rVar.f10984a;
                        return new z(yVar.f10999d, yVar.e, rVar);
                    default:
                        r rVar2 = this.f10983b;
                        return new i0(rVar2, rVar2.f10984a.f11000h);
                }
            }
        });
        this.f10987d = pipelineCall.f10996a.i();
        this.e = pipelineCall.f10996a.getApplication();
        pipelineCall.getParameters();
        pipelineCall.getClass();
        pipelineCall.f10996a.getParameters();
        pipelineCall.getClass();
    }

    @Override // mg.b
    public final Object B(Object obj, ih.a aVar, ContinuationImpl continuationImpl) {
        y yVar = this.f10984a;
        yVar.getClass();
        Object objA = mg.l.a(yVar, obj, aVar, continuationImpl);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // mg.b
    public final vg.c g() {
        return (z) this.f10985b.getValue();
    }

    @Override // mg.b
    public final mg.a getApplication() {
        return this.e;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10984a.f10998c;
    }

    @Override // mg.b
    public final zg.h i() {
        return this.f10987d;
    }

    @Override // mg.b
    public final wg.a k() {
        return (i0) this.f10986c.getValue();
    }
}
