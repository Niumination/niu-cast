package li;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 extends qi.v {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h2(CoroutineContext coroutineContext, Continuation continuation, int i8) {
        super(continuation, coroutineContext);
        this.e = i8;
    }

    @Override // li.x1
    public final boolean G(Throwable th2) {
        switch (this.e) {
            case 0:
                return false;
            default:
                if (th2 instanceof pi.p) {
                    return true;
                }
                return z(th2);
        }
    }
}
