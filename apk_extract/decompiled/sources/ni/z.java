package ni;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends a {
    public Continuation e;

    @Override // ni.r, ni.g0
    public final Object f(Object obj) {
        start();
        return super.f(obj);
    }

    @Override // li.x1
    public final void l0() {
        ri.a.a(this.e, this);
    }

    @Override // ni.r, ni.g0
    public final boolean q(Throwable th2) {
        boolean zQ = super.q(th2);
        start();
        return zQ;
    }

    @Override // ni.r, ni.g0
    public final Object r(Object obj, Continuation continuation) {
        start();
        Object objR = super.r(obj, continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }
}
