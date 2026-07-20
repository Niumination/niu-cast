package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import li.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends i {
    public final oi.s e;

    public o(oi.s sVar, oi.h hVar, CoroutineContext coroutineContext, int i8, ni.c cVar) {
        super(hVar, coroutineContext, i8, cVar);
        this.e = sVar;
    }

    @Override // pi.g
    public final g d(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        return new o(this.e, this.f8900d, coroutineContext, i8, cVar);
    }

    @Override // pi.i
    public final Object e(oi.i iVar, Continuation continuation) {
        Object objC = h0.c(new n(this, iVar, null), continuation);
        return objC == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
    }
}
