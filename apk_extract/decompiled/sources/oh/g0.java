package oh;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends SuspendLambda implements Function2 {
    Object L$0;
    int label;
    final /* synthetic */ i0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(i0 i0Var, Continuation<? super g0> continuation) {
        super(2, continuation);
        this.this$0 = i0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g0(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0067 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0070 A[Catch: all -> 0x003b, CancellationException -> 0x003d, f0 -> 0x003f, w -> 0x0041, TRY_LEAVE, TryCatch #5 {CancellationException -> 0x003d, f0 -> 0x003f, blocks: (B:19:0x0037, B:34:0x005d, B:37:0x0068, B:39:0x0070, B:30:0x0048, B:33:0x004f), top: B:64:0x000c, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0082 -> B:34:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
