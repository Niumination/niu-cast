package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.d0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oi.h f8900d;

    public i(oi.h hVar, CoroutineContext coroutineContext, int i8, ni.c cVar) {
        super(coroutineContext, i8, cVar);
        this.f8900d = hVar;
    }

    @Override // pi.g, oi.h
    public final Object a(oi.i iVar, Continuation continuation) {
        if (this.f8898b == -3) {
            CoroutineContext coroutineContext = continuation.get$context();
            Boolean bool = Boolean.FALSE;
            ag.q qVar = new ag.q(8);
            CoroutineContext coroutineContext2 = this.f8897a;
            CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext2.fold(bool, qVar)).booleanValue() ? coroutineContext.plus(coroutineContext2) : li.y.a(coroutineContext, coroutineContext2, false);
            if (Intrinsics.areEqual(coroutineContextPlus, coroutineContext)) {
                Object objE = e(iVar, continuation);
                return objE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objE : Unit.INSTANCE;
            }
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(coroutineContextPlus.get(companion), coroutineContext.get(companion))) {
                CoroutineContext coroutineContext3 = continuation.get$context();
                if (!(iVar instanceof y) && !(iVar instanceof u)) {
                    iVar = new b0(iVar, coroutineContext3);
                }
                Object objB = c.b(coroutineContextPlus, iVar, qi.z.b(coroutineContextPlus), new h(this, null), continuation);
                return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
            }
        }
        Object objA = super.a(iVar, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // pi.g
    public final Object c(d0 d0Var, Continuation continuation) {
        Object objE = e(new y(d0Var), continuation);
        return objE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objE : Unit.INSTANCE;
    }

    public abstract Object e(oi.i iVar, Continuation continuation);

    @Override // pi.g
    public final String toString() {
        return this.f8900d + " -> " + super.toString();
    }
}
