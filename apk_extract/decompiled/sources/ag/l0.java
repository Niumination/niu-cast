package ag;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public l0(Continuation<? super l0> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return m0.c(null, null, this);
    }
}
