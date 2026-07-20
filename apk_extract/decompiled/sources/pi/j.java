package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends i {
    @Override // pi.g
    public final g d(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        return new j(this.f8900d, coroutineContext, i8, cVar);
    }

    @Override // pi.i
    public final Object e(oi.i iVar, Continuation continuation) {
        Object objA = this.f8900d.a(iVar, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
