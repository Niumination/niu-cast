package oh;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public t0(Continuation<? super t0> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return u0.b(null, null, this);
    }
}
