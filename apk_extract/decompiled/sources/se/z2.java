package se;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z2(b3 b3Var, Continuation<? super z2> continuation) {
        super(continuation);
        this.this$0 = b3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return b3.a(this.this$0, null, null, null, this);
    }
}
