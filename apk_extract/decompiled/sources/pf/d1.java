package pf;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import m3.g6;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends SuspendLambda implements Function3 {
    final /* synthetic */ Long $connectTimeoutMillis;
    final /* synthetic */ Long $requestTimeoutMillis;
    final /* synthetic */ Long $socketTimeoutMillis;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(Long l4, Long l8, Long l10, Continuation<? super d1> continuation) {
        super(3, continuation);
        this.$requestTimeoutMillis = l4;
        this.$connectTimeoutMillis = l8;
        this.$socketTimeoutMillis = l10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            }
            if (i8 == 2) {
                ResultKt.throwOnFailure(obj);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        qf.f fVar = (qf.f) this.L$0;
        vf.c cVar = (vf.c) this.L$1;
        if (g6.b(cVar.f10557a.c()) || (cVar.f10560d instanceof uf.g)) {
            this.L$0 = null;
            this.label = 1;
            obj = fVar.f9056a.a(cVar, this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
        z0 key = z0.f8882a;
        Intrinsics.checkNotNullParameter(key, "key");
        zg.a aVar = mf.j.f8037a;
        zg.h hVar = cVar.f;
        Map map = (Map) hVar.d(aVar);
        a1 capability = (a1) (map != null ? map.get(key) : null);
        if (capability == null) {
            Long l4 = this.$requestTimeoutMillis;
            Long l8 = this.$connectTimeoutMillis;
            Long l10 = this.$socketTimeoutMillis;
            vj.b bVar = e1.f8838a;
            if (l4 != null || l8 != null || l10 != null) {
                capability = new a1();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(capability, "capability");
                ((Map) hVar.a(aVar, new ob.c(17))).put(key, capability);
            }
        }
        if (capability != null) {
            Long l11 = this.$connectTimeoutMillis;
            Long l12 = this.$socketTimeoutMillis;
            Long l13 = this.$requestTimeoutMillis;
            Long l14 = capability.f8823b;
            if (l14 != null) {
                l11 = l14;
            }
            a1.a(l11);
            capability.f8823b = l11;
            Long l15 = capability.f8824c;
            if (l15 != null) {
                l12 = l15;
            }
            a1.a(l12);
            capability.f8824c = l12;
            Long l16 = capability.f8822a;
            if (l16 != null) {
                l13 = l16;
            }
            a1.a(l13);
            capability.f8822a = l13;
            if (l13 != null && l13.longValue() != Long.MAX_VALUE) {
                cVar.e.A(new nf.q(li.l0.p(fVar, null, null, new c1(l13, cVar, cVar.e, null), 3), 1));
            }
        }
        this.L$0 = null;
        this.label = 2;
        obj = fVar.f9056a.a(cVar, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(qf.f fVar, vf.c cVar, Continuation<? super kf.c> continuation) {
        d1 d1Var = new d1(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, continuation);
        d1Var.L$0 = fVar;
        d1Var.L$1 = cVar;
        return d1Var.invokeSuspend(Unit.INSTANCE);
    }
}
