package ni;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, Continuation<? super l> continuation) {
        super(continuation);
        this.this$0 = mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m mVar = this.this$0;
        AtomicLongFieldUpdater atomicLongFieldUpdater = m.f8295d;
        Object objD = mVar.D(null, 0, 0L, this);
        return objD == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objD : new u(objD);
    }
}
