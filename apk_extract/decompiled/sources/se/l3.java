package se;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class l3 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ t3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(t3 t3Var, Continuation<? super l3> continuation) {
        super(continuation);
        this.this$0 = t3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
