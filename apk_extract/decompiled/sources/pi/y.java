package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f8911a;

    public y(d0 d0Var) {
        this.f8911a = d0Var;
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        Object objR = ((ni.r) this.f8911a).f8323d.r(obj, continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }
}
