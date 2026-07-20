package se;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class w5 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ z5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w5(z5 z5Var, Continuation<? super w5> continuation) {
        super(continuation);
        this.this$0 = z5Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(0, null, this);
    }
}
